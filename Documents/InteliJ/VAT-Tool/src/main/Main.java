package main;

import javax.swing.JFrame;
import presentation.JframeBegin;

/**
 *
 * @author dleijten
 */
public class Main extends JFrame {

    public static void main(String[] args) {

        JframeBegin frame = new JframeBegin();

        frame.setSize(500, 530);
        frame.setTitle("VAT-Tool 2017");
        frame.setVisible(true);

    }
}
