package boomrus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class BomGame extends JPanel {
    // Ниже находится блок отвечающий за (набор всех статиков
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
    public static JButton[][] min;



    // Ниже находится блок отвечающий за основую логику и окно игры
    public BomGame() {

        setFocusable(true);
        setLayout(null);


        button.setBounds((BomGame.WIDTH * BomGame.SCALE + 16) / 2, 650, 70, 30);
        action = new Action();
        button.addActionListener(action);
        add(button);


        mines = new int[hardLvl];
        arraysFulling(table);
        min = new JButton[WIDTH][HEIGHT];
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
                                action = new Action();
                                jButtonMine.addActionListener(action);
                                add(jButtonMine);
                            }
                        }
                    }
                } else {
                    jButtonTable = new JButton();
                    jButtonTable.setBounds(j * SCALE, yLength * SCALE, SCALE, SCALE);
                    action = new Action();
                    jButtonTable.addActionListener(action);
                    jButtonTable.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {}

                        @Override
                        public void mousePressed(MouseEvent e) {
                            jButtonTable = (JButton) e.getSource();
                            jButtonTable.setVisible(false);
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {}

                        @Override
                        public void mouseEntered(MouseEvent e) {}

                        @Override
                        public void mouseExited(MouseEvent e) {}
                    });
                    add(jButtonTable);
                }
            }
            yLength++;
        }
    }

    // Ниже находится блок отвечающий за графическую прорисовку
    public void paintComponent(Graphics g) {
        g.drawImage(img(), SCALE - 32, SCALE - 40, this);


        g.setColor(Color.black);
        for (int x = 0; x <= WIDTH * SCALE; x += SCALE) {
            g.drawLine(x, 0, x, HEIGHT * SCALE);
        }
        for (int y = 0; y <= HEIGHT * SCALE; y += SCALE) {
            g.drawLine(0, y, WIDTH * SCALE, y);
        }


    }

    // Ниже находится блок отвечающий за ещё одну логику на этапе написание info 04/12/22 t10:11 - логика только открытия мин
    class Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame jFrame = new JFrame();
            Object obj = e.getSource();
            jButtonMine = (JButton) obj;
            for (JButton[] jButtons : min) {
                for (int j = 0; j < jButtons.length; j++) {
                    if (jButtonMine.getName().equals("mine" + j)) {

                        JOptionPane.showMessageDialog(jFrame, "ОПА! ну шо ты дорогой иди сюда");
                        System.exit(0);
//                        try {
//                            Thread.sleep(3000);
//                            System.exit(0);
//
//                        } catch (InterruptedException ex) {
//                            throw new RuntimeException(ex);
                    }
                }
            }
            repaint();
        }
    }

    // Ниже находится блок отвечающий за статик добавление картинок
    static Image img() {
        return new ImageIcon(Objects.requireNonNull(BomGame.class.getResource("/resources/gavno.png"))).getImage();
    }

    // Ниже находится блок отвечающий за статик отвечающий за заполнение массива бомбами !!!
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

    // Ниже находится блок отвечающий за рандом разброс - может будет удалён
    static int posX() {
        return (int) (Math.random() * BomGame.WIDTH);
    }

    static int posY() {
        return (int) (Math.random() * BomGame.HEIGHT);
    }


}
