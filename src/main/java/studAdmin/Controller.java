package studAdmin;

import java.util.List;

public class Controller {

    StudentDAO studentDAO = new StudentDAO();
    StudentMapper mapper = new StudentMapper();
    UserDAO userDAO = new UserDAO();
    EncryptPassword encryptPassword = new EncryptPassword();
    UserMapper userMapper = new UserMapper();
    YesNoBooleanConverter converter = new YesNoBooleanConverter();

    public Controller() {
    }

    public void addStudent(String name, String birthDate, String birthYear, String address, String phone, String program) {
        StudentDB student = new StudentDB();
        student.setName(name);
        student.setBirthDate(birthDate);
        student.setBirthYear(birthYear);
        student.setAddress(address);
        student.setPhone(phone);
        student.setProgram(program);
        studentDAO.add(student);
    }

    public void deleteStudent(int id) {
        studentDAO.delete(id);
    }

    public List<Student> getAllStudents() {
        List<StudentDB> students = studentDAO.getAll();
        return mapper.mapListFromDatabaseList(students);
    }

    public List<String> studDbCounter() {
        return studentDAO.studDbCounter();
    }

    public void addUser(String username, String password, String adminStatus) {
        UserDB user = new UserDB();

        byte[] encryptPW = encryptPassword.encrypt(password);
        String hashedPassToStoreInDB = new String(encryptPW);
        boolean convertedAdminStatus = converter.convertToEntityAttribute(adminStatus);

        user.setUsername(username);
        user.setPassword(hashedPassToStoreInDB);
        user.setHasAdminStatus(convertedAdminStatus);
        userDAO.add(user);
    }

    public void delete(String username) {
        userDAO.delete(username);
    }

    public List<UserDB> getAllUsers() {
        return userDAO.getAll();
    }

    public String getPassword(String username) {
        return userDAO.getPasswordForInputtedUsername(username);
    }

    public boolean getAdminStatus(String username) {
        return userDAO.getAdminStatusForInputtedUsername(username);
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
