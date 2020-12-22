package studAdmin;

import java.util.List;

public class Controller {

    StudentDAO studentDAO = new StudentDAO();

    public void add(String name, String blaba) {
        Student student = new Student();
        student.setName(name);
        studentDAO.add(student);
    }

    public List<Student> getAll() {
        return studentDAO.getAll();
    }
}
