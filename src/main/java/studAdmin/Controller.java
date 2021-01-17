package studAdmin;

import java.util.List;

public class Controller {

    StudentDAO studentDAO = new StudentDAO();
    StudentMapper mapper = new StudentMapper();

    public Controller() {
    }

    public void add(String name, String birthDate, String birthYear, String address, String phone, String program) {
        StudentDB student = new StudentDB();
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
        List<StudentDB> students = studentDAO.getAll();
        return mapper.mapListFromDatabaseList(students);
    }

    public List<String> studDbCounter() {
        return studentDAO.studDbCounter();
    }

    public void changeName(Student student, String name) {
        student.setName(name);
        StudentDB databaseStudent = mapper.mapToDatabaseObject(student);
        studentDAO.save(databaseStudent);
    }

    public void changeDOB(Student student, String birthDate) {
        student.setBirthDate(birthDate);
        StudentDB databaseStudent = mapper.mapToDatabaseObject(student);
        studentDAO.save(databaseStudent);
    }

    public void changeBirthYear(Student student, String birthYear) {
        student.setBirthYear(birthYear);
        StudentDB databaseStudent = mapper.mapToDatabaseObject(student);
        studentDAO.save(databaseStudent);
    }

    public void changeAddress(Student student, String address) {
        student.setAddress(address);
        StudentDB databaseStudent = mapper.mapToDatabaseObject(student);
        studentDAO.save(databaseStudent);
    }

    public void changePhoneNumber(Student student, String phone) {
        student.setPhone(phone);
        StudentDB databaseStudent = mapper.mapToDatabaseObject(student);
        studentDAO.save(databaseStudent);
    }

    public void changeProgram(Student student, String program) {
        student.setProgram(program);
        StudentDB databaseStudent = mapper.mapToDatabaseObject(student);
        studentDAO.save(databaseStudent);
    }


}
