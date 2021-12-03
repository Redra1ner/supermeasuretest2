package handler;

import handler.Files;

import java.io.File;

public class DummyFile implements Files {
        public void Files (String imageName, String unit, Double resolution, String fileType, String description, String path){};
        public String getImageName(){return null;};
        public String getUnit(){return null;};
        public Double getResolution(){return null;};
        public String getFileType(){return null;};
        public String getDescription(){return null;};
        public String getPath(){return null;};
        public void handleFile(File selectedFile){};
}
