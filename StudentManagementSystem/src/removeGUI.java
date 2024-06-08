
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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