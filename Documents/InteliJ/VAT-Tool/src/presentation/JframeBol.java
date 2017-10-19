package presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JframeBol extends Frame {
    private TextField straalTextfield;
    private Button maakButton;
    private double straal;
    private JframeBegin frame;

    public JframeBol(JframeBegin newFrame){
        frame = newFrame;
        addWindowListener(new FrameHandler());

        maakButton = new Button("OK");
        maakButton.setBounds(175,180,100,20);
        maakButton.addActionListener(new maakButtonHandler());
        add(maakButton);

        straalTextfield = new TextField();
        straalTextfield.setBounds(175,100,100,20);
        add(straalTextfield);

        Label straalLabel = new Label ("Straal");
        straalLabel.setBounds(75,100,100,20);
        add(straalLabel);

        setTitle("Bol");
        setLayout(null);
        setSize(300,225);
        setVisible(false);
        setBackground(Color.cyan);

    }

    class maakButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            straal= Double.parseDouble(straalTextfield.getText());
            frame.setBolData();
            dispose();
            hide();

        }
    }

    private class FrameHandler extends WindowAdapter{
        public void windowClosing (WindowEvent e){
            dispose();
            hide();
        }
    }

    public double getStraal(){
        return straal;
    }

    public void emptyFields(){

        straalTextfield.setText("");
    }
}
