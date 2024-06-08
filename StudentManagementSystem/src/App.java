
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
class removeGUI extends JFrame{
    JTextField Admno;
    JButton b;
    JLabel msg;
    removeGUI(StudentManagementSystem dao){
        Admno = new JTextField("Enter the admission number of the student to be removed");
        b = new JButton("Remove");
        msg = new JLabel("Student removed successfully");
        
        add(Admno);
        add(b);
        b.addActionListener(l->{
            int n = Integer.parseInt(Admno.getText());
            dao.removeStudent(n);
            remove(Admno);
            remove(b);
            add(msg);
        });

        setVisible(true);
        setSize(500,400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(3);
    }
}
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
class GUI extends JFrame{
    JButton add,search,remove,edit;
    GUI(){
        add = new JButton("          Add a new Student         ");
        search = new JButton("           Search a student           ");
        remove = new JButton("           Remove a student         ");
        edit = new JButton("  Edit a student's information  ");
        
        add(add);
        add(search);
        add(remove);
        add(edit);
       
        StudentManagementSystem dao = new StudentManagementSystem();
        add.addActionListener(l->{
            new addGUI(dao);
            dispose();
        });
        search.addActionListener(l->{
            new searchGUI(dao);
            dispose();
        });
        remove.addActionListener(l->{
            new removeGUI(dao);
            dispose();
        });
        edit.addActionListener(l->{
            new editGUI(dao);
            dispose();
        });
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(300,200);
        setDefaultCloseOperation(3);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        GUI gui = new GUI();
    }
}
