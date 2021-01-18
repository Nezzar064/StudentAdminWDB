package studAdmin;

import java.util.List;

public class Controller {

    StudentDAO studentDAO = new StudentDAO();
    StudentMapper mapper = new StudentMapper();
    UserDAO userDAO = new UserDAO();
    EncryptPassword encryptPassword = new EncryptPassword();

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

    public void addUser(String username, String password) {
        Users user = new Users();
        byte[] encryptPW = encryptPassword.encrypt(password);
        user.setUsername(username);
        user.setPassword(encryptPW);
        userDAO.add(user);
    }

    public List<Users> getUsers() {
        List<Users> users = userDAO.getAll();
        return users;
    }

    public byte[] getPassword() {

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
