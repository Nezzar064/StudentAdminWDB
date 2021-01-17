package studAdmin;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    public Student mapFromDatabaseObject(StudentDB studentDB) {
        Student student = new Student();
        student.setId(studentDB.getId());
        student.setName(studentDB.getName());
        student.setBirthDate(studentDB.getBirthDate());
        student.setBirthYear(studentDB.getBirthYear());
        student.setAddress(studentDB.getAddress());
        student.setPhone(studentDB.getPhone());
        student.setProgram(studentDB.getProgram());

        return student;
    }

    public StudentDB mapToDatabaseObject(Student student) {
        StudentDB studentDB = new StudentDB();
        studentDB.setId(student.getId());
        studentDB.setName(student.getName());
        studentDB.setBirthDate(student.getBirthDate());
        studentDB.setBirthYear(student.getBirthYear());
        studentDB.setAddress(student.getAddress());
        studentDB.setPhone(student.getPhone());
        studentDB.setProgram(student.getProgram());

        return studentDB;
    }

    public List<Student> mapListFromDatabaseList(List<StudentDB> students) {
        List<Student> studentList = new ArrayList<>();
        students.forEach(student -> studentList.add(mapFromDatabaseObject(student)));
        return studentList;
    }

    public List<StudentDB> mapListToDatabaseList(List<Student> students) {
        List<StudentDB> studentList = new ArrayList<>();
        students.forEach(newStudent -> studentList.add(mapToDatabaseObject(newStudent)));
        return studentList;
    }
}
