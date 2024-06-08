
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class searchGUI extends JFrame{
    JTextField Admno;
    JLabel NAME,ROLLNO,CLASS,SECION,ADMNO;
    JButton b;
    searchGUI(StudentManagementSystem dao){
        Admno = new JTextField("Enter the Admission number of student");

        NAME = new JLabel("Name: ");
        ROLLNO = new JLabel("Roll Number: ");
        CLASS = new JLabel("Class: ");
        SECION = new JLabel("Section: ");
        ADMNO = new JLabel("Admission Number: ");

        b = new JButton("Search");

        add(Admno);
        add(b);

        b.addActionListener(l->{
            int n = Integer.parseInt(Admno.getText());
            Student s = dao.searchStudent(n);
            remove(Admno);
            remove(b);
            NAME.setText(NAME.getText()+s.name);
            ROLLNO.setText(ROLLNO.getText()+s.Rollno);
            CLASS.setText(CLASS.getText()+s.Class);
            SECION.setText(SECION.getText()+s.section);
            ADMNO.setText(ADMNO.getText()+s.admnNo);
            add(NAME);
            add(ROLLNO);
            add(CLASS);
            add(SECION);
            add(ADMNO);
        });

        setVisible(true);
        setSize(300,400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);
    }
}