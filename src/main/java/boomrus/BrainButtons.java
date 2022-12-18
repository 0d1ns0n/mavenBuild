package boomrus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BrainButtons extends JFrame implements ActionListener, MouseListener {
    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int mineID = 999;
    public static JPanel jPanel = new JPanel();
    public static final ArrayList<JButton> list = new ArrayList<>();
    public static int[][] table = new int[WIDTH][HEIGHT];
    public static int lvl = 20;
    public static JButton button = new JButton("BOOM");
    public static JButton flagButton = new JButton(new ImageIcon("src/main/resources/iconFlag.png"));
    public static JButton button1 = new JButton(new ImageIcon("src/main/resources/1.png"));
    public static JButton button2 = new JButton(new ImageIcon("src/main/resources/2.png"));
    public static JButton button3 = new JButton(new ImageIcon("src/main/resources/3.png"));
    public static JButton button4 = new JButton(new ImageIcon("src/main/resources/4.png"));
    public static JButton button5 = new JButton(new ImageIcon("src/main/resources/5.png"));
    public JButton jButton;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("BOOM")) {
            button.setVisible(false);
            int count = 0;
            for (int i = 0; i < table.length; i++) {
                for (int k = 0; k < table[i].length; k++) {

                    if (table[i][k] == 0) {
                        jButton = new JButton();
                        jButton.setName("" + count++);
                    } else {
                        jButton = new JButton();
                        jButton.setName("m");
                    }

                    jButton.setBounds(k * SCALE, i * SCALE, SCALE, SCALE);
                    jButton.addActionListener(this);
                    jButton.addMouseListener(this);
                    jPanel.add(jButton);
                    list.add(jButton);
                }

            }
        } else {
            GetPanelLogic.tapToTable((JButton) e.getSource());

        }
        jPanel.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JButton b = (JButton) e.getSource();


        if (e.getButton() == MouseEvent.BUTTON3) {
            for (int i = 0; i < list.size(); i++) {
                if (b.getName().equals("" + i) && b.getIcon() == null) {
                    b.setIcon(flagButton.getIcon());
                } else if (b.getIcon() == flagButton.getIcon() && b.getName().equals("" + i)) {
                    b.setIcon(null);
                }
            }

            if (b.getName().equals("m") && b.getIcon() == null) {
                b.setIcon(flagButton.getIcon());
            } else if (b.getName().equals("m") && b.getIcon() == flagButton.getIcon()) {
                b.setIcon(null);
            }

        } else if (e.getButton() == MouseEvent.BUTTON1) {

            JFrame jFrame = new JFrame();
            if (b.getName().equals("m") && b.getIcon() == null) {
                JOptionPane.showMessageDialog(jFrame, "Sorry, YOU LOST!");
                System.exit(0);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
