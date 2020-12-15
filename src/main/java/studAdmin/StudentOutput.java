package studAdmin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class StudentOutput {
    private int i;
    private String program;

    public StudentOutput() {
    }

    public void listAllStudents(List<Student> students) {
        if (!students.isEmpty()) {
            CW.newLine();
            CW.print("*Student information*");
            CW.newLine();
            students.forEach(System.out::println);
        } else {
            CW.newLine();
            CW.print(CW.noStudentsRegisteredMsg());
        }
    }

    public void listNameAndId(List<Student> students) {
        if (!students.isEmpty()) {
            CW.newLine();
            CW.print("*Student names and IDs" + "*");
            CW.newLine();
            for (int i = 0; i < students.size(); i++) {
                CW.print("ID: " + students.get(i).getId() + ", " + students.get(i).getName());
            }
            CW.newLine();
        } else {
            CW.print(CW.noStudentsRegisteredMsg());
        }
    }

    public void listStudentInfoByID(List<Student> students) {
        if (!students.isEmpty()) {
            try {
                CW.newLine();
                CW.print("Please enter the students ID ");
                int id = UserInput.intIn();
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getId() == id) {
                        CW.newLine();
                        CW.print("*Student information*");
                        CW.newLine();
                        outputStudents(students);
                        break;
                    }
                }
                if (students.get(i).getId() != id) {
                    CW.print(CW.noIntInRegisteredForStudentsMsg(id));
                }
                CW.newLine();
            } catch (InputMismatchException e) {
                CW.newLine();
                CW.print(CW.mismatchExceptionMsg());
                UserInput.intIn.next();
            }
        } else {
            CW.newLine();
            CW.print(CW.noStudentsRegisteredMsg());
        }
    }

    //TODO: Fix bug: prints if error message, even though program exists.
    public void findNumbStudentsByProgram(List<Student> students) {
        if (!students.isEmpty()) {
            int j = 0;
            CW.newLine();
            CW.print("Please specify student program: ");
            program = UserInput.strIn();
            CW.newLine();
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getProgram().equals(program)) {
                    j++;
                }
            }
            if (!students.get(i).getProgram().equals(program)) {
                CW.print(CW.noVarInRegisteredForStudentsMsg(program));
                CW.newLine();
            }
            CW.print("Number of students assigned to: " + program);
            CW.newLine();
            CW.print("*" + j + "*");
            CW.newLine();
        } else {
            CW.newLine();
            CW.print(CW.noStudentsRegisteredMsg());
        }
    }

    public void findStudentsByProgram(List<Student> students) { //TODO: sort by id?
        if (!students.isEmpty()) {
            CW.newLine();
            CW.print("Please specify student program: ");
            program = UserInput.strIn();
            CW.newLine();
            CW.print("*Students assigned to: " + program + "*");
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getProgram().equals(program)) {
                    CW.newLine();
                    CW.print("ID: " + students.get(i).getId() + ", " + students.get(i).getName());
                } else if (i == students.size()) {
                    CW.print(CW.noVarInRegisteredForStudentsMsg(program));
                }
            }
            if (!students.get(i).getProgram().equals(program)) {
                CW.print(CW.noVarInRegisteredForStudentsMsg(program));
            }
            CW.newLine();
        } else {
            CW.newLine();
            CW.print(CW.noStudentsRegisteredMsg());
        }
    }

    public void findStudentsByBirthYear(List<Student> students) { //TODO: Sort by birth year
        if (!students.isEmpty()) {
            CW.newLine();
            CW.print("Please specify student birth year: ");
            String birthYear = UserInput.strIn();
            CW.newLine();
            CW.print("*Students born in: " + birthYear + "*");
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getBirthYear().equals(birthYear)) {
                    CW.newLine();
                    CW.print("ID: " + students.get(i).getId() + ", " + students.get(i).getName());
                }
            }
            if (!students.get(i).getBirthYear().equals(birthYear)) {
                CW.print(CW.noVarInRegisteredForStudentsMsg(birthYear));
            }
            CW.newLine();
        } else {
            CW.newLine();
            CW.print(CW.noStudentsRegisteredMsg());
        }
    }

    public void getNumberOfStudents(List<String> counter) {
        CW.newLine();
        CW.print("Number of students registered in the system:");
        CW.newLine();
        CW.print("*" + counter + "*");
        CW.newLine();
    }

    private void outputStudents(List<Student> students) {
        CW.print("Name: " + students.get(i).getName());
        CW.print("Birthdate: " + students.get(i).getBirthDate());
        CW.print("Birth year: " + students.get(i).getBirthYear());
        CW.print("Address: " + students.get(i).getAddress());
        CW.print("Phone: " + students.get(i).getPhone());
        CW.print("Program: " + students.get(i).getProgram());
    }

    private Student createMember() {

        CW.print("Please enter the students name: ");
        String name = UserInput.in.nextLine();


        CW.print("Please enter the students date of birth: ");
        String birthDate = UserInput.in.nextLine();


        CW.print("Please enter the students birth year: ");
        String birthYear = UserInput.in.nextLine();

        CW.print("Please enter the students address: ");
        String address = UserInput.in.nextLine();

        CW.print("Please enter the students phone number: ");
        String phone = UserInput.in.nextLine();

        CW.print("Please enter the students program: ");
        String program = UserInput.in.nextLine();

        return new Student(name, birthDate, birthYear, address, phone, program);
    }
}
