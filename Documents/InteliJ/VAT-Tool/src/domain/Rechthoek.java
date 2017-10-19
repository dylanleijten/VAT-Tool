package domain;

public class Rechthoek implements VormInt {
    private double lengte;
    private double breedte;

    public Rechthoek(double lengte, double breedte){
        this.lengte = lengte;
        this.breedte= breedte;
    }

    @Override
    public double giveContent(){
        return lengte * breedte;
    }

    @Override
    public String givePresentation(){
        return "Rechthoek " + lengte + " " + breedte;
    }
}
