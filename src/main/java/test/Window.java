package test;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.*;


public class Window extends JFrame implements ActionListener {
    private static final JPanel j = new JPanel();
    public static ArrayList<JButton> list = new ArrayList<>();
    private static final int[][] table = new int[20][20];
    private static final int S = 32;
    private static final int W = 20;
    private static final int H = 20;
    private static final int lvl = 20;
    public static JButton start = new JButton("go");
    public JButton jButton;
    public Timer timer = new Timer();
    public JFrame jFrame= new JFrame();
    public static Random random = new Random();

    public Window() {
        setTitle("menu");
        setSize(W * S + 16, H * S + 110);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        start.addActionListener(this);
        j.setLayout(null);
        start.setBounds(320 -25, 640, 70, 90);
        j.add(start);
        add(j);
        fulling(table);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("go")) {

            start.setText(null);

timer.schedule(new TimerTask() {
    @Override
    public void run() {

        start.setLocation(random.nextInt(650),random.nextInt(650));

    }
}, 5000,3000);
//            start.setVisible(false);
            int count = 0;
            for (int i = 0; i < table.length; i++) {
                for (int k = 0; k < table[i].length; k++) {

                    if (table[i][k] == 0) {
                        jButton = new JButton();
                        jButton.setName("" + count++);
                    } else {
                        jButton = new JButton(img("mine"));
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
            tapToTable((JButton) e.getSource());

        }
        repaint();
    }

    static void tapToTable(JButton bb) {


        for (int i = 0; i < list.size() - 1; i++) {
            for (JButton b : list) {

                if (b.equals(bb) && bb.getName().equals("" + i) && bb.getIcon() == null) {
                    clear(b);
                    switch (clear(b)) {
                        case 0 -> {
                            // в реализации
                        }
                        case 1 -> list.get(list.indexOf(b)).setIcon(img("1"));
                        case 2 -> list.get(list.indexOf(b)).setIcon(img("2"));
                        case 3 -> list.get(list.indexOf(b)).setIcon(img("3"));
                        case 4 -> list.get(list.indexOf(b)).setIcon(img("4"));
                        case 5 -> list.get(list.indexOf(b)).setIcon(img("5"));
                    }
                    break;
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



    static void fulling(int[][] arrays) {
        int count = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int k = 0; k < arrays[i].length; k++) {
                int a = (int) (Math.random() * 20);
                int b = (int) (Math.random() * 20);
                if (arrays[a][b] == 0 && count <= lvl) {
                    arrays[a][b] = 999;
                    count++;
                }
                System.out.print("\t" + arrays[i][k]);
            }
            System.out.println();
        }
    }

    static ImageIcon img(String res){
        return new ImageIcon(Objects.requireNonNull(Window.class.getResource("/resources/"+res+".png")));
    }

    public static void main(String[] args) {
        JFrame jFrame = new Window();
        jFrame.setVisible(true);

    }
}

