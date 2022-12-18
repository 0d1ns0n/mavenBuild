package org.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static org.snake.ProjectSnake.frm;

public class ButtonFrame extends JFrame implements ActionListener {
    static JFrame jFrame;

    static JButton start = new JButton("Let's go");
    static JButton lvl = new JButton("Change level");
    static JButton exit = new JButton("NO, i am a scared");
    static JButton easy = new JButton("I am a little pony");
    static JButton medium = new JButton("Mommy won't help you");
    static JButton hard = new JButton("You can do it son!");

    public ButtonFrame() {
        setTitle("This is the main menu");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new JLabel(img()));
        setLayout(new FlowLayout());
//menu
        start.addActionListener(this);
        lvl.addActionListener(this);
        exit.addActionListener(this);
        add(start);
        add(lvl);
        add(exit);
//change
        easy.addActionListener(this);
        medium.addActionListener(this);
        hard.addActionListener(this);
        add(easy);
        add(medium);
        add(hard);
        initC();


    }

    void initM() {
        start.setVisible(false);
        lvl.setVisible(false);
        exit.setVisible(false);
        easy.setVisible(true);
        medium.setVisible(true);
        hard.setVisible(true);
    }

    void initC() {
        easy.setVisible(false);
        medium.setVisible(false);
        hard.setVisible(false);
        start.setVisible(true);
        lvl.setVisible(true);
        exit.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getActionCommand().equals("NO, i am a scared")) {
            int res = JOptionPane.showConfirmDialog(
                    this,
                    "You really fink this?",
                    "Exit",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
                return;
            }
        }
        if (e.getActionCommand().equals("Let's go")) {
            if (ProjectSnake.speed > 0) {
                jFrame.setVisible(false);
                frm();
            } else {
                JOptionPane.showMessageDialog(lvl, "You must change the game level, tap to \"Change level\"");
            }
        }
        if (e.getActionCommand().equals("Change level")) {
            initM();


        }

        if (e.getActionCommand().equals("I am a little pony")) {
            ProjectSnake.speed = 6;
            initC();

        }
        if (e.getActionCommand().equals("Mommy won't help you")) {
            ProjectSnake.speed = 9;
            initC();
        }
        if (e.getActionCommand().equals("You can do it son!")) {
            ProjectSnake.speed = 16;
            initC();
        }
        repaint();
    }

    private ImageIcon img() {
        return new ImageIcon(Objects.requireNonNull(ProjectSnake.class.getResource("/resources/snakeMenu.png")));
    }

    public static void main(String[] args) {
        jFrame = new ButtonFrame();

        jFrame.setVisible(true);
    }

}

