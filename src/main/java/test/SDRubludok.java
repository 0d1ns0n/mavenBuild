package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SDRubludok extends JFrame implements ActionListener {
    public JPanel jPanel = new JPanel();
    public JFrame jFrame = new JFrame();
    public int[] tsk = new int[30];

    private ArrayList<JButton> list = new ArrayList<>();
    public static JButton start = new JButton("ПОСОСИ");

    public SDRubludok() {
        setTitle(" С ДНЮХОЙ ПЕДИК ");
        setSize(800, 800);
        setLocationRelativeTo(null);
        add(jPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        start.setBounds(400, 400, 250, 250);
        start.addActionListener(this);
        jPanel.setLayout(null);
        jPanel.add(start);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ПОСОСИ")) {
            start.setVisible(false);
            for (int i = 0; i < 50; i++) {
                JButton jButton = new JButton("" + i);
                jButton.setName("" + i);

                jButton.setBounds(rand(), rand(), 90, 90);
                jButton.addActionListener(this);
                jPanel.add(jButton);
                list.add(jButton);

            }
        } else {
            goB((JButton) e.getSource());
        }
        repaint();
        jPanel.revalidate();
    }

    void goB(JButton b) {

        try {
            for (JButton getN : list) {
                for (int j = 0; j < 50; j++) {
                    if (getN.equals(b) && b.getName().equals("" + j)) {
                        b.setAction(tskVar(j));
                        b.setVisible(false);
                        if (j != 16) {
                            j = j - 1;
                        }
                        break;
                    }
                }
            }
        } catch(NullPointerException e){
            throw new RuntimeException(e);
        }
    }



//        System.out.println(b.getName());
//        for (JButton getN : list) {
//
//
//            for (int j = 0; j < 50; j++) {
//                if (getN.equals(b) && b.getName().equals("" + j)) {
//                    b.setAction(tskVar(j));
//                    if (tsk[j] != 16) {
//                        j = j - 1;
//
//                    }
//                }
//            }
//            break;
//        }


    Action tskVar(int N) {
        JFrame jFrame = new JFrame();
        switch (N) {
            case 1 -> {
                JOptionPane.showMessageDialog(jFrame, "sosi");
            }
            case 2 -> {
                JOptionPane.showMessageDialog(jFrame, "ты реально подумал это та кнопка, та терйся миша");
            }
            case 3 -> JOptionPane.showMessageDialog(jFrame, "24 кст это возраст гитлера значит ты тоже скоро умрешь");
            case 4 -> JOptionPane.showMessageDialog(jFrame, "ты реально ищешь кнопку? идиот ? ");
            case 5 -> JOptionPane.showMessageDialog(jFrame, "даже не пытайся какой смысл");
            case 6 -> JOptionPane.showMessageDialog(jFrame, "дыбил");
            case 7 -> JOptionPane.showMessageDialog(jFrame, "я тебя наебал нет никаких слов поздравления");
            case 8 -> JOptionPane.showMessageDialog(jFrame, "отсосешь так уж и быть покажу как прочитать это");
            case 9 -> JOptionPane.showMessageDialog(jFrame, "а ты настырный");
            case 10 -> JOptionPane.showMessageDialog(jFrame, "думаешь будешь нажимать их станет меньше? дурак");
            case 11 -> JOptionPane.showMessageDialog(jFrame, "за 50 грн скажу какая кнопка");
            case 12 -> JOptionPane.showMessageDialog(jFrame, " подожди если ты гей, то почему ещё не признался ? ");
            case 13 -> JOptionPane.showMessageDialog(jFrame, "как же ты заебал");
            case 14 -> JOptionPane.showMessageDialog(jFrame, "на биосфере кст работают одни уебаны");
            case 15 -> JOptionPane.showMessageDialog(jFrame, "если бы я был долгом в монобанке мы бы виделись чаще");
            case 16 -> JOptionPane.showMessageDialog(jFrame, "Ладно упёртый ты ублюдок, это та кнопка," +
                    "поздравляю тебя брат с днём рождения, раньше по пьяне мы много чего говорили, желали, так вот я хочу чтобы ты по трезвому слышал все искренние слова" +
                    "хочу чтобы ты понял по истинне что такое счастье в жизни как понял это я, я досих пор храню твои пожелания мне заламинированные на листке бумаге, " +
                    "порою слова братан значат очень много, поэтому здоровья твоей семье и тебе, будь счастлив и не упусти момент - жить!");
            case 17 -> JOptionPane.showMessageDialog(jFrame, "да иди ты нахуй");
            case 18 -> JOptionPane.showMessageDialog(jFrame, "лучше бы на азаль пошел ");
            case 19 -> JOptionPane.showMessageDialog(jFrame, "когда я тебя встретил думал что насру тебе в портфель");
            case 20 -> JOptionPane.showMessageDialog(jFrame, "каким надо быть идиотом чтобы искать эту кнопку");
            case 21 -> JOptionPane.showMessageDialog(jFrame, "ЕЁ ТУТ нет одумайся БЛЯТЬ");
            case 22 -> JOptionPane.showMessageDialog(jFrame, "какие нахуй слова пожелания, ты меня бесишь");
            case 23 -> JOptionPane.showMessageDialog(jFrame, "чтоб на тобой пво ракету сбило ");
            case 24 -> JOptionPane.showMessageDialog(jFrame, "таких как ты ебут менты");
            case 25 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 26 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 27 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 28 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 29 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 30 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 31 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 32 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 33 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 34 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 35 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 36 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 37 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 38 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 39 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 40 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 41 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 42 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 43 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 44 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 45 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 46 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 47 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 48 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 49 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");
            case 50 -> JOptionPane.showMessageDialog(jFrame, "извини их тут дохуя это просто кнопка");

        }
        return null;
    }

    static int rand() {
        return (int) (Math.random() * 1000);
    }

    static int randB() {
        return (int) (Math.random() * 150);
    }

    static int randTask() {
        return (int) (Math.random() * 50);
    }

    public static void main(String[] args) {
        JFrame go = new SDRubludok();
        go.setVisible(true);
    }
}
