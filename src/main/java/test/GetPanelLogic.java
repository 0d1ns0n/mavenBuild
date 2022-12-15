package test;

import javax.swing.*;

public class GetPanelLogic extends BomNewBrain {

    static void tapToTable(JButton b) {

        for (JButton n : list) {
            for (int i = 0; i <= table.length - 1; i++) {
                for (int j = 0; j <= table[i].length - 1; j++) {

                    if (n.equals(b) && b.getName().equals(i + "t" + j) && b.getIcon() == null) {

                        switch (findB(i, j)) {
                            case 0 -> {


                                list.get(list.indexOf(b)).setVisible(false);
                                list.get(list.indexOf(b) + 1).setVisible(false);
                                list.get(list.indexOf(b) - 1).setVisible(false);
                                //UP clean
                                if (list.indexOf(b) - 20 > -1) {
                                    list.get(list.indexOf(b) - 20).setVisible(false);
                                    list.get(list.indexOf(b) - 21).setVisible(false);
                                    list.get(list.indexOf(b) - 19).setVisible(false);
                                }
                                //DOWN clean
                                list.get(list.indexOf(b) + 20).setVisible(false);
                                list.get(list.indexOf(b) + 21).setVisible(false);
                                list.get(list.indexOf(b) + 19).setVisible(false);

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
    }

    static int findB(int i, int j) {

        int countM = 0;
        for (JButton next : list) {

            if (next.getName().equals(i + "m" + (j + tableClean))) {
                countM++;
            }
            if (next.getName().equals(i + "m" + (j - tableClean))) {
                countM++;
            }

            if (next.getName().equals((i - tableClean) + "m" + (j - tableClean))) {
                countM++;
            }

            if (next.getName().equals((i - tableClean) + "m" + (j))) {
                countM++;
            }

            if (next.getName().equals((i - tableClean) + "m" + (j + tableClean))) {
                countM++;
            }

            if (next.getName().equals((i + tableClean) + "m" + (j - tableClean))) {
                countM++;
            }

            if (next.getName().equals((i + tableClean) + "m" + (tableClean))) {
                countM++;
            }

            if (next.getName().equals((i + tableClean) + "m" + (j + tableClean))) {
                countM++;
            }
        }
        return countM;
    }

    static void next(JButton b) {
        int a = list.indexOf(b);
        list.remove(a+1);
        list.remove(a);
        list.remove(a-1);

        list.remove(a+21);
        list.remove(a+20);
        list.remove(a+19);

        list.remove(a-21);
        list.remove(a-20);
        list.remove(a-19);
//        for (int i = 0; i < 8; i++) {
//            if (i < 3) {
//               getNext(a,1);
//            }
//            if (i>2 && i <6){
//                getNext(a,21);
//            }
//            if (i>5){
//
//            }
//        }
    }
    static void getNext(int btn, int ln){
        list.get(btn+ln).setVisible(false);
        list.get(btn).setVisible(false);
        list.get(btn-ln).setVisible(false);
    }
    static void test(JButton j){
        while (j.getName().equals("m")){

        }
    }
}
