package domain;

public class Ruit implements VormInt {
    private double lengte;
    private double hoogte;

    public Ruit(double lengte, double hoogte){
        this.lengte = lengte;
        this.hoogte = hoogte;
    }

    @Override
    public double giveContent(){
        return lengte * hoogte;
    }

    @Override
    public String givePresentation(){
        return "Ruit " + lengte + " " + hoogte;
    }
}
