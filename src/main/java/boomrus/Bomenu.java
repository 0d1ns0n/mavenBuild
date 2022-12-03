package boomrus;

import org.example.ProjectSnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Bomenu {
    public static Action action;
    public static Menu menu = new Menu();
    public static ChangeLevel changeLevel = new ChangeLevel();
    public static Info info = new Info();
    public static JFrame jFrame;


    public static void main(String[] args) {
        jFrame = new JFrame("Menu");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(BomGame.WIDTH * BomGame.SCALE, BomGame.HEIGHT * BomGame.SCALE + BomGame.SCALE);
        jFrame.setResizable(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(menu);
        jFrame.add(changeLevel);
        jFrame.add(info);
        changeLevel.setVisible(false);
        info.setVisible(false);
        jFrame.setVisible(true);
    }


    static class ChangeLevel extends JPanel {
        public static JButton es = new JButton("    ");
        public static JButton med = new JButton("    ");
        public static JButton hard = new JButton("    ");

        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(img("/resources/fonBomGame.png"), 0, 0, this);
        }

        public ChangeLevel() {
            setSize(Menu.WIDTH * Menu.SCALE, Menu.HEIGHT * Menu.SCALE);
            setLayout(null);
            es.setBounds(15, 30, 70, 70);
            med.setBounds(310, 80, 80, 70);
            hard.setBounds(300, 400, 70, 70);
            but(es);
            but(med);
            but(hard);
            action = new Action(es);
            es.addActionListener(action);
            action = new Action(med);
            med.addActionListener(action);
            action = new Action(hard);
            hard.addActionListener(action);
            add(es);
            add(med);
            add(hard);

        }
    }

    static class Info extends JPanel {
        public static JButton back = new JButton();

        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(img("/resources/fonInfoBom.gif"), 0, 0, this);
        }

        public Info() {
            setSize(Menu.WIDTH * Menu.SCALE, Menu.HEIGHT * Menu.SCALE);
            setLayout(null);
            back.setBounds(0, 0, 800, 800);
            action = new Action(back);
            back.addActionListener(action);
            but(back);
            add(back);

        }
    }

    static class Menu extends JPanel {
        public static final int SCALE = 32;
        public static final int WIDTH = 20;
        public static final int HEIGHT = 20;
        public static JButton jButtonS;
        public static JButton jButtonO;
        public static JButton jButtonI;
        public static JButton jButtonE;

        @Override
        protected void paintComponent(Graphics g) {
            g.drawImage(img("/resources/fonBomenu.png"), 0, 0, this);
        }

        public Menu() {
            setSize(WIDTH * SCALE, HEIGHT * SCALE);

            setLayout(null);
            jButtonS = new JButton("     ");
            jButtonO = new JButton("       ");
            jButtonI = new JButton("    ");
            jButtonE = new JButton("    ");
            jButtonS.setBounds(180, 20, 70, 30);
            jButtonO.setBounds(90, 74, 80, 30);
            jButtonI.setBounds(180, 125, 70, 30);
            jButtonE.setBounds(90, 180, 70, 30);
            action = new Action(jButtonS);
            jButtonS.addActionListener(action);
            action = new Action(jButtonO);
            jButtonO.addActionListener(action);
            action = new Action(jButtonI);
            jButtonI.addActionListener(action);
            but(jButtonS);
            but(jButtonO);
            but(jButtonI);
            but(jButtonE);
            add(jButtonS);
            add(jButtonO);
            add(jButtonI);
            add(jButtonE);

        }
    }

    static class Action implements ActionListener {
        public Action(JButton b) {

            tap = b;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (tap == Menu.jButtonS) {
                menu.setVisible(false);
                jFrame.add(new BomGame());
                jFrame.setSize(BomGame.WIDTH * BomGame.SCALE + 80, BomGame.HEIGHT * BomGame.SCALE + 80);
            }
            if (tap == Menu.jButtonO) {
                menu.setVisible(false);
                jFrame.setTitle("Option");
                changeLevel.setVisible(true);

            }
            if (tap == Menu.jButtonI) {
                menu.setVisible(false);
                jFrame.setTitle("Info");
                jFrame.setSize(800, 835);
                info.setVisible(true);

            }
            if (tap == Info.back) {
                info.setVisible(false);
                jFrame.setTitle("Menu");
                jFrame.setSize(640, 675);
                menu.setVisible(true);
            }
            if (tap == Menu.jButtonE) {
                System.exit(0);
            }
            if (tap == ChangeLevel.es) {
                BomGame.hardLvl = 20;
                changeLevel.setVisible(false);
                menu.setVisible(true);
                jFrame.setTitle("Menu");

            }
            if (tap == ChangeLevel.med) {
                BomGame.hardLvl = 50;
                changeLevel.setVisible(false);
                menu.setVisible(true);
                jFrame.setTitle("Menu");
            }
            if (tap == ChangeLevel.hard) {
                BomGame.hardLvl = 80;
                changeLevel.setVisible(false);
                menu.setVisible(true);
                jFrame.setTitle("Menu");
            }


        }

        private final JButton tap;
    }

    static Image img(String file) {
        return new ImageIcon(Objects.requireNonNull(ProjectSnake.class.getResource(file))).getImage();
    }

    static void but(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }
}
