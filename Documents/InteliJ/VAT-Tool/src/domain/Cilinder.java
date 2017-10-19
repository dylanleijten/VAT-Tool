package domain;

public class Cilinder implements VormInt {
    private double straal, hoogte;

    public Cilinder(double r, double h){

        this.straal = r;
        this.hoogte = h;
    }
    @Override
    public double giveContent(){
        return Math.PI*straal*straal*hoogte;
    }

    @Override
    public String givePresentation(){
        return "Cilinder" + straal + " " + hoogte;
    }

}
