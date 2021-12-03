package information;

public class LineInformation {
        private double length;
        private int count;
        private double vectorX1;
        private double vectorX2;
        private double vectorY1;
        private double vectorY2;
        private double angle;
        public LineInformation() {
            this.length = 0.0;
            this.count = 0;
            this.angle = 0.0;
        }
        public void reset() {
            this.length = 0.0;
            this.count = 0;
            this.vectorX1 = 0.0;
            this.vectorX2 = 0.0;
            this.vectorY1 = 0.0;
            this.vectorY2 = 0.0;
        }
        public Double getLength() {
            return Math.round(this.length * 100.00) / 100.00;
        }
        public Integer getCount(){
            return this.count;
        }
        public void addLength(Double length){
            this.length = this.length + length;
            this.count++;
        }
        public void setVectorX1(Double vectorX1){
            this.vectorX1 = vectorX1;
        }
        public void setVectorX2(Double vectorX2){
            this.vectorX2 = vectorX2;
        }
        public void setVectorY1(Double vectorY1){
            this.vectorY1 = vectorY1;
        }
        public void setVectorY2(Double vectorY2){
            this.vectorY2 = vectorY2;
        }
        public void setAngle(Double angle){
            this.angle = angle;
        }
        public Double getVectorX1(){
            return this.vectorX1;
        }
        public Double getVectorX2(){
            return this.vectorX2;
        }
        public Double getVectorY1(){
            return this.vectorY1;
        }
        public Double getVectorY2(){
            return this.vectorY2;
        }
        public Double getAngle(){
            return this.angle;
        }
}

