

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


class UserInterface extends JFrame{
    JLabel H, COL, ELL, PYL, MTL,PYP,ELP,mCOL,mELL,mPYL, mMTL, mPYP, mELP;
    JTextField col, ell, pyl,mtl,pyp,elp;
    JButton b;
    public UserInterface(){
        H = new JLabel("Enter Your Marks Below(Out of 100 and for PYP out of 170):");
        COL = new JLabel("COL101");
        ELL = new JLabel("ELL101");
        PYL = new JLabel("PYL101");
        MTL = new JLabel("MTL101");
        PYP = new JLabel("PYP100");
        ELP = new JLabel("ELP100");
        col = new JTextField(30);
        ell = new JTextField(30);
        pyl = new JTextField(30);
        mtl = new JTextField(30);
        pyp = new JTextField(30);
        elp = new JTextField(30);
        b = new JButton("             Calculate            ");

        mCOL = new JLabel("        COL101:                                         ");
        mELL = new JLabel("ELL101:                                         ");
        mPYL = new JLabel("PYL101:                                         ");
        mMTL = new JLabel("MTL101:                                         ");
        mPYP = new JLabel("PYP100:                                         ");
        mELP = new JLabel("ELP100:                                         ");
        add(H);
        add(col);
        add(COL);
        add(ell);
        add(ELL);
        add(pyl);
        add(PYL);
        add(mtl);
        add(MTL);
        add(pyp);
        add(PYP);
        add(elp);
        add(ELP);
        add(b);

        b.addActionListener(l->{
            int colMarks = Integer.parseInt(col.getText());
            int ellMarks = Integer.parseInt(ell.getText());
            int pylMarks = Integer.parseInt(pyl.getText());
            int mtlMarks = Integer.parseInt(mtl.getText());
            int pypMarks = Integer.parseInt(pyp.getText());
            int elpMarks = Integer.parseInt(elp.getText());

            colGrade(colMarks);
            ellGrade(ellMarks);
            pylGrade(pylMarks);
            mtlGrade(mtlMarks);
            pypGrade(pypMarks);
            elpGrade(elpMarks);

            add(mCOL);
            add(mELL);
            add(mPYL);
            add(mMTL);
            add(mPYP);
            add(mELP);
        });

        setVisible(true);
        setLayout(new FlowLayout());
        setSize(400,600);
        setDefaultCloseOperation(3);
    }
    public void colGrade(int marks){
        if(marks>=80) mCOL.setText(mCOL.getText()+"A");
        else if(marks<80 && marks>=70) mCOL.setText(mCOL.getText()+"A-");
        else if(marks<70 && marks>=60) mCOL.setText(mCOL.getText()+"B");
        else if(marks<60 && marks>=50) mCOL.setText(mCOL.getText()+"B-");
        else if(marks<50 && marks>=40) mCOL.setText(mCOL.getText()+"C");
        else if(marks<40 && marks>=30) mCOL.setText(mCOL.getText()+"D");
        else if(marks<30 && marks>=20) mCOL.setText(mCOL.getText()+"E");
        else mCOL.setText(mCOL.getText()+"F");
    }
    public void ellGrade(int marks){
        if(marks>=70) mELL.setText(mELL.getText()+"A");
        else if(marks<70 && marks>=60) mELL.setText(mELL.getText()+"A-");
        else if(marks<60 && marks>=50) mELL.setText(mELL.getText()+"B");
        else if(marks<50 && marks>=43) mELL.setText(mELL.getText()+"B-");
        else if(marks<43 && marks>=40) mELL.setText(mELL.getText()+"C");
        else if(marks<40 && marks>=35) mELL.setText(mELL.getText()+"D");
        else if(marks<35 && marks>=30) mELL.setText(mELL.getText()+"E");
        else mELL.setText(mELL.getText()+"F");
    }
    public void pylGrade(int marks){
        if(marks>=80) mPYL.setText(mPYL.getText()+"A");
        else if(marks<80 && marks>=70) mPYL.setText(mPYL.getText()+"A-");
        else if(marks<70 && marks>=60) mPYL.setText(mPYL.getText()+"B");
        else if(marks<60 && marks>=50) mPYL.setText(mPYL.getText()+"B-");
        else if(marks<50 && marks>=40) mPYL.setText(mPYL.getText()+"C");
        else if(marks<40 && marks>=30) mPYL.setText(mPYL.getText()+"D");
        else if(marks<30 && marks>=20) mPYL.setText(mPYL.getText()+"E");
        else mPYL.setText(mPYL.getText()+"F");
    }
    public void mtlGrade(int marks){
        if(marks>=80) mMTL.setText(mMTL.getText()+"A");
        else if(marks<80 && marks>=70) mMTL.setText(mMTL.getText()+"A-");
        else if(marks<70 && marks>=60) mMTL.setText(mMTL.getText()+"B");
        else if(marks<60 && marks>=50) mMTL.setText(mMTL.getText()+"B-");
        else if(marks<50 && marks>=40) mMTL.setText(mMTL.getText()+"C");
        else if(marks<40 && marks>=30) mMTL.setText(mMTL.getText()+"D");
        else if(marks<30 && marks>=20) mMTL.setText(mMTL.getText()+"E");
        else mMTL.setText(mMTL.getText()+"F");
    }
    public void pypGrade(int marks){
        if(marks>=153) mPYP.setText(mPYP.getText()+"A");
        else if(marks<153 && marks>=143) mPYP.setText(mPYP.getText()+"A-");
        else if(marks<143 && marks>=135) mPYP.setText(mPYP.getText()+"B");
        else if(marks<135 && marks>=125) mPYP.setText(mPYP.getText()+"B-");
        else if(marks<125 && marks>=115) mPYP.setText(mPYP.getText()+"C");
        else if(marks<115 && marks>=105) mPYP.setText(mPYP.getText()+"D");
        else if(marks<105 && marks>=100) mPYP.setText(mPYP.getText()+"E");
        else mPYP.setText(mPYP.getText()+"F");
    }
    public void elpGrade(int marks){
        if(marks>=96) mELP.setText(mELP.getText()+"A");
        else if(marks<96 && marks>=90) mELP.setText(mELP.getText()+"A-");
        else if(marks<90 && marks>=85) mELP.setText(mELP.getText()+"B");
        else if(marks<85 && marks>=80) mELP.setText(mELP.getText()+"B-");
        else if(marks<80 && marks>=70) mELP.setText(mELP.getText()+"C");
        else if(marks<70 && marks>=60) mELP.setText(mELP.getText()+"D");
        else if(marks<60 && marks>=50) mELP.setText(mELP.getText()+"E");
        else mELP.setText(mELP.getText()+"F");
    }
}

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
    }
}
