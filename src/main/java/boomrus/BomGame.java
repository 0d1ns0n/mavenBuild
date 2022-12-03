package boomrus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    public static int[][] table = new int[WIDTH][HEIGHT];
    public static int[] mines;
    public static ImageIcon imageIcon;

    public BomGame() {

        setFocusable(true);
        setLayout(null);
        button.setBounds((BomGame.WIDTH * BomGame.SCALE + 16) / 2, 650, 70, 30);
        action = new Action(button);
        button.addActionListener(action);
        add(button);
        mines = new int[hardLvl];
        arraysFulling(table);
//        int yLength = 0;
//        for (int y = 0; y <= table.length - 1; y++) {
//
//            for (int i = 0; i <= table[y].length - 1; i++) {
//                if(table[y][i] == bom){
//                    jButtonMine = new JButton(new ImageIcon(Objects.requireNonNull(BomGame.class.getResource("/resources/mine.png"))));
//                    jButtonMine.setBounds(i * SCALE, yLength * SCALE, SCALE, SCALE);
//                    action = new Action(jButtonMine);
//                    jButtonMine.addActionListener(action);
//                    jButtonMine.addMouseListener(new Listener());
//                    add(jButtonMine);
//                }
//                else {
//                    jButtonTable = new JButton();
//                    jButtonTable.setBounds(i * SCALE, yLength * SCALE, SCALE, SCALE);
//                    action = new Action(jButtonTable);
//                    jButtonTable.addActionListener(action);
//                    jButtonTable.addMouseListener(new Listener());
//                    add(jButtonTable);
//
//                }
//            }
//            yLength += 1;
//        }

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

    static class Listener implements MouseListener {
        //        public Listener(JButton b){
//            panel = b;
//            bom = b;
//        }
        @Override
        public void mouseClicked(MouseEvent e) {
//            JLabel jLabel = (JLabel) e.getSource();
//            new JLabel(new ImageIcon(Objects.requireNonNull(BomGame.class.getResource("/resources/bomBOM.png"))));
//            Button button1 =(Button) e.getSource();
//            button1.setVisible(false);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            JButton jButton = (JButton) e.getSource();
            jButton.setVisible(false);
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
//        private final JButton panel;
//        private JButton bom;
    }

    class Action implements ActionListener {
        public Action(JButton b) {

            tap = b;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
//            Mines[] mines = new Mines[hardLvl];

int name = 0;
            if (tap == button) {
                int yLength = 0;
                for (int y = 0; y <= table.length - 1; y++) {

                    for (int i = 0; i <= table[y].length - 1; i++) {
                        if (table[y][i] == bom) {
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
                            jButtonMine = new JButton("" + (i + 1));
                            jButtonMine.setBounds(i * SCALE, yLength * SCALE, SCALE, SCALE);
                            action = new Action(jButtonMine);
                            jButtonMine.addActionListener(action);
                            jButtonMine.addMouseListener(new Listener());
                            add(jButtonMine);
                        } else {
                            jButtonTable = new JButton();
                            jButtonTable.setBounds(i * SCALE, yLength * SCALE, SCALE, SCALE);
                            action = new Action(jButtonTable);
                            jButtonTable.addActionListener(action);
                            jButtonTable.addMouseListener(new Listener());
                            add(jButtonTable);

                        }
                        if (tap == jButtonMine) {
                            JFrame jFrame = new JFrame();
                            JOptionPane.showMessageDialog(jFrame, "ОПА! ну шо ты дорогой иди сюда");
                        }
                    }
                    yLength += 1;
                }
                int i, n = 9;

                n++;
                JButton[] buttons = new JButton[n];
                n = n - 1;

                for (i = 0; i <= n; i++) {
                    buttons[i] = new JButton("" + i);
                    add(buttons[i]);
                }


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
                if (tap == jButtonMine) {
                    JFrame jFrame = new JFrame();
                    JOptionPane.showMessageDialog(jFrame, "ОПА! ну шо ты дорогой иди сюда");
                }

                repaint();
            }
        }

        private final JButton tap;
    }

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
}
