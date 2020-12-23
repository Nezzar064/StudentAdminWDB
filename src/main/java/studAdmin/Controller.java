package studAdmin;

import java.util.List;

public class Controller {

    StudentDAO studentDAO = new StudentDAO();

    public Controller() {
    }

    public void add(String name, String birthDate, String birthYear, String address, String phone, String program) {
        Student student = new Student();
        student.setName(name);
        student.setBirthDate(birthDate);
        student.setBirthYear(birthYear);
        student.setAddress(address);
        student.setPhone(phone);
        student.setProgram(program);
        studentDAO.add(student);
    }

    public void delete(int id) {
        studentDAO.delete(id);
    }

    public List<Student> getAll() {
        return studentDAO.getAll();
    }

    public List<String> studDbCounter() {
        return studentDAO.studDbCounter();
    }

    public void changeName(Student student, String name) {
        student.setName(name);
        studentDAO.save(student);
    }

    public void changeDOB(Student student, String birthDate) {
        student.setBirthDate(birthDate);
        studentDAO.save(student);
    }

    public void changeBirthYear(Student student, String birthYear) {
        student.setBirthYear(birthYear);
        studentDAO.save(student);
    }

    public void changeAddress(Student student, String address) {
        student.setAddress(address);
        studentDAO.save(student);
    }

    public void changePhoneNumber(Student student, String phone) {
        student.setPhone(phone);
        studentDAO.save(student);
    }

    public void changeProgram(Student student, String program) {
        student.setProgram(program);
        studentDAO.save(student);;
    }


}
