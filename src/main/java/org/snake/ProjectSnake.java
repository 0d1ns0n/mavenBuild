package org.snake;

import org.snake.obj.Apple;
import org.snake.obj.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class ProjectSnake extends JPanel implements ActionListener {


    final ImageIcon apple = img("/resources/icons8-яблоко-48.png");
    final ImageIcon snakeBody = img("/resources/snakeBody.png");
    final ImageIcon snakeHead = img("/resources/snakeHead.png");
    final ImageIcon fon = img("/resources/dashanew.png");
    final ImageIcon snakeHeadRight = img("/resources/snakeHeadRight.png");
    final ImageIcon snakeBodyRight = img("/resources/snakeBodyRight.png");
    final ImageIcon snakeBodyLeft = img("/resources/snakeBodyLeft.png");
    final ImageIcon snakeHeadLeft = img("/resources/snakeHeadLeft.png");
    final ImageIcon snakeHeadDown = img("/resources/snakeHeadDown.png");
    final ImageIcon snakeBodyDown = img("/resources/snakeBodyDown.png");


    public static final int SCALE = 32; // шкала пискселей, размер клетки
    public static final int WIDTH = 20; // ширина
    public static final int HEIGHT = 20;// высота


    public static int HP = 3;
    public Snake snake = new Snake(5, 6, 5, 5);
    public Apple applePos = new Apple(8, 2);
    public static int speed = 0;
    public Timer timer = new Timer(1000 / speed, this);


    public ProjectSnake() {
        timer.start();
        addKeyListener(new KeyB());
        setFocusable(true);
    }

    public static void frm() {
        JFrame jFrame = new JFrame("You love it game");

        jFrame.setSize(WIDTH * SCALE + 16, HEIGHT * SCALE + 6);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jFrame.setResizable(false);

        jFrame.setLocationRelativeTo(null);

        jFrame.add(new ProjectSnake());

        jFrame.setVisible(true);
    }


    @Override
    public void paint(Graphics g) {
        g.drawImage(fon.getImage(), SCALE - 40, SCALE - 40, this);


        g.setColor(Color.black);
        for (int x = 0; x < WIDTH * SCALE; x += SCALE) {
            g.drawLine(x, 0, x, HEIGHT * SCALE);
        }
        for (int y = 0; y < HEIGHT * SCALE; y += SCALE) {
            g.drawLine(0, y, WIDTH * SCALE, y);
        }

        for (int i = 0; i < snake.length; i++) {

            if (snake.runBody == 1) {
                repaint();
                g.drawImage(snakeBodyRight.getImage(), snake.snakeX[i] * SCALE, snake.snakeY[i] * SCALE,
                        SCALE, SCALE, this);

                g.drawImage(snakeHeadRight.getImage(), snake.snakeX[0] * SCALE, snake.snakeY[0] * SCALE,
                        SCALE, SCALE, this);
            }
            if (snake.runBody == 0) {
                repaint();
                g.drawImage(snakeBody.getImage(), snake.snakeX[i] * SCALE, snake.snakeY[i] * SCALE,
                        SCALE, SCALE, this);

                g.drawImage(snakeHead.getImage(), snake.snakeX[0] * SCALE, snake.snakeY[0] * SCALE,
                        SCALE, SCALE, this);
            }
            if (snake.runBody == 2) {
                repaint();
                g.drawImage(snakeBodyDown.getImage(), snake.snakeX[i] * SCALE, snake.snakeY[i] * SCALE,
                        SCALE, SCALE, this);

                g.drawImage(snakeHeadDown.getImage(), snake.snakeX[0] * SCALE, snake.snakeY[0] * SCALE,
                        SCALE, SCALE, this);
            }
            if (snake.runBody == 3) {
                repaint();
                g.drawImage(snakeBodyLeft.getImage(), snake.snakeX[i] * SCALE, snake.snakeY[i] * SCALE,
                        SCALE, SCALE, this);

                g.drawImage(snakeHeadLeft.getImage(), snake.snakeX[0] * SCALE, snake.snakeY[0] * SCALE,
                        SCALE, SCALE, this);
            }


        }

        g.drawImage(apple.getImage(), applePos.posX * SCALE, applePos.posY * SCALE, SCALE, SCALE, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();

        if ((snake.snakeX[0] == applePos.posX) && (snake.snakeY[0] == applePos.posY)) {
            applePos.randomPos();
            snake.length++;
        }
        for (int i = 1; i < snake.length; i++) {

            if ((snake.snakeX[i] == applePos.posX) && (snake.snakeY[i] == applePos.posY)) {
                applePos.randomPos();
            }
        }

        for (int i = 1; i < snake.length; i++) {

            if (snake.snakeY[0] == snake.snakeY[i] && snake.snakeX[0] == snake.snakeX[i]) {
                HP--;
                if (HP == 2) {
                    JOptionPane.showMessageDialog(this, "You have two chanse, or die", "2 LIFE", JOptionPane.INFORMATION_MESSAGE);
                }
                if (HP == 1) {
                    JOptionPane.showMessageDialog(this, "You have one chanse, or really die", "1 LIFE", JOptionPane.INFORMATION_MESSAGE);
                }
                if (HP == 0) {
                    JOptionPane.showMessageDialog(this, "Good game, but not you!", "END y road", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                snake.length = 2;
            }
        }
        repaint();
    }

    private class KeyB extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int k = e.getKeyCode();
            if (k == KeyEvent.VK_UP && snake.runBody != 2) {
                snake.runBody = 0;
            }
            if (k == KeyEvent.VK_DOWN && snake.runBody != 0) {
                snake.runBody = 2;
            }
            if (k == KeyEvent.VK_LEFT && snake.runBody != 1) {
                snake.runBody = 3;
            }
            if (k == KeyEvent.VK_RIGHT && snake.runBody != 3) {
                snake.runBody = 1;
            }
        }
    }

    private ImageIcon img(String name) {
        return new ImageIcon(Objects.requireNonNull(ProjectSnake.class.getResource(name)));
    }


}