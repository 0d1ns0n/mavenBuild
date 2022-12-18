package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class AnyTest extends JFrame implements ActionListener, MouseListener {
    static int count = 0;
    public AnyTest() {
        setTitle("GO DARK");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setBounds(600, 600, 600, 600);
        JPanel jp = new JPanel();
        jp.setBackground(Color.BLACK);
        jp.setLayout(null);
        JButton jb = new JButton("I see");
        jb.addMouseListener(this);
        jb.setBounds(270, 270, 70, 30);
        jb.setBorderPainted(false);
        jb.setFocusPainted(false);
        jb.addActionListener(this);
        jb.setBackground(Color.black);
        jp.add(jb);
        add(jp);
    }


    static void task() {
        Timer timer = new Timer();
        Random random = new Random();
        LinkedList<String> list = new LinkedList<>();

        int count = 0;
        while (count < 100) {
            count++;
            timer.schedule(new TimerTask() {

                @Override
                public void run() {
                    JFrame jf = new JFrame();
                    JButton jb = new JButton(list.get(random.nextInt(list.size())));
                    jf.setSize(200, 200);
                    jf.add(jb);
                    jf.setDefaultCloseOperation(0);
                    jf.setLocation(random.nextInt(1200), random.nextInt(1200));
                    jf.setVisible(true);

                }
            }, 500);
        }
        String line;
        try {
            FileReader fr = new FileReader("C://abc1.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            System.out.println("ERR" + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("I see")) {
            task();
            System.out.println("vvv");
            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame jFrame = new AnyTest();
        jFrame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        Random random;
        if (e.getSource() == button) {
            random = new Random();
            button.setLocation(random.nextInt(550), random.nextInt(550));
            count++;
            System.out.println(count);
            if (count==10) {
                task();
            }
                    }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}