import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


class addGUI extends JFrame{
    JTextField name, rollno,Class,section,admno;
    JButton b;
    JLabel msg;
    addGUI(StudentManagementSystem dao){
        name = new JTextField("Enter name of the student");
        rollno = new JTextField("Enter roll number of the student");
        Class = new JTextField("Enter class of the student");
        section = new JTextField("Enter section of the student");
        admno = new JTextField("Enter the admission number of the student");
        msg = new JLabel("Student added successfully");
        b = new JButton("Add");

        add(name);
        add(rollno);
        add(Class);
        add(section);
        add(admno);
        add(b);

        b.addActionListener(l->{
            dao.addStudent(name.getText(),Integer.parseInt(rollno.getText()),Integer.parseInt(Class.getText()),section.getText(),Integer.parseInt(admno.getText()));
            remove(name);
            remove(rollno);
            remove(Class);
            remove(section);
            remove(admno);
            remove(b);
            add(msg);
        });

        setVisible(true);
        setSize(300,500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);
    }
}