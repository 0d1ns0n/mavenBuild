package test;

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
//    public static LinkedList<JButton> list = new LinkedList<>();
    public static int[][] table = new int[WIDTH][HEIGHT];
    public static int lvl = 20;
    public static int tableClean = 1; // не лишняя, а сделана для !возможно! дополнительной реализации
    public static JButton button = new JButton("BOOM");
    public static JButton flagButton = new JButton(new ImageIcon("src/main/resources/iconFlag.png"));
    public static JButton button1 = new JButton(new ImageIcon("src/main/resources/1.png"));
    public static JButton button2 = new JButton(new ImageIcon("src/main/resources/2.png"));
    public static JButton button3 = new JButton(new ImageIcon("src/main/resources/3.png"));
    public static JButton button4 = new JButton(new ImageIcon("src/main/resources/4.png"));
    public static JButton button5 = new JButton(new ImageIcon("src/main/resources/5.png"));

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("BOOM")) {
            button.setVisible(false);

            int yLength = 0;
            for (int i = 0; i <= table.length - 1; i++) {

                for (int j = 0; j <= table[i].length - 1; j++) {
                    if (table[i][j] == mineID) {
                        JButton jButton = new JButton();
                        String strM = i + "m" + j;
                        jButton.setName(strM);
                        jButton.setBounds(j * SCALE, yLength * SCALE, SCALE, SCALE);
                        jButton.addActionListener(this);
                        jButton.addMouseListener(this);
                        jPanel.add(jButton);
                        list.add(jButton);
                    } else {
                        String str = i + "t" + j;
                        JButton jButton = new JButton();
                        jButton.setName(str);
                        jButton.setBounds(j * SCALE, yLength * SCALE, SCALE, SCALE);
                        jButton.addActionListener(this);
                        jButton.addMouseListener(this);
                        jPanel.add(jButton);
                        list.add(jButton);
                    }
                    System.out.print("\t");
                }
                System.out.println(list.size());
                System.out.println();
                yLength++;

            }

        } else {
            GetPanelLogic.tapToTable((JButton) e.getSource());
        }
        jPanel.revalidate();
BomNewBrain.jFrame.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JButton b = (JButton) e.getSource();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (e.getButton() == MouseEvent.BUTTON3) {

                    if (b.getName().equals(i + "t" + j) && b.getIcon() == null) {
                        b.setIcon(flagButton.getIcon());
                    } else if (b.getIcon() == flagButton.getIcon() && b.getName().equals(i + "t" + j)) {
                        b.setIcon(null);
                    } else if (b.getName().equals(i + "m" + j) && b.getIcon() == null) {
                        b.setIcon(flagButton.getIcon());
                    } else if (b.getName().equals(i + "m" + j) && b.getIcon() == flagButton.getIcon()) {
                        b.setIcon(null);
                    }
                } else if (e.getButton() == MouseEvent.BUTTON1) {
                    JFrame jFrame = new JFrame();

                    if (b.getName().equals(i + "m" + j) && b.getIcon() == null) {
                        JOptionPane.showMessageDialog(jFrame, "ОПА! ну шо ты дорогой, на в ебало!");
                        System.exit(0);
                    }
                }
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
