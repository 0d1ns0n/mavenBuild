package boomrus;

import java.util.Arrays;

public class TestFrame {
    public static void main(String[] args) {
        final int bom = 999;

        int[][] arrays = new int[20][20];
        for (int[] array : arrays) {
            Arrays.fill(array, 0);
        }
        for (int i = 1; i <= 80; i++) {
            int a = rand();
            int b = rand();

            for (int j = 0; j < 1; j++) {
                if (arrays[a][b] == 0) {
                    arrays[a][b] = bom;

                } else {
                    i = i - 1;
                }
            }
        }
        array(arrays);
        System.out.println(countArrays(arrays, bom));
    }

    static int rand() {
        return (int) (Math.random() * 20);
    }

    static int array(int[][] arrays) {
        for (int[] innerArray : arrays) {
            for (int data : innerArray) {
                System.out.print(data + "\t");
            }
            System.out.println("");
        }
        return 0;
    }

    static int countArrays(int[][] arrays, int check) {
        int countCheck = 0;
        for (int[] array : arrays) {
            for (int i : array) {
                if (i == check) {
                    countCheck++;
                }
            }
        }
        return countCheck;
    }
}
//        int i = 0;
//        while (true) {
//            i++;
//            if (i == 999) {
//                continue;
//
//            }
//
//            if (i == 50) {
//                break;
//            }
//            System.out.println("Шатл № " +i);
//        }

//        for (int[] innerArray: arrays) {
//            for(int data: innerArray) {
//                System.out.print(data+ "\t");
//            }
//            System.out.println("");
//        }
//
//        System.out.println(bomCount1);
//        if (bomCount1 != 50){
//            for (int i = 0; i < 50 - bomCount1; i++) {
//                arrays[rand()][rand()] = bom;
//            }
//        }
//        for (int[] innerArray: arrays) {
//            for(int data: innerArray) {
//                if (data == bom){bomCount2++;}
//            }
//        }
//        System.out.println(bomCount2);
//        for (int[] array : arrays) {
//            for (int i : array) {
//                if (i == 999) {
//                    bomCount++;
//                }
//            }
//        }
//        System.out.println(bomCount);
//            for (int i = 1; i <= arrays.length - 1; i++) {
//                for (int j = 1; j <= arrays[i].length - 1; j++) {
//                    int indR = (int) (Math.random() * 5);
//                    if (indR == 2) {
//                        arrays[i][j] = bom;
//                        bomCount1++;
//                    } else {
//                        arrays[i][j] = 0;
//                        if (bomCount1 == 50){break;}
//                    }
//                    System.out.print(arrays[i][j] + "\t");
//                }
//                System.out.println("");
//            }


//        for (int[] array : arrays) {
//            for (int i : array) {
//                if (i == 999) {
//                    bomCount++;
//                }
//            }
//        }
//        System.out.println(bomCount);

//package boomrus;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//    static int doubleArray(int[][] arrays, int a, int b) {
//        int ind = 0;
//        for (int i = 1; i <= arrays.length - 1; i++) {
//            for (int j = 1; j <= arrays[i].length - 1; j++) {
//                arrays[i][j] = ind++;
//                System.out.print(arrays[i][j] + "\t");
//            }
//            System.out.println("");
//        }
//        if (a % b == 0) {
//            System.out.println("This a array Square");
//        } else {
//            System.out.println("no FUCK OFF");
//        }
//        return 0;
//    }

//    private JLabel eventLabel;
//
//    public TestFrame() {
//        super("Test frame");
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel mainPanel = new JPanel();
//        mainPanel.setLayout(new BorderLayout());
//
//        JPanel buttonsPanel = new JPanel();
//
//        JButton button1 = new JButton("Button 1");
//        button1.setPreferredSize(new Dimension(150, 80));
//        buttonsPanel.add(button1);
//
//        button1.addMouseListener(new CustomListener());
//
//        mainPanel.add(buttonsPanel, BorderLayout.NORTH);
//
//        eventLabel = new JLabel();
//        eventLabel.setHorizontalAlignment(JLabel.CENTER);
//        mainPanel.add(eventLabel, BorderLayout.CENTER);
//
//        getContentPane().add(mainPanel);
//    }
//
//    public static JLabel createEmptyLabel() {
//        JLabel label = new JLabel();
//        label.setPreferredSize(new Dimension(100, 35));
//        return label;
//    }
//
//    public static void main(String[] args) {
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                JFrame.setDefaultLookAndFeelDecorated(true);
//                JFrame frame = new TestFrame();
//                frame.setPreferredSize(new Dimension(330, 160));
//                frame.pack();
//                frame.setLocationRelativeTo(null);
//                frame.setVisible(true);
//            }
//        });
//    }
//
//    public static class CustomListener implements MouseListener {
//
//        public void mouseClicked(MouseEvent e) {
//            JButton button = (JButton) e.getSource();
//            String text = "<html><b>" + button.getText()
//                    + " mouseReleased() <br>" + button.getText()
//                    + " mouseClicked() </b><html>";
//            eventLabel.setText(text);
//        }
//
//        public void mouseEntered(MouseEvent e) {
//
//        }
//
//        public void mouseExited(MouseEvent e) {
//
//        }
//
//        public void mousePressed(MouseEvent e) {
//
//        }
//
//        public void mouseReleased(MouseEvent e) {
//
//        }
//    }
//}
//
