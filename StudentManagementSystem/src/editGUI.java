import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class editScreen extends JFrame{
    JTextField name, rollno,Class,section,admno;
    JButton b;
    JLabel msg;
    editScreen(StudentManagementSystem dao,JTextField admno){
        name = new JTextField("Enter name of the student");
        rollno = new JTextField("Enter roll number of the student");
        Class = new JTextField("Enter class of the student");
        section = new JTextField("Enter section of the student");
        msg = new JLabel("Information updated successfully");
        b = new JButton("Update");

        add(name);
        add(rollno);
        add(Class);
        add(section);
        add(b);

        b.addActionListener(l->{
            dao.editStudent(name.getText(),Integer.parseInt(rollno.getText()),Integer.parseInt(Class.getText()),section.getText(),Integer.parseInt(admno.getText()));
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
class editGUI extends JFrame{
    JTextField admno;
    JButton b;
    editGUI(StudentManagementSystem dao){
        b= new JButton("Edit");  
        admno = new JTextField("Enter the admission number of the student");
        add(b);
        add(admno);
        b.addActionListener(l->{
            new editScreen(dao,admno);
            dispose();
        });
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(300,200);
        setDefaultCloseOperation(3);
    }
}