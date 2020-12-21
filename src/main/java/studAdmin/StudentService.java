package studAdmin;

import java.sql.SQLException;

public class StudentService {

    //update after the user is finished changing shit (not now)
    StudentDAO studentDAO = new StudentDAO();

    public StudentService() {
    }

    public void changeName(Student student) {
        String name;
        CW.print("Please enter the new name: ");
        name = UserInput.strIn();
        student.setName(name);
        studentDAO.save(student);
        CW.newLine();
        CW.print(CW.infoChangeSuccessForVar(name));
        CW.newLine();
    }

    public void changeDOB(Student student) {
        String birthDate;
        CW.print("Please enter the new date of birth: ");
        birthDate = UserInput.strIn();
        student.setBirthDate(birthDate);
        studentDAO.save(student);
        CW.newLine();
        CW.print(CW.infoChangeSuccessForVar(birthDate));
        CW.newLine();
    }

    public void changeBirthYear(Student student) {
        String birthYear;
        CW.print("Please enter the new birth year: ");
        birthYear = UserInput.strIn();
        student.setBirthYear(birthYear);
        studentDAO.save(student);
        CW.newLine();
        CW.print(CW.infoChangeSuccessForVar(birthYear));
        CW.newLine();
    }

    public void changeAddress(Student student) {
        String address;
        CW.print("Please enter the new address: ");
        address = UserInput.strIn();
        student.setAddress(address);
        studentDAO.save(student);
        CW.newLine();
        CW.print(CW.infoChangeSuccessForVar(address));
        CW.newLine();
    }

    public void changePhoneNumber(Student student) {
        String phone;
        CW.print("Please enter the new phone number: ");
        phone = UserInput.strIn();
        student.setPhone(phone);
        studentDAO.save(student);
        CW.newLine();
        CW.print(CW.infoChangeSuccessForVar(phone));
        CW.newLine();
    }

    public void changeProgram(Student student) {
        String program;
        CW.newLine();
        CW.print("Please enter the new program: ");
        program = UserInput.strIn();
        student.setProgram(program);
        studentDAO.save(student);;
        CW.newLine();
        CW.print(CW.infoChangeSuccessForVar(program));
        CW.newLine();
    }

}
