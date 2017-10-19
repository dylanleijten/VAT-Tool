package domain;

public class Blok implements VormInt {
    private double lengte,breedte,hoogte;

    public Blok (double l, double b, double h){
        this.lengte = l;
        this.breedte =b;
        this.hoogte = h;
    }

    @Override
    public double giveContent(){

        return lengte*breedte*hoogte;
    }
    @Override
    public String givePresentation(){
        return "Blok " + lengte + " " + breedte + " " + hoogte;
    }
}
