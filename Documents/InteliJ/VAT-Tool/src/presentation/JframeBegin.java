package presentation;

import java.awt.*;
import java.awt.event.*;
import businesslogic.*;
import javax.swing.*;
import java.lang.*;
import javax.swing.event.ListSelectionListener;

public class JframeBegin extends JFrame {
    private JframeBlok jframeBlok = new JframeBlok(this);
    private JframeBol jframeBol = new JframeBol(this);
    private JframeCilinder jframeCilinder = new JframeCilinder(this);
    private JframeRuit jframeRuit = new JframeRuit(this);
    private JframeRechthoek jframeRechthoek = new JframeRechthoek(this);
    private JTextField totalTextfield, contentTextfield;
    private Choice choiceList;
    private JButton refreshButton, deleteButton, totalButton;
    private FormController controller = new FormController();
    private double cilinderTemp1, cilinderTemp2, bolTemp, blokTemp1, blokTemp2, blokTemp3, ruitTemp1,ruitTemp2,rechthoekTemp1,rechthoekTemp2;
    private List formList;
    private int index;

    public JframeBegin() {
        Container c = getContentPane();
        JPanel panel = new JPanel(null);
        addWindowListener(new FrameHandler());
        panel.setBackground(Color.cyan);

        choiceList = new Choice();
        choiceList.addItem("Blok");
        choiceList.addItem("Bol");
        choiceList.addItem("Cilinder");
        choiceList.addItem("Ruit");
        choiceList.addItem("Rechthoek");

        choiceList.addItemListener(new ChoiceHandler());
        choiceList.setBounds(100, 10, 100, 20);
        panel.add(choiceList);

        deleteButton = new JButton("Wis vorm");
        deleteButton.setBounds(100, 130, 100, 20);
        deleteButton.addActionListener(new deleteButtonHandler());
        panel.add(deleteButton);

        refreshButton = new JButton("Ververs lijst");
        refreshButton.setBounds(100, 170, 100, 20);
        refreshButton.addActionListener(new refreshButtonHandler());
        panel.add(refreshButton);

        totalButton = new JButton("Totale inhoud");
        totalButton.setBounds(100, 210, 100, 20);
        totalButton.addActionListener(new totalButtonHandler());
        panel.add(totalButton);

        JLabel total = new JLabel("Totale inhoud:");
        total.setBounds(15, 100, 80, 20);
        panel.add(total);

        JLabel newForm = new JLabel("Vorm");
        newForm.setBounds(20, 15, 140, 20);
        panel.add(newForm);

        JLabel content = new JLabel("Inhoud:");
        content.setBounds(20, 50, 80, 20);
        panel.add(content);

        totalTextfield = new JTextField();
        totalTextfield.setBounds(100, 100, 100, 20);
        totalTextfield.setEditable(false);
        panel.add(totalTextfield);

        formList = new List();
        formList.setBounds(250, 10, 150, 220);
        formList.addItemListener(new formListListener());
        panel.add(formList);

        contentTextfield = new JTextField();
        contentTextfield.setBounds(100, 50, 100, 20);
        contentTextfield.setEditable(false);
        panel.add(contentTextfield);

        c.add(panel);

    }

    public void setCilinderData() {

        double straal = jframeCilinder.getStraal();
        double hoogte = jframeCilinder.getHoogte();

        if (straal != 0.0 && (straal != cilinderTemp1 || hoogte != cilinderTemp2)) {
            controller.addCilinder(straal, hoogte);
            cilinderTemp1 = straal;
            cilinderTemp2 = hoogte;

        }
        refreshButton.doClick();
    }

    public void setBolData(){
        double straal = jframeBol.getStraal();
        if (straal!=0.0&& straal!=bolTemp){
            controller.addBol(straal);
            bolTemp = straal;
        }
        refreshButton.doClick();
    }

    public void setBlokData() {
        double lengte = jframeBlok.getLengte();
        double breedte = jframeBlok.getBreedte();
        double hoogte = jframeBlok.getHoogte();
        if (lengte != 0.0 && (lengte != blokTemp1 || breedte != blokTemp2 || hoogte != blokTemp3)) {
            controller.addBlok(lengte, breedte, hoogte);
            blokTemp1 = lengte;
            blokTemp2 = breedte;
            blokTemp3 = hoogte;
        }
        refreshButton.doClick();
    }

    public void setRuitData(){
        double lengte = jframeRuit.getLengte();
        double hoogte = jframeRuit.getHoogte();
        if (lengte!=0.0&&(lengte!= ruitTemp1 || hoogte != ruitTemp2)){
            controller.addRuit(lengte,hoogte);
            ruitTemp1 = lengte;
            ruitTemp2 = hoogte;
        }
        refreshButton.doClick();
    }

    public void setRechthoekData(){
        double lengte = jframeRechthoek.getLengte();
        double breedte= jframeRechthoek.getBreedte();
        if (lengte!=0.0&&(lengte != rechthoekTemp1 || breedte != rechthoekTemp2)){
            controller.addRechthoek(lengte,breedte);
            rechthoekTemp1 = lengte;
            rechthoekTemp2 = breedte;
        }
            refreshButton.doClick();
    }

    class formListListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e){
            index = Integer.parseInt(""+e.getItem());

            String cont;
            cont = String.format("%.2f", controller.giveContentForm(index));
            contentTextfield.setText(cont);

        }
    }

    class ChoiceHandler implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e){
            index = choiceList.getSelectedIndex();
            switch (index){
                case 0:
                    jframeBlok.emptyFields();
                    jframeBlok.setVisible(true);
                    break;
                case 1:
                    jframeBol.emptyFields();
                    jframeBol.setVisible(true);
                    break;
                case 2:
                    jframeCilinder.emptyFields();
                    jframeCilinder.setVisible(true);
                    break;
                case 3:
                    jframeRuit.emptyFields();
                    jframeRuit.setVisible(true);
                    break;
                case 4:
                    jframeRechthoek.emptyFields();
                    jframeRechthoek.setVisible(true);
                    break;
            }

        }
    }

    class totalButtonHandler implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            String total;
            total = String.format("%.2f", controller.totalButton());
            totalTextfield.setText(total);
        }
    }

    class deleteButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if (controller.grootte()>=0){
                controller.deleteForm(index);
                refreshButton.doClick();
            }
        }
    }

    class refreshButtonHandler implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e){
            formList.removeAll();
            for (int i=0; i<controller.grootte(); i++){
                formList.add(""+controller.giveForm(i).givePresentation());
                formList.add(""+controller.giveString(i));
            }
                index  = 0;
                formList.select(0);
                contentTextfield.setText("");
            }
        }

        private class FrameHandler extends WindowAdapter{
        @Override
            public void windowClosing(WindowEvent e){
            dispose();
            System.exit(0);
        }
        }

    }









