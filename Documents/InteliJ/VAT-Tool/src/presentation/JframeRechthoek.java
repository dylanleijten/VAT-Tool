package presentation;

import java.awt.*;
import java.awt.event.*;


public class JframeRechthoek  extends Frame{
    private TextField lengteTextfield, breedteTextfield, hoogteTextfield;
    private Button maakButton;
    private double lengte,breedte,hoogte;
    private JframeBegin frame;

    public JframeRechthoek(JframeBegin newFrame){
        frame = newFrame;
        addWindowListener(new FrameHandler());

        maakButton = new Button("OK");
        maakButton.setBounds(175,180,100,20);
        maakButton.addActionListener(new maakButtonHandler());
        add (maakButton);

        lengteTextfield = new TextField();
        lengteTextfield.setBounds(175,50,100,20);
        add (lengteTextfield);

        breedteTextfield = new TextField();
        breedteTextfield.setBounds(175,100,100,20);
        add(breedteTextfield);


        Label lengteLabel = new Label ( "Lengte");
        lengteLabel.setBounds(75,50,100,20);
        add(lengteLabel);

        Label breedteLabel = new Label ( "Breedte");
        breedteLabel.setBounds(75,100,100,20);
        add(breedteLabel);


        setTitle("Rechthoek");
        setLayout(null);
        setSize(400,325);
        setVisible(false);
        setBackground(Color.cyan);

    }
    public class maakButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            lengte = Double.parseDouble(lengteTextfield.getText());
            breedte = Double.parseDouble(breedteTextfield.getText());
            frame.setRechthoekData();
            dispose();

        }
    }

    private class FrameHandler extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            dispose();
            hide();
        }
    }

    public double getLengte(){
        return lengte;
    }


    public double getBreedte(){
        return breedte;
    }

    public void emptyFields(){
        lengteTextfield.setText("");
        breedteTextfield.setText("");
    }
}
