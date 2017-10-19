package presentation;

import java.awt.event.*;
import java.awt.*;

public class JframeCilinder extends Frame {

    private TextField straalTextfield, hoogteTextfield;
    private Button maakButton;
    private double straal, hoogte;
    private JframeBegin frame;

    public JframeCilinder(JframeBegin newFrame) {
        addWindowListener(new FrameHandler());
        frame = newFrame;

        maakButton = new Button("OK");
        maakButton.setBounds(180, 180, 100, 20);
        maakButton.addActionListener(new makeButtonHandler());
        add(maakButton);

        straalTextfield = new TextField();
        straalTextfield.setBounds(180, 50, 100, 20);
        add(straalTextfield);

        hoogteTextfield = new TextField();
        hoogteTextfield.setBounds(180, 100, 100, 20);
        add(hoogteTextfield);

        Label straalLabel = new Label("Straal");
        straalLabel.setBounds(80, 50, 100, 20);
        add(straalLabel);

        Label hoogteLabel = new Label("Hoogte");
        hoogteLabel.setBounds(80, 100, 100, 20);
        add(hoogteLabel);

        setTitle("Cilinder");
        setLayout(null);
        setSize(300, 225);
        setVisible(false);
        setBackground(Color.cyan);
    }

    class makeButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            straal = Double.parseDouble((straalTextfield.getText()));
            hoogte = Double.parseDouble((hoogteTextfield.getText()));
            frame.setCilinderData();
            dispose();
            hide();
        }
    }
    private class FrameHandler extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            dispose();
            hide();
        }
    }

    public double getHoogte(){
        return hoogte;
    }
    public double getStraal(){
        return straal;
    }

    public void emptyFields(){
        straalTextfield.setText("");
        hoogteTextfield.setText("");
    }
}
