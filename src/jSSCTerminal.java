
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sanin
 */
public class jSSCTerminal extends WindowAdapter {
    static jSSCTerminal window;
    private JFrame frame;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                    window = new jSSCTerminal();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public jSSCTerminal() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(this);
        frame.getContentPane().setLayout(new CardLayout(0, 0));
        frame.add(new Form());
    }

 }
