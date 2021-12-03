package handler;

import java.io.File;


public class FileType {
    public static void handleMetaFile(File selectedFile){
        /*
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
                    lineReader.useDelimiter(":");
                    String name = lineReader.next();
                    String value = "";
                    value = lineReader.next();
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
            Double resolution = Double.parseDouble(resolutionValue[0]);
            String unit = resolutionValue[1];
            String imageName = attributeValue.get(indexFileName);
            String description = attributeValue.get(indexDescription);
            Files file = new Files(imageName, unit, resolution, "Meta-File", description, directory.toString());
            return file;
        }
        catch (FileNotFoundException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("File not found");
            alert.showAndWait();
            return null;
        }*/
    }
}
