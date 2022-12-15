package guistudy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI extends JFrame {
    public static getJlabel getJlabel;
    public static getPanel getPanel;
    public static getJpanel getJpanel;
    public static JButton button = new JButton("click jframe");
    public static JButton buttonPanel = new JButton("click panel");
    public static JButton buttonJlabel = new JButton("click jlabel");
    public static JButton buttonJpanel = new JButton("click jpanel");

    public SimpleGUI() {
        setTitle("A Sample JFrame Window");

//        JButton button = new JButton("click jframe");
        button.setBounds(100, 100, 115, 55);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800, 800);

        setLayout(null);

        getJlabel = new getJlabel();
        getPanel = new getPanel();
        getJpanel = new getJpanel();

        add(getJlabel);
        add(getPanel);
        add(getJpanel);
        SimpleGUI.ButtonEventListener act = new SimpleGUI.ButtonEventListener(button);
        button.addActionListener(act);
        ButtonEventListener actP = new ButtonEventListener(buttonPanel);
        buttonPanel.addActionListener(actP);
        ButtonEventListener actJl = new ButtonEventListener(buttonJlabel);
        buttonJlabel.addActionListener(actJl);
        ButtonEventListener actJp = new ButtonEventListener(buttonJpanel);
        buttonJpanel.addActionListener(actJp);
        buttonPanel.addActionListener(actP);
        buttonJlabel.addActionListener(actJl);
//        setContentPane(getPanel);
//        setContentPane(getJlabel);
//        setContentPane(getJpanel);
        getJlabel.setVisible(false);
        getPanel.setVisible(false);
        getJpanel.setVisible(false);
        add(button);
        setVisible(true);

    }

    public static void main(String[] args) {
        new SimpleGUI();

    }

    class ButtonEventListener implements ActionListener {
        public ButtonEventListener(JButton button) {

            thisB = button;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if(thisB == button){
                button.setVisible(false);
                getPanel.setVisible(true);
                repaint();
            }if(thisB == buttonPanel){
                getPanel.setVisible(false);
                getJlabel.setVisible(true);
                repaint();
            }if(thisB == buttonJlabel){
                getJlabel.setVisible(false);
                getJpanel.setVisible(true);

                repaint();
            }if(thisB == buttonJpanel){
                getJpanel.setVisible(false);
                getPanel.setVisible(true);
                repaint();
            }

        }

        private final JButton thisB;
    }


    static class getPanel extends Panel {
        getPanel() {
//            setTitle("A Sample JFrame Window");

//            JButton button = new JButton("click panel");
            buttonPanel.setBounds(100, 100, 115, 55);
            add(buttonPanel);

//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            setSize(400, 300);

            setLayout(null);


        }
    }

    static class getJlabel extends JLabel {
        public getJlabel() {
            setLayout(new BorderLayout());
            JLabel back = new JLabel(new ImageIcon(SimpleGUI.class.getResource("/resources/Pmenu.png")));
            buttonJlabel.setBounds(100, 100, 115, 55);
            setSize(600, 300);
            back.setLayout(new FlowLayout());
            back.add(buttonJlabel);
            add(back);

//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);






        }
    }

    static class getJpanel extends JPanel {
        public getJpanel() {
//            setTitle("A Sample JFrame Window");

//            JButton button = new JButton("click jpanel");
            buttonJpanel.setBounds(100, 100, 115, 55);

            add(buttonJpanel);

//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            setSize(400, 300);

            setLayout(null);


        }
    }

}
