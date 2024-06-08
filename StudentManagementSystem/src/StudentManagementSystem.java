
import java.sql.*;
class Student {
    String name;
    int Rollno;
    int Class;
    String section;
    int admnNo;
}
class StudentManagementSystem {
    static final String DB_URL = "jdbc:mysql://localhost:3306/school";
    static final String user = "root";
    static final String passwd = "&Z9x!q4Pm#K1$W8d";

    public StudentManagementSystem(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection conn = DriverManager.getConnection(DB_URL,user,passwd);
            Statement st = conn.createStatement())
            {
                String sql = "create table student(Name Varchar(30),Rollno int, Class int,Section char(2),Admission_Number integer)";
                st.executeUpdate(sql);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }  catch (SQLSyntaxErrorException e){
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void addStudent(String Name,int Rollno,int Class_,String section,int Admno){
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection conn = DriverManager.getConnection(DB_URL,user,passwd))
            {
                String sql = "insert into student values(?,?,?,?,?)";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1,Name);
                st.setInt(2,Rollno);
                st.setInt(3,Class_);
                st.setString(4, section);
                st.setInt(5,Admno);
                st.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Student searchStudent(int Admno){
        Student s = new Student();
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try(Connection conn = DriverManager.getConnection(DB_URL,user,passwd);
            Statement st = conn.createStatement())
            {
                String sql = "select * from student where Admission_Number="+Admno;
                rs = st.executeQuery(sql);
                rs.next();
                s.name = rs.getString("Name");
                s.Rollno= rs.getInt("Rollno");
                s.Class = rs.getInt("Class");
                s.section = rs.getString("Section");
                s.admnNo = rs.getInt("Admission_Number");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return s;
    }
    public void removeStudent(int admno){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection conn = DriverManager.getConnection(DB_URL,user,passwd);
            Statement st = conn.createStatement()){
                String sql = "delete from student where Admission_Number="+admno;
                st.executeUpdate(sql);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void editStudent(String Name,int Rollno,int Class_,String section,int Admno){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection conn = DriverManager.getConnection(DB_URL,user,passwd)){
                String sql = "update student set Name = ?,Rollno = ?,Class = ?,Section = ? where Admission_Number = ?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1,Name);
                st.setInt(2,Rollno);
                st.setInt(3,Class_);
                st.setString(4,section);
                st.setInt(5,Admno);
                st.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
