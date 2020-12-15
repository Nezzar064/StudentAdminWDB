package studAdmin;

import java.sql.*;
import java.util.ArrayList;

public class DBFetcher {

    private Connection con = DriverManager.getConnection("jdbc:mysql://localhost/studentAdministration?serverTimezone=UTC", "root", "sTrongPW64");

    public DBFetcher() throws SQLException {
    }

    public ArrayList<Student> allStudents() throws SQLException {
        Statement stm;
        stm = con.createStatement();
        String sql = "Select * From students";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<Student> students = new ArrayList<>();
        while (rst.next()) {
            Student student = new Student(rst.getInt("id"), rst.getString("name"), rst.getString("birthdate"), rst.getString("birthyear"), rst.getString("address"), rst.getString("phone"), rst.getString("program"));
            students.add(student);
        }
        return students;
    }

    public ArrayList<Student> nameAndId() throws SQLException {
        Statement stm;
        stm = con.createStatement();
        String sql = "Select name, id From students";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<Student> nameAndId = new ArrayList<>();
        while (rst.next()) {
            Student student = new Student(rst.getInt("id"), rst.getString("name"));
            nameAndId.add(student);
        }
        return nameAndId;
    }

    public ArrayList<Student> programs() throws SQLException {
        Statement stm;
        stm = con.createStatement();
        String sql = "Select program From students";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<Student> programs = new ArrayList<>();
        while (rst.next()) {
            Student student = new Student(rst.getString("program"));
            programs.add(student);
        }
        return programs;
    }
}
