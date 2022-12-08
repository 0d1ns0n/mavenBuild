package boomrus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class TestArraysFrame extends JFrame implements ActionListener {
    private JPanel jPanel = new JPanel();
    private int counter;


    private ArrayList<JButton> list = new ArrayList<>();

    TestArraysFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 100);
        add(jPanel);
        JButton button = new JButton("Primary Button");
        button.addActionListener(this);
        jPanel.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Primary Button")) {
            counter++;
            JButton nb = new JButton("Button " + counter);
            nb.addActionListener(this);
            jPanel.add(nb);
            list.add(nb);
        } else {
            testDelButton((JButton) e.getSource());
        }
        jPanel.revalidate();
        jPanel.repaint();

    }

    void testDelButton(JButton b){
        for (Iterator<JButton> iterator = list.iterator(); iterator.hasNext();){
            JButton but = iterator.next();
            if (but.equals(b)) {
                iterator.remove();
                jPanel.remove(but);
                break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame jFrame = new TestArraysFrame();
        jFrame.setVisible(true);
    }
}
