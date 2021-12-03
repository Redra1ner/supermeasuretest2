package handler;

import java.io.File;

public interface Files {

    public void Files (String imageName, String unit, Double resolution, String fileType, String description, String path);
    public String getImageName();
    public String getUnit();
    public Double getResolution();
    public String getFileType();
    public String getDescription();
    public String getPath();
    public void handleFile(File selectedFile);
}
