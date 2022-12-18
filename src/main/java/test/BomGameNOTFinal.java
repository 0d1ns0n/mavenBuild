package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BomGameNOTFinal extends JFrame implements ActionListener, MouseListener {
    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    private final int mineID = 999;
    private final JPanel jPanel = new JPanel();
    private static final ArrayList<JButton> list = new ArrayList<>();
    public static int[][] table = new int[WIDTH][HEIGHT];
    public static int lvl = 0;
    public static int tableClean = 1; // не лишняя, а сделана для !возможно! дополнительной реализации
    public static JButton button = new JButton("BOOM");
    public static JButton flagButton = new JButton(new ImageIcon("src/main/resources/iconFlag.png"));
    public static JButton button1 = new JButton(new ImageIcon("src/main/resources/1.png"));
    public static JButton button2 = new JButton(new ImageIcon("src/main/resources/2.png"));
    public static JButton button3 = new JButton(new ImageIcon("src/main/resources/3.png"));
    public static JButton button4 = new JButton(new ImageIcon("src/main/resources/4.png"));
    public static JButton button5 = new JButton(new ImageIcon("src/main/resources/5.png"));


    public BomGameNOTFinal() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH * SCALE + 18, HEIGHT * SCALE + 80);
        setLocationRelativeTo(null);
        setResizable(false);
        add(jPanel);
        jPanel.setLayout(null);
        button.setBounds((TestFrame.WIDTH * TestFrame.SCALE - 50) / 2, 650, 70, 30);
        button.addActionListener(this);
        jPanel.add(button);

        arraysFulling(table);
    }

    void arraysFulling(int[][] arrays) {
        for (int i = 1; i <= lvl; i++) {
            int a = posRand();
            int b = posRand();

            for (int j = 0; j < 1; j++) {
                if (arrays[a][b] == 0) {
                    arrays[a][b] = mineID;

                } else {
                    i = i - 1;
                }
            }
        }
    }

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
            tapToTable((JButton) e.getSource());
        }
        jPanel.revalidate();
        repaint();
    }

    void tapToTable(JButton b) {
        System.out.println(list.indexOf(b));
        System.out.println(b.getName());

        for (JButton n : list) {
            for (int i = 0; i <= table.length - 1; i++) {
                for (int j = 0; j <= table[i].length - 1; j++) {

                    if (n.equals(b) && b.getName().equals(i + "t" + j) && b.getIcon() == null) {

                        switch (findB(i, j)) {
                            case 0 -> {

                                list.get(list.indexOf(b)).setVisible(false);
                                list.get(list.indexOf(b) + 1).setVisible(false);
                                list.get(list.indexOf(b) - 1).setVisible(false);
                                //UP clean
                                if (list.indexOf(b) - 20 > -1) {
                                    list.get(list.indexOf(b) - 20).setVisible(false);
                                    list.get(list.indexOf(b) - 21).setVisible(false);
                                    list.get(list.indexOf(b) - 19).setVisible(false);
                                }
                                //DOWN clean
                                list.get(list.indexOf(b) + 20).setVisible(false);
                                list.get(list.indexOf(b) + 21).setVisible(false);
                                list.get(list.indexOf(b) + 19).setVisible(false);

                            }

                            case 1 -> list.get(list.indexOf(b)).setIcon(button1.getIcon());
                            case 2 -> list.get(list.indexOf(b)).setIcon(button2.getIcon());
                            case 3 -> list.get(list.indexOf(b)).setIcon(button3.getIcon());
                            case 4 -> list.get(list.indexOf(b)).setIcon(button4.getIcon());
                            case 5 -> list.get(list.indexOf(b)).setIcon(button5.getIcon());
                        }


                        break;
                    }

                }
            }
        }
    }

    static int posRand() {
        return (int) (Math.random() * 20);
    }

    static int findB(int i, int j) {

        int countM = 0;
        for (JButton next : list) {

            if (next.getName().equals(i + "m" + (j + tableClean))) {
                countM++;
            }
            if (next.getName().equals(i + "m" + (j - tableClean))) {
                countM++;
            }

            if (next.getName().equals((i - tableClean) + "m" + (j - tableClean))) {
                countM++;
            }

            if (next.getName().equals((i - tableClean) + "m" + (j))) {
                countM++;
            }

            if (next.getName().equals((i - tableClean) + "m" + (j + tableClean))) {
                countM++;
            }

            if (next.getName().equals((i + tableClean) + "m" + (j - tableClean))) {
                countM++;
            }

            if (next.getName().equals((i + tableClean) + "m" + (tableClean))) {
                countM++;
            }

            if (next.getName().equals((i + tableClean) + "m" + (j + tableClean))) {
                countM++;
            }
        }
        return countM;
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
                        System.out.println("if1ONe");
                        b.setIcon(flagButton.getIcon());
                    } else if (b.getIcon() == flagButton.getIcon() && b.getName().equals(i + "t" + j)) {
                        System.out.println("if3ONe");
                        b.setIcon(null);
                    } else if (b.getName().equals(i + "m" + j) && b.getIcon() == null) {
                        b.setIcon(flagButton.getIcon());
                        System.out.println("if2ONe");
                    } else if (b.getName().equals(i + "m" + j) && b.getIcon() == flagButton.getIcon()) {
                        System.out.println("if4ONe");
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
