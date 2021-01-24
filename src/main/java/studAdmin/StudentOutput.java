package studAdmin;

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
        int i;
        boolean matchStudent = false;
        if (!students.isEmpty()) {
            try {
                CW.newLine();
                CW.print("Please enter the students ID ");
                int id = UserInput.intIn();
                for (i = 0; i < students.size(); i++) {
                    if (students.get(i).getId() == id) {
                        CW.newLine();
                        CW.print("*Student information*");
                        CW.newLine();
                        outputStudents(students, i);
                        matchStudent = true;
                        break;
                    }
                }
                if (!matchStudent) {
                    CW.newLine();
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

    //fix
    public void findNumbStudentsByProgram(List<Student> students) {
        int i;
        boolean matchStudent = false;
        if (!students.isEmpty()) {
            int j = 0;
            CW.newLine();
            CW.print("Please specify student program: ");
            program = UserInput.in.nextLine();
            CW.newLine();
            for (i = 0; i < students.size(); i++) {
                if (students.get(i).getProgram().equals(program)) {
                    j++;
                    matchStudent = true;
                }
            }
            if (matchStudent) {
                CW.print("Number of students assigned to: " + program);
                CW.newLine();
                CW.print("*" + j + "*");
                CW.newLine();
            }
            if (!matchStudent) {
                CW.print(CW.noVarInRegisteredForStudentsMsg(program));
                CW.newLine();
            }
        } else {
            CW.newLine();
            CW.print(CW.noStudentsRegisteredMsg());
        }
    }

    public void findStudentsByProgram(List<Student> students) { //TODO: sort by id?
        int i;
        boolean matchStudent = false;
        if (!students.isEmpty()) {
            CW.newLine();
            CW.print("Please specify student program: ");
            program = UserInput.in.nextLine();
            CW.newLine();
            CW.print("*Students assigned to: " + program + "*");
            CW.newLine();
            for (i = 0; i < students.size(); i++) {
                if (students.get(i).getProgram().equals(program)) {
                    CW.print("ID: " + students.get(i).getId() + ", " + students.get(i).getName());
                    matchStudent = true;
                }
            }
            if (!matchStudent) {
                CW.newLine();
                CW.print(CW.noVarInRegisteredForStudentsMsg(program));
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

    private void outputStudents(List<Student> students, int i) {
        CW.print("Name: " + students.get(i).getName());
        CW.print("Birthdate: " + students.get(i).getBirthDate());
        CW.print("Address: " + students.get(i).getAddress());
        CW.print("Phone: " + students.get(i).getPhone());
        CW.print("Program: " + students.get(i).getProgram());
    }
}
