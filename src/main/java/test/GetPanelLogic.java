package test;

import javax.swing.*;

public class GetPanelLogic extends BomNewBrain {

    static void tapToTable(JButton bb) {


            for (int i = 0; i < list.size() - 1; i++) {
                for (JButton b : list) {

                    if (b.equals(bb) && bb.getName().equals("" + i) && bb.getIcon() == null) {
clear(b);
                        switch (clear(b)) {
                            case 0 -> {


                            }

                            case 1 -> list.get(list.indexOf(b)).setIcon(button1.getIcon());
                            case 2 -> list.get(list.indexOf(b)).setIcon(button2.getIcon());
                            case 3 -> list.get(list.indexOf(b)).setIcon(button3.getIcon());
                            case 4 -> list.get(list.indexOf(b)).setIcon(button4.getIcon());
                            case 5 -> list.get(list.indexOf(b)).setIcon(button5.getIcon());
                        }


                        break;
                    }

            }
        }
    }

    static int clear(JButton next) {

        int countM = 0;
        int thisB = 1;
        int UnD = 20;


        for (JButton b : list) {

            if (next.equals(b)) {
                int m = list.indexOf(b);
//                    System.out.println(m+"index   INFO FOR METHOD");

                if (m - thisB > -1 && m + thisB < 400) {

                    if (m%20 !=19 ) {
                        if (list.get(m + thisB).getName().equals("m")) {
                            System.out.println("right");
                            countM++;
                        }
                    }

                    if (m%20 !=0 ) {
                        if (list.get(m - thisB).getName().equals("m")) {
                            countM++;
                        }
                    }
                }

                // toUP
                if (m - UnD > -1 && m -(UnD + thisB) > -1) {
                    System.out.println("u");
                    if ((m - UnD)%20 !=19 ) {
                        if (list.get(m - (UnD - thisB)).getName().equals("m")) {
                            System.out.println("right-20");
                            countM++;
                        }
                    }

                    if (list.get(m - UnD).getName().equals("m")) {
                        countM++;
                    }

                    if (((m- UnD)%20 !=0 )) {
                        if (list.get(m - (UnD + thisB)).getName().equals("m")) {
                            countM++;
                        }
                    }
                }

                if (m + UnD < 399  ) {
                    System.out.println("d");
                    //toDown

                    if ((m + UnD)%20 != 19) {
                        if (list.get(m + (UnD + thisB)).getName().equals("m")) {
                            System.out.println("right");
                            countM++;
                        }
                    }

                    if (list.get(m + UnD).getName().equals("m")) {
                        countM++;
                    }

                    if (((m + UnD)%20 != 0)) {
                        if (list.get(m + (UnD - thisB)).getName().equals("m")) {
                            countM++;
                        }
                    }

                }
            }

        }
        System.out.println(countM);
        return countM;
    }

}
