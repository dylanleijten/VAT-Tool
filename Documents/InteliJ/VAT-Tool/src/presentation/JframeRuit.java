package presentation;

import java.awt.*;
import java.awt.event.*;


public class JframeRuit  extends Frame{
    private TextField lengteTextfield,hoogteTextfield;
    private Button maakButton;
    private double lengte,breedte,hoogte;
    private JframeBegin frame;

    public JframeRuit (JframeBegin newFrame){
        frame = newFrame;
        addWindowListener(new FrameHandler());

        maakButton = new Button("OK");
        maakButton.setBounds(175,180,100,20);
        maakButton.addActionListener(new maakButtonHandler());
        add (maakButton);

        lengteTextfield = new TextField();
        lengteTextfield.setBounds(180,50,100,20);
        add (lengteTextfield);

        hoogteTextfield = new TextField();
        hoogteTextfield.setBounds(180, 100, 100, 20);
        add(hoogteTextfield);


        Label lengteLabel = new Label ( "Lengte");
        lengteLabel.setBounds(80,50,100,20);
        add(lengteLabel);

        Label hoogteLabel = new Label("Hoogte");
        hoogteLabel.setBounds(80, 100, 100, 20);
        add(hoogteLabel);


        setTitle("Ruit");
        setLayout(null);
        setSize(400,325);
        setVisible(false);
        setBackground(Color.cyan);

    }
        class maakButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            lengte = Double.parseDouble(lengteTextfield.getText());
            hoogte = Double.parseDouble((hoogteTextfield.getText()));
            frame.setRuitData();
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


    public double getHoogte(){
        return breedte;
    }

    public void emptyFields(){
        lengteTextfield.setText("");
        hoogteTextfield.setText("");
    }
}