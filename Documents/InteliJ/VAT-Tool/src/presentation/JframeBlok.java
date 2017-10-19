package presentation;

import java.awt.*;
import java.awt.event.*;


public class JframeBlok  extends Frame{
    private TextField lengteTextfield, breedteTextfield, hoogteTextfield;
    private Button maakButton;
    private double lengte,breedte,hoogte;
    private JframeBegin frame;

    public JframeBlok(JframeBegin newFrame){
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

        hoogteTextfield = new TextField();
        hoogteTextfield.setBounds(175,150,100,20);
        add(hoogteTextfield);

        Label lengteLabel = new Label ( "Lengte");
        lengteLabel.setBounds(75,50,100,20);
        add(lengteLabel);

        Label breedteLabel = new Label ( "Breedte");
        breedteLabel.setBounds(75,100,100,20);
        add(breedteLabel);

        Label hoogteLabel = new Label ( "Hoogte");
        hoogteLabel.setBounds(75,150,100,20);
        add(hoogteLabel);

        setTitle("Blok");
        setLayout(null);
        setSize(400,325);
        setVisible(false);
        setBackground(Color.cyan);

    }
    public class maakButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            lengte = Double.parseDouble(lengteTextfield.getText());
            breedte = Double.parseDouble(breedteTextfield.getText());
            hoogte = Double.parseDouble(hoogteTextfield.getText());
            frame.setBlokData();
            dispose();

        }
    }

    private class FrameHandler extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e){
            frame.setBlokData();
            dispose();

        }
    }
    public double getLengte(){
        return lengte;
    }

    public double getHoogte(){
        return hoogte;
    }

    public double getBreedte(){
        return breedte;
    }

    public void emptyFields(){
        lengteTextfield.setText("");
        breedteTextfield.setText("");
        hoogteTextfield.setText("");
    }
}
