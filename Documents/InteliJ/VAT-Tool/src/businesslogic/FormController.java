package businesslogic;

import domain.*;

import java.text.Normalizer;
import java.util.ArrayList;

public class FormController {
    private ArrayList<VormInt> allForms;

    public FormController(){
        allForms = new ArrayList<VormInt>();
    }

    public double totalButton() {
        double total = 0;
        for (int i = 0; i < allForms.size(); i++) {
            total = total + giveContentForm(i);
    }
    return total;
    }

    public double giveContentForm(int index){
        VormInt vorm = allForms.get(index);
        return vorm.giveContent();
    }

    public void deleteForm(int index){
        if(!allForms.isEmpty()){
            allForms.remove(index);
        }
    }

    public VormInt giveForm(int index){
        return allForms.get(index);
    }
    public String giveString(int index){
        return ""+allForms.get(index);
    }

    public void addForm(VormInt v){
        allForms.add(v);
    }

    public int grootte(){
        return allForms.size();
    }

    public void addBol(double straal){
        VormInt k = new Bol(straal);
        addForm(k);
    }

    public void addBlok(double l, double b, double h){
        VormInt k = new Blok(l, b, h);
        addForm(k);
    }

    public void addCilinder(double s, double h){
        VormInt k = new Cilinder(s,h);
        addForm(k);
    }

    public void addRuit(double l, double h){
        VormInt k = new Ruit(l,h);
        addForm(k);
    }

    public void addRechthoek(double l, double b){
        VormInt k = new Rechthoek(l,b);
        addForm(k);
    }


}
