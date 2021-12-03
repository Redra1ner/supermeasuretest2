package information;

public class ResolutionInformation {
    private String unit;
    private Double resolution;
    public void ResolutionInformation (String unit, Double resolution){
        this.unit = unit;
        this.resolution = resolution;
    }
    public void setResolution(String unit, Double resolution){
        this.unit = unit;
        this.resolution = resolution;
    }
    public Double getResolution(){
        return this.resolution;
    }
    public String getUnit(){
        return this.unit;
    }
}
