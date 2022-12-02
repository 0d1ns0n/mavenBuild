package boomrus;

import boomrus.object.Mine;
import org.example.ProjectSnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class BomGame extends JPanel {
    public static int hardLvl = 50;
    public static JButton jButton;
    public static JButton button = new JButton("bom");
    public static final int SCALE = 32; // шкала пискселей, размер клетки
    public static final int WIDTH = 20; // ширина
    public static final int HEIGHT = 20;// высота
    public static Mine mine = new Mine(10, 10);
    public static ImageIcon myImage = new ImageIcon(Objects.requireNonNull(BomGame.class.getResource("/resources/mine.png")));

    public static Action action;

    public BomGame() {

        setFocusable(true);
        setLayout(null);
        button.setBounds(100, 100, 50, 50);
        action = new Action(button);
        button.addActionListener(action);
        add(button);

    }

//    public static Component getGame() {
//        jFrame = new JFrame("BOOM ! BITCH!!!");
//
//        jFrame.setSize(WIDTH * SCALE + 16, HEIGHT * SCALE + 6);
//
//        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
////        jFrame.setResizable(false);
//
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.add(new BomGame());
//
//        jFrame.setVisible(true);
//        return null;
//    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(img("/resources/gavno.png"), SCALE - 32, SCALE - 40, this);


        g.setColor(Color.black);
        for (int x = 0; x < WIDTH * SCALE; x += SCALE) {
            g.drawLine(x, 0, x, HEIGHT * SCALE);
        }
        for (int y = 0; y < HEIGHT * SCALE; y += SCALE) {
            g.drawLine(0, y, WIDTH * SCALE, y);
        }
        g.drawImage(myImage.getImage(), mine.posX * SCALE, mine.posY * SCALE, SCALE, SCALE, this);
    }

    class Action implements ActionListener {
        public Action(JButton b) {

            tap = b;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (tap == button) {
//                    JLabel back = new JLabel(new ImageIcon(Objects.requireNonNull(SimpleGUI.class.getResource("/resources/mine.png"))));
//                    back.setBounds(posXX() * SCALE, posYY() * SCALE, SCALE, SCALE);
//                    add(back);
//                    repaint();
//int[][] table = new int[WIDTH][HEIGHT];
//                    for (int x = 0; x < WIDTH; x ++) {
//                        jButton.setBounds(x, 0, x, HEIGHT);
//                        add(jButton);
//                    }
//                    for (int y = 0; y < HEIGHT; y ++) {
//                        jButton.setBounds(0, y, WIDTH, y);
//                        add(jButton);
//                    }
//                int ind = 0;
//                for (int i = 0; i <= table.length -1; i++) {
//                    for (int j = 0; j <= table[i].length -1; j++) {
//table[i][j] = ind++;
//                    }
//
//                }
                int[] table = new int[WIDTH];
                for (int y = 0; y <= HEIGHT - 1; y++) {
                    for (int i = 0; i <= table.length - 1; i++) {
                        jButton = new JButton();
                        jButton.setBounds(y * SCALE, 0, SCALE, SCALE);
                        add(jButton);
                    }
                    y+=1;
                }
            }
            repaint();
        }

        private final JButton tap;
    }

    static Image img(String file) {
        return new ImageIcon(Objects.requireNonNull(ProjectSnake.class.getResource(file))).getImage();
    }

    static int posXX() {
        return (int) (Math.random() * BomGame.WIDTH - 1);
    }

    static int posYY() {
        return (int) (Math.random() * BomGame.HEIGHT - 1);
    }
}
