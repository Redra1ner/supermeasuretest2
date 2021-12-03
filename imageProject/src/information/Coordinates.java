package information;

public class Coordinates {
        private double x0;
        private double y0;
        private double startX;
        private double startY;

    public void Coordinates(double x0, double y0, double startX, double startY){
        this.x0 = x0;
        this.y0 = y0;
        this.startX = startX;
        this.startY = startY;
    }
    public void setCoordinates(double x0, double y0){
        this.x0 = x0;
        this.y0 = y0;
    }
    public void setStartCoordinates(double startX, double startY){
        this.startX = startX;
        this.startY = startY;
    }
    public double getX0(){
        return this.x0;
    }
    public double getY0(){
        return this.y0;
    }
    public double getStartX(){
        return this.startX;
    }
    public double getStartY(){
        return this.startY;
    }

}
