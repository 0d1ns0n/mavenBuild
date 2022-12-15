package guistudy;

import javax.swing.*;

public class Brain extends Window {
    JButton next;
    boolean CleanUP1;
    boolean CleanUP2;
    boolean CleanUP3;
    boolean Clean1;
    boolean Clean2;
    boolean Clean3;
    boolean CleanDown1;
    boolean CleanDown2;
    boolean CleanDown3;
    int countM = 0;


    public Brain(int countM) {
        if (CleanUP1) {
            countM++;
        }
        if (CleanUP2) {
            countM++;
        }
        if (CleanUP3) {
            countM++;
        }
        if (Clean1) {
            countM++;
        }
        if (Clean2) {
            countM++;
        }
        if (Clean3) {
            countM++;
        }
        if (CleanDown1) {
            countM++;
        }
        if (CleanDown2) {
            countM++;
        }
        if (CleanDown3) {
            countM++;
        }
        this.countM = countM;
    }

    public Brain(boolean cleanUP1, boolean cleanUP2, boolean cleanUP3, boolean clean1, boolean clean2, boolean clean3, boolean cleanDown1, boolean cleanDown2, boolean cleanDown3) {

//        for (int i = 0; i < list.size(); i++) {
//            for (JButton b : list) {
//               cleanUP1 = b.getName().equals("m" + (i-21));
//               cleanUP2 = b.getName().equals("m" + i);
//               cleanUP3 = b.getName().equals("m" + (i-19));
//
//                clean1 = b.getName().equals("m" + (i+1));
//                clean2 = b.getName().equals("m" + i);
//                clean3 = b.getName().equals("m" + (i-1));
//
//                cleanDown1 = b.getName().equals("m" + (i+21));
//                cleanDown2 = b.getName().equals("m" + i);
//                cleanDown3 = b.getName().equals("m" + (i+19));
//            }
//        }
        for (JButton b : list) {
//            cleanUP1
//                    cleanUP2
//            cleanUP3
//
//                    clean1
//            clean2 = b.getName().equals("m")
//                    clean3
//            cleanDown1
//                    cleanDown2
//            cleanDown2
        }

        this.CleanUP1 = cleanUP1;
        this.CleanUP2 = cleanUP2;
        this.CleanUP3 = cleanUP3;


        this.Clean1 = clean1;
        this.Clean2 = clean2;
        this.Clean3 = clean3;


        this.CleanDown1 = cleanDown1;
        this.CleanDown2 = cleanDown2;
        this.CleanDown3 = cleanDown3;
    }
}
