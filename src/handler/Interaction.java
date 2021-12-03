package handler;

import GUI.Grid;
import information.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class Interaction{
    public static void loadImage (Stage stage, LoadedImage loadedImage, ImageView viewImage, TextArea imageInfos, ResolutionInformation resolutionInformation, Pane rightGrid, Label lengthValue){
        try {
            FileChooser imageChooser = new FileChooser();
            File selectedFile = imageChooser.showOpenDialog(stage);
            String path = selectedFile.getPath();
            Files fileInfo = new DummyFile();
            if(path.endsWith(".txt")){
                fileInfo = new MetaFile();
                fileInfo.handleFile(selectedFile);
            }
            String infoText = "image: "+fileInfo.getImageName()+"\n"+"resolution: "+fileInfo.getResolution()+" "+fileInfo.getUnit()+"\n"+"description: "+fileInfo.getDescription()+"\n"+"filetype: "+fileInfo.getFileType();
            imageInfos.setText(infoText);
            imageInfos.autosize();
            String imagePath = fileInfo.getPath()+"\\"+fileInfo.getImageName();
            String unit = fileInfo.getUnit();
            Double resolution = fileInfo.getResolution();
            Image image = new Image("file:" + imagePath);
            loadedImage.setImage(image);


            if(image.getHeight()>image.getWidth()){
                if(image.getHeight()>=500){
                    viewImage.setFitHeight(500);
                    rightGrid.setMinHeight(500);
                }
                else{
                    viewImage.setFitHeight(image.getHeight());
                    rightGrid.setMinHeight(image.getHeight());
                }
            }
            else{
                if(image.getWidth()>=800){
                    viewImage.setFitWidth(800);
                    rightGrid.setMinWidth(800);
                }
                else{
                    viewImage.setFitWidth(image.getWidth());
                    rightGrid.setMinWidth(image.getWidth());
                }
            }

            viewImage.setPreserveRatio(true);
            viewImage.setImage(image);
            resolutionInformation.setResolution(unit,resolution);
            lengthValue.setText("0.0 "+unit);
        }
        catch(NullPointerException e){
            Grid.createGrid(stage);
        }
    }

    public static void chooseThickness (Line line, Slider lineThickness){
        line.setStrokeWidth(lineThickness.getValue());
    }

    public static void chooseColor (Line line, ColorPicker pickColor){
        Paint color = pickColor.getValue();
        line.setStroke(color);
    }

    public static void startMeasure(ResolutionInformation resolutionInformation, Double lineThickness, Color color, ImageView viewImage, Label lenghtValue, LineInformation lineInformation, Pane rightGrid, Label angleValue){
        Coordinates coordinates = new Coordinates();
        viewImage.setOnMousePressed(event -> {
            Double x0 = event.getX();
            Double y0 =  event.getY();
            coordinates.setCoordinates(x0,y0);
            if(lineInformation.getCount() == 0){
                coordinates.setStartCoordinates(x0,y0);
            }
        });
        viewImage.setOnMouseReleased(event -> {
            if(event.getX()<= viewImage.getImage().getWidth() && event.getY() <= viewImage.getImage().getHeight()) {
                Line drawLine = new Line(coordinates.getX0(), coordinates.getY0(), event.getX(), event.getY());
                drawLine.setStrokeWidth(lineThickness);
                drawLine.setStroke(color);
                rightGrid.getChildren().addAll(drawLine);
                Double length = 0.0;
                length = Math.sqrt(Math.pow(coordinates.getX0() - event.getX(), 2) + Math.pow(coordinates.getY0() - event.getY(), 2));
                length = length * resolutionInformation.getResolution();
                lineInformation.addLength(length);
                lenghtValue.setText(lineInformation.getLength().toString() + " " + resolutionInformation.getUnit());
                if(lineInformation.getCount()==1){
                    Double vectorY = coordinates.getY0() - event.getY();
                    if(event.getY()>coordinates.getStartY()) {
                        lineInformation.setVectorY1(-vectorY);
                    }
                    else{
                        lineInformation.setVectorY1(vectorY);
                    }
                    Double vectorX = event.getX() - coordinates.getX0();
                    if(event.getX()>coordinates.getStartX()) {
                        lineInformation.setVectorX1(-vectorX);
                    }
                    else{
                        lineInformation.setVectorX1(vectorX);
                    }
                }
                else if(lineInformation.getCount()==2){
                    Double vectorY = coordinates.getY0() - event.getY();
                    lineInformation.setVectorY2(vectorY);
                    Double vectorX = event.getX() - coordinates.getX0();
                    lineInformation.setVectorX2(vectorX);
                    System.out.println(lineInformation.getVectorX1());
                    System.out.println(lineInformation.getVectorY1());
                    System.out.println(lineInformation.getVectorX2());
                    System.out.println(lineInformation.getVectorY2());
                    double numerator = (lineInformation.getVectorX1()*lineInformation.getVectorX2())+(lineInformation.getVectorY1()*lineInformation.getVectorY2());

                    double magnitude1 = Math.sqrt(Math.pow(lineInformation.getVectorX1(),2)+Math.pow(lineInformation.getVectorY1(),2));
                    double magnitude2 = Math.sqrt(Math.pow(lineInformation.getVectorX2(),2)+Math.pow(lineInformation.getVectorY2(),2));
                    double denumerator = magnitude1*magnitude2;
                    double angle = 0.0;
                    System.out.println(denumerator);
                    System.out.println(numerator/denumerator);
                    angle = Math.round(Math.toDegrees( Math.acos(numerator/denumerator))*100);
                    System.out.println(angle);
                    lineInformation.setAngle(angle/100);
                    angleValue.setText(lineInformation.getAngle().toString());
                }
            }
        });
    }
    public static void stopMeasure(Pane rightGrid, ImageView imageView, Label lengthValue, ResolutionInformation resolutionInformation, LineInformation lineInformation, Label countValue){
        while (rightGrid.getChildren().listIterator().hasNext()){
            rightGrid.getChildren().remove(rightGrid.getChildren().listIterator().nextIndex());
        }
        rightGrid.getChildren().add(imageView);
        imageView.setOnMousePressed(event -> {});
        imageView.setOnMouseReleased(event -> {});
        lineInformation.reset();
        lengthValue.setText(lineInformation.getLength().toString());
        countValue.setText(lineInformation.getCount().toString());
    }
}
