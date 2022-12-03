package boomrus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;

public class BomGame extends JPanel {
    public static final int bom = 999;
    public static JButton jButtonMine;
    public static JButton jButtonTable;
    public static int hardLvl = 0;
    public static JButton button = new JButton("bom");
    public static final int SCALE = 32; // шкала пискселей, размер клетки
    public static final int WIDTH = 20; // ширина
    public static final int HEIGHT = 20;// высота

    public static Action action;
    public static ArrayList<JButton> arButton = new ArrayList<>();
    public static int[][] table = new int[WIDTH][HEIGHT];
    public static int[] mines;
    public static ImageIcon imageIcon;
    public static ButtonGroup myGroup = new ButtonGroup();
    public static int a = 0;
    public static int b = 0;

    public static JButton[][] min;

    public BomGame() {

        setFocusable(true);
        setLayout(null);
        button.setBounds((BomGame.WIDTH * BomGame.SCALE + 16) / 2, 650, 70, 30);
        action = new Action(button);
        button.addActionListener(action);

        add(button);
        mines = new int[hardLvl];
        arraysFulling(table);

//        int[][] table = new int[WIDTH][HEIGHT];
//        int yLength = 0;
//        ArrayList<ArrayList<JButton>> bB = new ArrayList<ArrayList<JButton>>();
//        for (int i = 0; i < hardLvl; i++) {
//            bB.add(new ArrayList<JButton>());
//            for (int j = 0; j < hardLvl; j++) {
//                bB.get(i).add(new JButton());
//                add(bB.get(i).get(j));
//            }
//        }
//        ArrayList<JButton> arButton = new ArrayList<>();
        min = new JButton[WIDTH][HEIGHT];
//        for (int i = 0; i <= table.length - 1; i++) {
//
//            for (int j = 0; j <= table[i].length - 1; j++) {
////                new ImageIcon(Objects.requireNonNull(BomGame.class.getResource("/resources/mine.png")))
//                if (table[i][j] == bom) {
//                    table[i][j] = bom;
//
////                    jButtonMine.setAction(new A);
////                    jButtonMine.setBounds(j * SCALE, yLength * SCALE, SCALE, SCALE);
////                    action = new Action(jButtonMine);
////                    jButtonMine.addActionListener(action);
////                    arButton.add(jButtonMine);
////                    add(jButtonMine);
//                } else {
//                    jButtonTable = new JButton();
//                    jButtonTable.setBounds(j * SCALE, yLength * SCALE, SCALE, SCALE);
//                    action = new Action(jButtonTable);
//                    jButtonTable.addActionListener(action);
//                    add(jButtonTable);
//
//                }
//            }
//            yLength += 1;
//        }
        int yLength = 0;
        for (int i = 0; i <= table.length - 1; i++) {
            for (int j = 0; j <= table[i].length - 1; j++) {
                if (table[i][j] == bom) {


                    for (int k = 0; k <= min.length - 1; k++) {
                        for (int l = 0; l <= min[k].length - 1; l++) {
                            if (k == i && l == j) {
                                jButtonMine = new JButton();
                                jButtonMine.setName("mine" + j);
                                jButtonMine.setBounds(j * SCALE, yLength * SCALE, SCALE, SCALE);
                                action = new Action(jButtonMine);
                                jButtonMine.addActionListener(action);
                                add(jButtonMine);
                            }

                        }

                    }
                } else {
                    jButtonTable = new JButton();
                    jButtonTable.setBounds(j * SCALE, yLength * SCALE, SCALE, SCALE);
                    action = new Action(jButtonTable);
                    jButtonTable.addActionListener(action);
                    jButtonTable.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {

                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
                            jButtonTable = (JButton) e.getSource();
                            jButtonTable.setVisible(false);
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
                    });
                    add(jButtonTable);
                }
            }
            yLength++;
        }


    }


//    @Override
//    protected void paintComponent(Graphics g) {
//        g.drawImage(img("/resources/gavno.png"), SCALE - 32, SCALE - 40, this);
//
//
//        g.setColor(Color.black);
//        for (int x = 0; x <= WIDTH * SCALE; x += SCALE) {
//            g.drawLine(x, 0, x, HEIGHT * SCALE);
//        }
//        for (int y = 0; y <= HEIGHT * SCALE; y += SCALE) {
//            g.drawLine(0, y, WIDTH * SCALE, y);
//        }
//        mines = new int[hardLvl];
//        Arrays.fill(mines, bom);
//        for (int mine : mines) {
//            if (mine == 999) {
//                g.drawImage(img("/resources/bomBOM.png"), posX() * SCALE, posY() * SCALE, SCALE, SCALE, this);
//
//            }
//        }

//        for (Mines mine : mines) {
//            if (mine != null) {
//                        BOM = new Button();
//                        BOM.setBounds(posX() * SCALE, posY() * SCALE, SCALE, SCALE);
//                        BOM.addMouseListener(new Listener());
//                        add(BOM);
//                        imageIcon = new ImageIcon(Objects.requireNonNull(BomGame.class.getResource("/resources/bomBOM.png")));

    //g.drawImage(img("/resources/bomBOM.png"),posX()*SCALE, posY()*SCALE,SCALE,SCALE,this);
//            }
//        }

    public void paintComponent(Graphics g) {
        g.drawImage(img("/resources/gavno.png"), SCALE - 32, SCALE - 40, this);


        g.setColor(Color.black);
        for (int x = 0; x <= WIDTH * SCALE; x += SCALE) {
            g.drawLine(x, 0, x, HEIGHT * SCALE);
        }
        for (int y = 0; y <= HEIGHT * SCALE; y += SCALE) {
            g.drawLine(0, y, WIDTH * SCALE, y);
        }


//        for (int y = 0; y <= table.length - 1; y++) {
//            for (int i = 0; i <= table[y].length - 1; i++) {
//                if(table[y][i] == bom){
//                    g.drawImage(img("/resources/bomBOM.png"), SCALE, SCALE, SCALE, SCALE, this);
//                }
//            }
//        }


    }


    class Action implements ActionListener {


        public Action(JButton b) {
            tap = b;

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame jFrame = new JFrame();
            Object obj = e.getSource();
            jButtonMine = (JButton) obj;
            for (int i = 0; i < min.length; i++) {
                for (int j = 0; j < min[i].length; j++) {
                    if (jButtonMine.getName().equals("mine" + j)) {

                        JOptionPane.showMessageDialog(jFrame, "ОПА! ну шо ты дорогой иди сюда");
                        try {
                            Thread.sleep(3000);
                            System.exit(0);

                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                }
            }
//            if ("mine0".equals(jButtonMine.getName())) {
//                JFrame jFrame = new JFrame();
//                JOptionPane.showMessageDialog(jFrame, "ОПА! ну шо ты дорогой иди сюда");
//            }
//            if ("mine0".equals(jButtonMine.getName())) {
//                JFrame jFrame = new JFrame();
//                JOptionPane.showMessageDialog(jFrame, "ОПА! ну шо ты дорогой иди сюда");
//            }

//            for (JButton[] jButtons : min) {
//                for (JButton jButton : jButtons) {
//                    jButton =(JButton) obj;
//                    action = new Action(jButton);
//                    jButton.addActionListener(action);
//                    if (tap == jButtonMine){
//                        System.exit(0);
//                    }
//                }
//            }
            repaint();
        }

        private final JButton tap;
    }
//                int yLength = 0;
//                for (int i = 0; i <= table.length - 1; i++) {
//                    for (int j = 0; j <= table[i].length - 1; j++) {
//                        if (table[i][j] == bom) {
//                            a = i;
//                            b = j;
//                            for (int k = 0; k < min.length; k++) {
//                                for (int l = 0; l < min[k].length; l++) {
//                                    if(k == a && b ==l ){
//                                        jButtonMine = new JButton();
//                                        jButtonMine.setBounds(l * SCALE, yLength * SCALE, SCALE, SCALE);
//                                        action = new Action(jButtonMine);
//                                        jButtonMine.addActionListener(action);
//                                        add(jButtonMine);
//                                    }
//
//                                }
//                                yLength++;
//                            }
//                        }
//                    }
//                }
//
//
//                for (JButton[] jButtons : min) {
//                    for (int j = 0; j < jButtons.length; j++) {
//                        jButtonMine = new JButton();
//                        jButtonMine.setBounds(j * SCALE, yLength * SCALE, SCALE, SCALE);
//                        action = new Action(jButtonMine);
//                        jButtonMine.addActionListener(action);
//                        add(jButtonMine);
//                    }
//                    yLength++;
//                }
//                System.out.println(min.length);
//                repaint();
//            }


//            if (tap == button) {
////                int yLength = 0;
//                for (int i = 0; i <= table.length - 1; i++){
//                    for (int j = 0; j < table[i].length; j++) {
//                        if (table[i][j] == bom){
//
//                        }
//                    }
//                }
//
//                {

//            for (int i = 0; i <= table[y].length - 1; i++) {
//                if (table[y][i] == bom) {
//                            List<JButton> buttons = new ArrayList<JButton>();
//
//                            for(int index = 0; index<10; index++) {
//                                buttons.add(new JButton());
//                            }
//                           int n = 9;
//
//                            n++;
//                            JButton[] buttons = new JButton[n];
//                            n = n - 1;
//
//                            for (i = 0; i <= n; i++) {
//                                buttons[i] = new JButton("" + i);
//                                add(buttons[i]);
//                            }
//                            jButtonMine = new JButton();
//                            jButtonMine.setName("" + y);
//                            jButtonMine.setBounds(i * SCALE, yLength * SCALE, SCALE, SCALE);
//                            action = new Action(jButtonMine);
//                            jButtonMine.addActionListener(action);
//                            arButton.add(new JButton());
//                            add(jButtonMine);

//                        } else {
//                            jButtonTable = new JButton();
//                            jButtonTable.setBounds(i * SCALE, yLength * SCALE, SCALE, SCALE);
//                            action = new Action(jButtonTable);
//                            jButtonTable.addActionListener(action);
//                            jButtonTable.addMouseListener(new Listener());
//                            add(jButtonTable);
//


    //                        if (jButtonMine.isEnabled()){
//
//                            JFrame jFrame = new JFrame();
//                            JOptionPane.showMessageDialog(jFrame, "ОПА! ну шо ты дорогой иди сюда");
//                        }

//                    yLength += 1;


    //                for (JButton jButton : arButton) {
//                    myGroup.add(jButton);
//                }
//                System.out.println(arButton.size());
//
//                System.out.println(myGroup.getButtonCount());
//                System.out.println(myGroup.getElements().toString());
//                for (int i = 0; i < myGroup.getButtonCount(); i++) {
//
//                    if (myGroup.getSelection().isSelected()) {
//                        System.exit(0);
//                    }
//                }
//                System.out.println(Integer.parseInt(((JButton) e.getSource()).getName()));
//                    if (tap == arButton.get(i)) {
//                        JFrame jFrame = new JFrame();
//                        JOptionPane.showMessageDialog(jFrame, "ОПА! ну шо ты дорогой иди сюда");
//                    }
//                        jButton = new JButton();
//                        jButton.setBounds(i * SCALE, yLength * SCALE, SCALE, SCALE);
//                        action = new Action(jButton);
//                        jButton.addActionListener(action);
//                        jButton.addMouseListener(new Listener());
//                        add(jButton);
//
//                    }
//                    yLength += 1;
//                }


//                for (int i = 0; i < mines.length; i++) {
//                    mines[i] = new Mines(bom);
//                }
//                for (Mines mine : mines) {
//                    if (mine != null) {
//                        JLabel back = new JLabel(new ImageIcon(Objects.requireNonNull(BomGame.class.getResource("/resources/mine.png"))));
//                        back.setBounds(posX() * SCALE, posY() * SCALE, SCALE, SCALE);
//                        back.addMouseListener(new Listener());
//                        add(back);
//
//                    }
//                }
//            }
//                for (int i = 0; i < arButton.size(); i++) {
//
//                }


    static Image img(String file) {
        return new ImageIcon(Objects.requireNonNull(BomGame.class.getResource(file))).getImage();
    }

    static void arraysFulling(int[][] arrays) {
        for (int i = 1; i <= 80; i++) {
            int a = posX();
            int b = posY();

            for (int j = 0; j < 1; j++) {
                if (arrays[a][b] == 0) {
                    arrays[a][b] = bom;

                } else {
                    i = i - 1;
                }
            }
        }
    }

    static int posX() {
        return (int) (Math.random() * BomGame.WIDTH);
    }

    static int posY() {
        return (int) (Math.random() * BomGame.HEIGHT);
    }

//    static String getId(JButton[][] arrayJb) {
//        for (int i = 0; i < arrayJb.length; i++) {
//            for (int j = 0; j <arrayJb[i].length; j++) {
//
//                jButtonMine.getName();
//            }
//
//
//        }
//
//        return null;
//    }
}
