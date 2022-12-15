package guistudy;

import javax.swing.*;

public class Clean extends TestFrame{
    JButton bNext;
    JButton bBack;

    JButton UbNext;
    JButton Ub;
    JButton UbBack;

    JButton DbNext;
    JButton Db;
    JButton DbBack;

    public Clean(JButton bNext, JButton bBack, JButton ubNext, JButton ub, JButton ubBack, JButton dbNext, JButton db, JButton dbBack) {
        this.bNext = bNext;
        this.bBack = bBack;
        UbNext = ubNext;
        Ub = ub;
        UbBack = ubBack;
        DbNext = dbNext;
        Db = db;
        DbBack = dbBack;
    }
}
