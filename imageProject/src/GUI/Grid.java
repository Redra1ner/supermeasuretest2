package GUI;

import information.LineInformation;
import information.LoadedImage;
import information.ResolutionInformation;
import handler.Interaction;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class Grid {
    public static GridPane createGrid (Stage stage){
        ResolutionInformation resolutionInformation = new ResolutionInformation();
        LoadedImage loadedImage = new LoadedImage();
        LineInformation lineInformation = new LineInformation();
        ImageView viewImage = new ImageView();
        TextArea imageInfos = new TextArea();

        Button imageSelection = new Button("Select image");

        Line lineExample = new Line();
        lineExample.setStartX(5);
        lineExample.setEndX(200);
        lineExample.setStrokeWidth(4);

        Slider lineThickness = new Slider(1,20,4);

        ColorPicker pickColor = new ColorPicker(Color.BLACK);


        Button startMeasure = new Button("Start Messung");
        Button stopMeasure = new Button("Reset");

        GridPane leftGrid = new GridPane();

        GridPane.setConstraints(imageSelection,0,0);
        GridPane.setConstraints(imageInfos,0,1);
        GridPane.setConstraints(lineExample,0,2);
        GridPane.setConstraints(lineThickness,0,3);
        GridPane.setConstraints(startMeasure,0,4);
        GridPane.setConstraints(stopMeasure,0,5);
        GridPane.setConstraints(pickColor,0,6);

        ColumnConstraints column0 = new ColumnConstraints(100,200,300);

        RowConstraints row0 = new RowConstraints(40,50,60);
        RowConstraints row1 = new RowConstraints(50,100,800);
        RowConstraints row2 = new RowConstraints(40,50,60);
        RowConstraints row3 = new RowConstraints(40,50,60);
        RowConstraints row4 = new RowConstraints(40,50,60);
        RowConstraints row5 = new RowConstraints(40,50,60);
        RowConstraints row6 = new RowConstraints(40,50,60);

        leftGrid.getColumnConstraints().addAll(column0);
        leftGrid.getRowConstraints().addAll(row0,row1,row2,row3,row4,row5,row6);
        leftGrid.getChildren().addAll(imageSelection,imageInfos,lineExample,lineThickness,startMeasure,stopMeasure,pickColor);

        Pane rightGrid = new Pane();
        GridPane.setConstraints(viewImage,0,0);
        rightGrid.getChildren().addAll(viewImage);

        GridPane bottomGrid = new GridPane();
        Label lengthLabel = new Label("Length: ");
        Label lengthValue = new Label(lineInformation.getLength().toString());
        Label angleLabel = new Label("Angle: ");
        Label angleValue = new Label(lineInformation.getAngle().toString());
        GridPane.setConstraints(lengthLabel,0,0);
        GridPane.setConstraints(lengthValue,1,0);
        GridPane.setConstraints(angleLabel,0,1);
        GridPane.setConstraints(angleValue,1,1);
        bottomGrid.getChildren().addAll(lengthLabel,lengthValue,angleLabel, angleValue);

        GridPane mainGrid = new GridPane();
        GridPane.setConstraints(leftGrid,0,0);
        GridPane.setConstraints(rightGrid,1,0);
        GridPane.setConstraints(bottomGrid,0,1);
        ColumnConstraints leftConstraint = new ColumnConstraints(200,200,300);
        ColumnConstraints rightConstraint = new ColumnConstraints(500,500,900);
        mainGrid.getColumnConstraints().addAll(leftConstraint,rightConstraint);
        mainGrid.getChildren().addAll(leftGrid,rightGrid,bottomGrid);


        imageSelection.setOnAction(event -> {
            Interaction.loadImage(stage,loadedImage,viewImage,imageInfos,resolutionInformation,rightGrid, lengthValue);
        });

        lineThickness.valueProperty().addListener((observable,oldValue,newValue) ->{
            Interaction.chooseThickness(lineExample,lineThickness);
        });

        pickColor.setOnAction(event -> {
            Interaction.chooseColor(lineExample,pickColor);
        });
        startMeasure.setOnAction(event -> {
            Interaction.startMeasure(resolutionInformation,lineThickness.getValue(),pickColor.getValue(),viewImage,lengthValue,lineInformation, rightGrid, angleValue);
        });
        stopMeasure.setOnAction(event -> {
            Interaction.stopMeasure(rightGrid,viewImage,lengthValue,resolutionInformation, lineInformation, angleValue);
        });

        return mainGrid;
    }
}
