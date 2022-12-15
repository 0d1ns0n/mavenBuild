package guistudy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class TestFrame extends JFrame implements ActionListener {
    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    private final int mineID = 999;
    private final JPanel jPanel = new JPanel();
    private static ArrayList<JButton> list = new ArrayList<>();
    public static int[][] table = new int[WIDTH][HEIGHT];
    public static JButton button = new JButton("BOOM");
    public static JButton button1 = new JButton(new ImageIcon("src/main/resources/1.png"));
    public static JButton button2 = new JButton(new ImageIcon("src/main/resources/2.png"));
    public static JButton button3 = new JButton(new ImageIcon("src/main/resources/3.png"));
    public static JButton button4 = new JButton(new ImageIcon("src/main/resources/4.png"));
    public static JButton button5 = new JButton(new ImageIcon("src/main/resources/5.png"));


    TestFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH * SCALE + 18, HEIGHT * SCALE + 80);
        setLocationRelativeTo(null);
        setResizable(false);
        add(jPanel);
        jPanel.setLayout(null);
        button.setBounds((TestFrame.WIDTH * TestFrame.SCALE - 50) / 2, 650, 70, 30);
        button.addActionListener(this);
        jPanel.add(button);
        arraysFulling(table);
    }

    void arraysFulling(int[][] arrays) {
        for (int i = 1; i <= 20; i++) {
            int a = posX();
            int b = posY();

            for (int j = 0; j < 1; j++) {
                if (arrays[a][b] == 0) {
                    arrays[a][b] = mineID;

                } else {
                    i = i - 1;
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("BOOM")) {
            button.setVisible(false);
int count = 0;
            int yLength = 0;
            for (int i = 0; i <= table.length - 1; i++) {

                for (int j = 0; j <= table[i].length - 1; j++) {
                    if (table[i][j] == mineID) {
                        JButton jButton = new JButton(new ImageIcon("src/main/resources/mine.png"));
                        String strM = i + "m" + j;
                        jButton.setName("m"+ count++);
                        jButton.setBounds(j * SCALE, yLength * SCALE, SCALE, SCALE);
                        jButton.addActionListener(this);
                        jPanel.add(jButton);
                        list.add(jButton);
                    } else {
                        String str = i + "t" + j;
                        JButton jButton = new JButton();
                        jButton.setName(String.valueOf(count++));
                        jButton.setBounds(j * SCALE, yLength * SCALE, SCALE, SCALE);
                        jButton.addActionListener(this);
                        jPanel.add(jButton);
                        list.add(jButton);
                    }
                    System.out.print("\t");
                }
                System.out.println(list.size());
                System.out.println();
                yLength++;

            }
        } else {
            tapToTable((JButton) e.getSource());
        }
        jPanel.revalidate();
        repaint();
    }

    void tapToTable(JButton b) {

        System.out.println(b.getName());
        for (Iterator<JButton> iterator = list.iterator(); iterator.hasNext(); ) {
            JButton n = iterator.next();


            for (int i = 0; i < list.size(); i++) {

                if (n.equals(b) && b.getName().equals("t" + i)) {

                    switch (findB(i,i)) {
                        case 1 -> {
                            list.get(list.indexOf(b)).setIcon(button1.getIcon());
                        }
                        case 2 -> {
                            list.get(list.indexOf(b)).setIcon(button2.getIcon());
                        }
                        case 3 -> {
                            list.get(list.indexOf(b)).setIcon(button3.getIcon());
                        }
                        case 4 -> {
                            list.get(list.indexOf(b)).setIcon(button4.getIcon());
                        }
                        case 5 -> {
                            list.get(list.indexOf(b)).setIcon(button5.getIcon());
                        }
                    }


                    iterator.remove();
                    break;
                }
            }


        }
    }
    static void findList(int i){
        list.forEach(button -> {
//
//                if (number(button,i)){
//
//                //up
//
//                // basic
//
//
//                    //down
//                }
//                else if (button.getName().equals("m"+i)){
//
//                }



//                boolean inBack = button.getName().equals(i + "t" + (j - 1));
//                boolean in = button.getName().equals(i + "t" + j);
//                boolean inNext = button.getName().equals(i + "t" + (j + 1));
//                // to UP panel
//                boolean inUPBack = button.getName().equals((i - 1) + "t" + (j - 1));
//                boolean inUP = button.getName().equals((i - 1) + "t" + j);
//                boolean inUPNext = button.getName().equals((i - 1) + "t" + (j + 1));
//                //
        });


    }
   static void number( int i, String name){
//        String.valueOf(int i - 1 )
//        boolean back = (int)i-1;
       for (JButton tap : list) {
           if (name.equals("next")) {
               boolean next = tap.getName().equals("m" + (i + 1));
           }
           if (name.equals("back")) {
               boolean back = tap.getName().equals("m" + (i - 1));
           }
               if (name.equals("UPnext")) {
                   boolean UPnext = tap.getName().equals("m" + (i - 21));
               }
                   if (name.equals("UPthis")) {
                       boolean UPthis = tap.getName().equals("m" + (i - 20));
                   }
                       if (name.equals("UPback")) {
                           boolean UPback = tap.getName().equals("m" + (i - 19));
                       }
                           if (name.equals("DownN")) {
                               boolean DownN = tap.getName().equals("m" + (i + 21));
                           }
                               if (name.equals("DownThis")) {
                                   boolean DownThis = tap.getName().equals("m" + (i + 20));
                               }
                                   if (name.equals("DownB")) {
           boolean DownB = tap.getName().equals("m" + (i + 21));
}
       }


   }

//    static class Action implements MouseListener {
//        public Action(JButton button) {
//            tap = button;
//        }
//
//        private final JButton tap;
//
//        @Override
//        public void mouseClicked(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//            JFrame jFrame = new JFrame();
//
//            JButton b[][] = (JButton[][]) e.getSource();
//            if (e.getButton() == MouseEvent.BUTTON3) {
//                for (int i = 0; i <= jButton.length - 1; i++) {
//                    for (int j = 0; j <= jButton[i].length - 1; j++) {
//
//
//                        if (b[i][j].getName().equals("table" + i) ) {
//
//
//                            b[i][j].setIcon(new ImageIcon("src/main/resources/iconFlag.png"));
//                        } else if (b[i][j].getName().equals("mine" + i) ) {
//                            b[i][j].setIcon(new ImageIcon("src/main/resources/iconFlag.png"));
//                        }
//                    }
//                }
//            } else if (e.getButton() == MouseEvent.BUTTON1) {
//
//                for (int i = 0; i <= jButton.length - 1; i++) {
//                    for (int j = 0; j <= jButton[i].length - 1; j++) {
//
//                        if (b[i][j].getName().equals("mine" + i) && b[i][j].getIcon() == button.getIcon()) {
//                            JOptionPane.showMessageDialog(jFrame, "ОПА! ну шо ты дорогой, на в ебало!");
//                            System.exit(0);
//                        } else if
//                        (b[i][j].getName().equals("table" + i) &&  b[i][j].getIcon() == button.getIcon()) {
//                            b[i][j].setVisible(false);
//
//                        }
//                    }
//                }
//            }
//        }
//
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//
//        }
//    }


    @Override
    public void paintComponents(Graphics g) {
        g.drawImage(img("/resources/gavno.png"), SCALE - 32, SCALE - 40, this);
        repaint();

    }

    static Image img(String resource) {
        return new ImageIcon(Objects.requireNonNull(BomGameOldBrainWRONG.class.getResource(resource))).getImage();
    }

    static int posX() {
        return (int) (Math.random() * 20);
    }

    static int posY() {
        return (int) (Math.random() * 20);
    }

    static int findB(int i, int j) {

        int countM = 0;

        for (JButton next : list) {

            if (next.getName().equals((i) + "m" + (j + 1))) {
                countM++;
            }
            if (next.getName().equals((i) + "m" + (j + 1))) {
                countM++;

            }

            if (next.getName().equals((i) + "m" + (j - 1))) {
                countM++;
            }

            if (next.getName().equals((i - 1) + "m" + (j - 1))) {
                countM++;
            }

            if (next.getName().equals((i - 1) + "m" + (j))) {
                countM++;
            }

            if (next.getName().equals((i - 1) + "m" + (j + 1))) {
                countM++;
            }

            if (next.getName().equals((i + 1) + "m" + (j - 1))) {
                countM++;
            }

            if (next.getName().equals((i + 1) + "m" + (j))) {
                countM++;
            }

            if (next.getName().equals((i + 1) + "m" + (j + 1))) {
                countM++;
            }
        }
        return countM;
    }
    static int findP(int i, int j, String buttonObj) {

        int countM = 0;

        for (JButton next : list) {

            if (next.getName().equals((i) + buttonObj + (j + 1))) {
                countM++;
            }
            if (next.getName().equals((i) + buttonObj + (j + 1))) {
                countM++;

            }

            if (next.getName().equals((i) + buttonObj + (j - 1))) {
                countM++;
            }

            if (next.getName().equals((i - 1) + buttonObj + (j - 1))) {
                countM++;
            }

            if (next.getName().equals((i - 1) + buttonObj + (j))) {
                countM++;
            }

            if (next.getName().equals((i - 1) + buttonObj + (j + 1))) {
                countM++;
            }

            if (next.getName().equals((i + 1) + buttonObj + (j - 1))) {
                countM++;
            }

            if (next.getName().equals((i + 1) + buttonObj + (j))) {
                countM++;
            }

            if (next.getName().equals((i + 1) + buttonObj + (j + 1))) {
                countM++;
            }

        }
        return countM;
    }
//            if (next.getName().equals(i + "t" + (j + 1))) {
//                next.setVisible(false);
//                countM++;
//            } else if (next.getName().equals(i + "m" + (j + 1))){
//                list.get(posM -1).setIcon(button1.getIcon());
//                break;
//            }
//            if (next.getName().equals(i + "t" + (j - 1))) {
//                next.setVisible(false);
//            } else if () {
//
//            }
//            if (next.getName().equals((i - 1) + "t" + (j + 1))) {
//                next.setVisible(false);
//            }else if () {
//
//            }
//            if (next.getName().equals((i - 1) + "t" + j)) {
//                next.setVisible(false);
//            }else if () {
//
//            }
//            if (next.getName().equals((i - 1) + "t" + (j - 1))) {
//                next.setVisible(false);
//            }else if () {
//
//            }
//            if (next.getName().equals((i + 1) + "t" + (j - 1))) {
//                next.setVisible(false);
//            }else if () {
//
//            }
//            if (next.getName().equals((i + 1) + "t" + j)) {
//                next.setVisible(false);
//            }else if () {
//
//            }
//            if (next.getName().equals((i + 1) + "t" + (j + 1))) {
//                next.setVisible(false);
//            }else if () {
//
//            }



    void T(JButton button, int i, int j){
        int countM = 0;
        int posM = list.indexOf(button);
       if (button.getName().equals((i) + "m" + (j+ 1))){countM++;};

        if (button.getName().equals((i) + "m" + (j -1))){countM++;};

        if (button.getName().equals((i-1) + "m" + (j-1))){countM++;};

        if (button.getName().equals((i-1) + "m" + (j))){countM++;};

        if (button.getName().equals((i-1) + "m" + (j+1))){countM++;};

        if (button.getName().equals((i+1) + "m" + (j-1))){countM++;};

        if (button.getName().equals((i+1) + "m" + (j))){countM++;};

        if (button.getName().equals((i+1) + "m" + (j+1))){countM++;};
    }


    public static void main(String[] args) {
        JFrame frame = new TestFrame();
        frame.setVisible(true);
    }
}


//    private  final  String  BUTTON_NAME = "button1";
//
//    public TestFrame(){
//        super("Menu");
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLayout(null);
//        Act act = new Act();
//JButton jButton = new JButton(act);
//jButton.setName(BUTTON_NAME);
//        jButton.setText("First button");
//        jButton.setMnemonic('F');
//        jButton.setBounds( 100, 100 , 80,80);
//setSize(600,600);
//add(jButton);
//        setVisible(true);
//    }
//    class Act extends AbstractAction {
//        public Act(){
//            putValue(SHORT_DESCRIPTION, "Это подсказка");
//
//        }
//        public void actionPerformed(ActionEvent e){
//JButton b = (JButton) e.getSource();
//            System.out.println("Нажатие на кнопку <" + b.getName() + ">");
//if (b.isEnabled()){
//    b.setEnabled(false);
//    b.setText("PIZDA");
//}
//        }
//
//    }
//    public static void main(String[] args) {
//        new TestFrame();
//    }

//        final int bom = 999;
//
//        int[][] arrays = new int[20][20];
//        for (int[] array : arrays) {
//            Arrays.fill(array, 0);
//        }
//        for (int i = 1; i <= 80; i++) {    // DONE!!!!!!!!!! присвоение нужному индексу значекния
//            int a = rand();
//            int b = rand();
//
//            for (int j = 0; j < 1; j++) {
//                if (arrays[a][b] == 0) {
//                    arrays[a][b] = bom;
//
//                } else {
//                    i = i - 1;
//                }
//            }
//        }
//        array(arrays);
//        System.out.println(countArrays(arrays, bom));
//    }
//
//    static int rand() {
//        return (int) (Math.random() * 20);
//    }
//
//    static int array(int[][] arrays) {
//        for (int[] innerArray : arrays) {
//            for (int data : innerArray) {
//                System.out.print(data + "\t");
//            }
//            System.out.println("");
//        }
//        return 0;
//    }
//
//    static int countArrays(int[][] arrays, int check) {
//        int countCheck = 0;
//        for (int[] array : arrays) {
//            for (int i : array) {
//                if (i == check) {
//                    countCheck++;
//                }
//            }
//        }
//        return countCheck;
//        ArrayList <JButton> name = new ArrayList<>();
//        int[][] array = new int[20][20];
//        for (int i = 0; i <array.length ; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//name.add(new JButton());
//            }
//        }
//        System.out.println(name.size());
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
