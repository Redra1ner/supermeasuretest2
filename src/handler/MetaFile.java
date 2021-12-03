package handler;

import handler.Files;
import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class MetaFile implements Files {
    private String imageName;
    private String unit;
    private Double resolution;
    private String fileType;
    private String description;
    private String path;
    public void Files(String imageName, String unit, Double resolution, String fileType, String description, String path){
        this.imageName = imageName;
        this.unit = unit;
        this.resolution = resolution;
        this.fileType = fileType;
        this.description = description;
        this.path = path;
    }
    public String getImageName(){
        return this.imageName;
    }
    public String getUnit(){
        return this.unit;
    }
    public Double getResolution(){
        return this.resolution;
    }
    public String getFileType(){
        return  this.fileType;
    }
    public String getDescription(){
        return this.description;
    }
    public String getPath(){
        return this.path;
    }
    public void handleFile(File selectedFile){
        try {
            String filePath = selectedFile.getPath();
            Path directory = Paths.get(filePath).getParent();
            List<String> attributeName = new ArrayList<>();
            List<String> attributeValue = new ArrayList<>();

            Scanner fileReader = new Scanner(selectedFile);
            while (fileReader.hasNextLine()) {
                try {
                    String line = fileReader.nextLine();
                    Scanner lineReader = new Scanner(line);
                    lineReader.useDelimiter("###");
                    String nextLine = lineReader.next();
                    String [] lineValues = nextLine.split(Pattern.quote(":"));
                    String name = lineValues[0].trim();
                    String value = lineValues[1].trim();
                    attributeName.add(name);
                    attributeValue.add(value);
                } catch (NoSuchElementException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Fehlerhafte Meta-Datei");
                    alert.showAndWait();
                }
            }

            int indexFileName = attributeName.indexOf("image-file");
            int indexResolutionName = attributeName.indexOf("resolution");
            int indexDescription = attributeName.indexOf("description");
            String[] resolutionValue = attributeValue.get(indexResolutionName).split(" ");
            this.resolution = Double.parseDouble(resolutionValue[0]);
            this.unit = resolutionValue[1];
            this.imageName = attributeValue.get(indexFileName);
            this.fileType = "Meta-File";
            this.description = attributeValue.get(indexDescription);
            this.path = directory.toString();
        }
        catch (FileNotFoundException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("File not found");
            alert.showAndWait();
        }
    }
}
