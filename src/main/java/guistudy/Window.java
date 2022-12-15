package guistudy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame implements ActionListener {
    private static JPanel j = new JPanel();
    public static ArrayList<JButton> list = new ArrayList<>();
    private static int[][] table = new int[20][20];
    private static final int S = 32;
    private static final int W = 20;
    private static final int H = 20;
    private static int lvl = 20;
    public JButton start = new JButton("go");
    public JButton jButton;

    public Window() {
        setTitle("menu");
        setSize(W * S + 52, H * S + 80);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        start.addActionListener(this);
        j.setLayout(null);
        start.setBounds(340, 650, 70, 30);
        j.add(start);
        add(j);
        fulling(table);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("go")) {
            start.setVisible(false);
            int count = 0;
            for (int i = 0; i < table.length; i++) {
                for (int k = 0; k < table[i].length; k++) {

                    if (table[i][k] == 0) {
                        jButton = new JButton();
                        jButton.setName("" + count++);
                    } else {
                        jButton = new JButton(new ImageIcon("src/main/resources/mine.png"));
                        jButton.setName("m");
                    }

                    jButton.setBounds(k * S, i * S, S, S);
                    jButton.addActionListener(this);
                    j.add(jButton);
                    list.add(jButton);
                    System.out.print("\t" + list.indexOf(jButton));
                }
                System.out.println();
            }
        } else {
            tap((JButton) e.getSource());

        }
        repaint();
    }

    void tap(JButton bb) {
        System.out.println(list.indexOf(bb) +"   index  INFO FOR TAPED");
//        System.out.println(bb.getName()+"name  INFO FOR TAPED");
        for (int i = 0; i < list.size(); i++) {


            for (JButton b : list) {
                if (bb.equals(b) && b.getName().equals("" + i)) {
                    clear(b);
                }
            }
        }
    }

    static int clear(JButton next) {

        int countM = 0;
        int thisB = 1;
        int UnD = 20;


            for (JButton b : list) {

                if (next.equals(b)) {
                    int m = list.indexOf(b);
//                    System.out.println(m+"index   INFO FOR METHOD");

                        if (m - thisB > -1 && m + thisB < 400) {

                            if (m%20 !=19 ) {
                                if (list.get(m + thisB).getName().equals("m")) {
                                    System.out.println("right");
                                    countM++;
                                }
                            }
                            if (m%20 !=0 ) {
                                if (list.get(m - thisB).getName().equals("m")) {
                                    countM++;
                                }
                            }
                        }

                    // toUP
                    if (m - UnD > -1 && m -(UnD + thisB) > -1) {
                        System.out.println("u");
                        if ((m - UnD)%20 !=19 ) {
                            if (list.get(m - (UnD - thisB)).getName().equals("m")) {
                                System.out.println("right-20");
                                countM++;
                            }
                        }

                        if (list.get(m - UnD).getName().equals("m")) {
                            countM++;
                        }
                        if (((m- UnD)%20 !=0 )) {
                            if (list.get(m - (UnD + thisB)).getName().equals("m")) {
                                countM++;
                            }
                        }
                    }
                    if (m + UnD < 399  ) {
                        System.out.println("d");
                        //toDown
                        if ((m + UnD)%20 != 19) {
                            if (list.get(m + (UnD + thisB)).getName().equals("m")) {
                                System.out.println("right");
                                countM++;
                            }
                        }

                        if (list.get(m + UnD).getName().equals("m")) {
                            countM++;
                        }
                        if (((m + UnD)%20 != 0)) {
                            if (list.get(m + (UnD - thisB)).getName().equals("m")) {
                                countM++;
                            }
                        }
                    }
                }

        }
        System.out.println(countM);
        return countM;
    }

    static JButton find(JButton b, int i) {
        int countM = 0;
        boolean var = b.getName().equals("m");
        b = list.get(list.indexOf(i));
        int v = list.indexOf(b);
        for (JButton next : list) {


        }
        return b;
    }


    static void fulling(int[][] arrays) {
        int count = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int k = 0; k < arrays[i].length; k++) {
                int a = rand();
                int b = rand();
                if (arrays[a][b] == 0 && count <= lvl) {
                    arrays[a][b] = 999;
                    count++;
                }
                System.out.print("\t" + arrays[i][k]);
            }
            System.out.println();
        }
    }


    static int rand() {

        return (int) (Math.random() * 20);
    }

    public static void main(String[] args) {
        JFrame jFrame = new Window();
        jFrame.setVisible(true);
    }
}

