package boomrus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class BomGameOldBrainWRONG extends JPanel {

    // Ниже находится блок отвечающий за (набор всех статиков
    public static final int bom = 999;
    public static int indexTable = 1;
    public static int indexMine = 1;
    public static JButton jButtonMine;
    public static JButton FLAG = new JButton(new ImageIcon("src/main/resources/iconFlag.png"));
    public static JButton jButtonMineIcon = new JButton(new ImageIcon("src/main/resources/mine.png"));
    public static JButton jButtonTable;
    public static JFrame jFrame;
    public static int hardLvl = 0;
    public static JButton button = new JButton("bom");
    public static final int SCALE = 32; // шкала пискселей, размер клетки
    public static final int WIDTH = 20; // ширина
    public static final int HEIGHT = 20;// высота
    public static Action action;
    public static int[][] table = new int[WIDTH][HEIGHT];


    // Ниже находится блок отвечающий за основую логику и окно игры
    public BomGameOldBrainWRONG() {

        action = new Action(button);

        setFocusable(true);
        setLayout(null);


        button.setBounds((BomGameOldBrainWRONG.WIDTH * BomGameOldBrainWRONG.SCALE + 16) / 2, 650, 70, 30);
        button.addActionListener(action);
        add(button);


        arraysFulling(table);
        int yLength = 0;

        for (int i = 0; i <= table.length - 1; i++) {
            for (int j = 0; j <= table[i].length - 1; j++) {
                if (table[i][j] == bom) {
                    jButtonMine = new JButton();
                    jButtonMine.setIcon(button.getIcon());
                    jButtonMine.setName("mine" + indexMine++);
                    jButtonMine.setBounds(j * SCALE, yLength * SCALE, SCALE, SCALE);
                    action = new Action(jButtonMine);
                    jButtonMine.addActionListener(action);
                    jButtonMine.addMouseListener(action);
                    add(jButtonMine);

                } else {

                    jButtonTable = new JButton();
                    jButtonTable.setIcon(button.getIcon());
                    jButtonTable.setName("table" + indexTable++);
                    jButtonTable.setBounds(j * SCALE, yLength * SCALE, SCALE, SCALE);
                    action = new Action(jButtonTable);
                    jButtonTable.addActionListener(action);
                    jButtonTable.addMouseListener(action);
                    add(jButtonTable);
                }
            }
            yLength++;
        }
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[i].length; j++) {

                System.out.print(table[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println(jButtonMine.getName());
        System.out.println(jButtonTable.getName());


    }

    // Ниже находится блок отвечающий за графическую прорисовку
    public void paintComponent(Graphics g) {
        g.drawImage(img("/resources/gavno.png"), SCALE - 32, SCALE - 40, this);


        g.setColor(Color.black);
        for (int x = 0; x <= WIDTH * SCALE; x += SCALE) {
            g.drawLine(x, 0, x, HEIGHT * SCALE);
        }
        for (int y = 0; y <= HEIGHT * SCALE; y += SCALE) {
            g.drawLine(0, y, WIDTH * SCALE, y);
        }


    }


    // Ниже находится блок отвечающий за ещё одну логику на этапе написание info 04/12/22 t10:11 - логика только открытия мин
    class Action implements ActionListener, MouseListener {
        public Action(JButton button) {
            tap = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();


            System.out.println(e.getSource());

            for (int i = 1; i < indexTable; i++) {
                if (b.getName().equals("table" + i) && tap == b) {
                    b.setIcon(button.getIcon());
                } else if (b.getName().equals("mine" + i) && tap == b) {
                    b.setIcon(jButtonMine.getIcon());
                }
            }
            repaint();
        }

        private final JButton tap;

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            JButton b = (JButton) e.getSource();
            if (e.getButton() == MouseEvent.BUTTON3) {

                for (int i = 1; i < indexTable; i++) {
                    if (b.getName().equals("table" + i) && tap == b) {


                        b.setIcon(new ImageIcon("src/main/resources/iconFlag.png"));
                    } else if (b.getName().equals("mine" + i) && tap == b) {
                        b.setIcon(new ImageIcon("src/main/resources/iconFlag.png"));

                    }
                }
            } else if (e.getButton() == MouseEvent.BUTTON1) {

                for (int i = 1; i < indexTable; i++) {
                    if (b.getName().equals("mine" + i) && tap == b && b.getIcon() == button.getIcon()) {
                        JOptionPane.showMessageDialog(jFrame, "ОПА! ну шо ты дорогой, на в ебало!");
                        System.exit(0);
                    } else if
                    (b.getName().equals("table" + i) && tap == b && b.getIcon() == button.getIcon()) {
                        b.setVisible(false);

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

    // Ниже находится блок отвечающий за статик добавление картинок
    static Image img(String resource) {
        return new ImageIcon(Objects.requireNonNull(BomGameOldBrainWRONG.class.getResource(resource))).getImage();
    }

    // Ниже находится блок статик отвечающий за заполнение массива бомбами !!!
    static void arraysFulling(int[][] arrays) {
        for (int i = 1; i <= hardLvl; i++) {
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
        return (int) (Math.random() * BomGameOldBrainWRONG.WIDTH);
    }

    static int posY() {
        return (int) (Math.random() * BomGameOldBrainWRONG.HEIGHT);
    }

}
