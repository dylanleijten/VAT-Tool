package domain;

public class Bol implements VormInt {

    private double straal;

    public Bol (double r){

        this.straal = r;
    }

    @Override
    public double giveContent(){
        return (4*Math.PI*straal*straal*straal) /3;
    }
    @Override
    public String givePresentation(){
        return "Bol " + straal;
    }
}
