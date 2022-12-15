package test;

import guistudy.TestFrame;

import javax.swing.*;

public class BomNewBrain extends BrainButtons {
   public static JFrame jFrame;


        public BomNewBrain() {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            setSize(WIDTH * SCALE + 18, HEIGHT * SCALE + 80);

            setLocationRelativeTo(null);

            setResizable(false);

            add(jPanel);
            jPanel.setLayout(null);
            button.setBounds((TestFrame.WIDTH * TestFrame.SCALE - 50) / 2, 650, 70, 30);
            BrainButtons buttons = new BrainButtons();
            button.addActionListener(buttons);
            jPanel.add(button);

            arraysFulling(table);
        }

    static void arraysFulling(int[][] arrays) {
        for (int i = 1; i <= lvl; i++) {
            int a = (int) (Math.random() * 20);
            int b = (int) (Math.random() * 20);

            for (int j = 0; j < 1; j++) {
                if (arrays[a][b] == 0) {
                    arrays[a][b] = mineID;

                } else {
                    i = i - 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        jFrame = new BomNewBrain();
        jFrame.setVisible(true);

    }
}
