package information;


    public class file_bkp {
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
    }
