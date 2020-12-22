package studAdmin;

import java.util.InputMismatchException;

//TODO for Pete
/*
StudentService.java:
My idea is to seperate this:

student.setBirthYear(birthYear);
        studentDAO.save(student);

for example, so the input stuff maybe goes to its own class, instead of it being handled in the same function. id like the front end out of it, eg all the CW.print(xxx),
so its only backend work in the methods. Or maybe keep the variable assignments and just move out the front end CW stuff? idk if this is the right way or not.

Menu.java:

method setStudent should be moved to the service class instead, but it contains both front end and backend, eg the messages with prompts (what we talked about), where do i move this?
Can i just get the variables from a method, then do return new Student(variables), or will that not work with the database since i do setName(name) for each variable?

 */


public class Menu {
    StudentService service = new StudentService();
    StudentOutput output = new StudentOutput();
    StudIdChecker studIdChecker = new StudIdChecker();
    StudentDAO studentDAO = new StudentDAO();

    public void mainMenu() {
        boolean userContinue = true;
        while (userContinue) {
            mainMenuOptions();
            try {
                switch (UserInput.intIn.nextInt()) {
                    case 1:
                        CW.newLine();
                        studentDAO.add(setStudent());
                        CW.newLine();
                        CW.print("Student successfully added to the system!");
                        CW.newLine();
                        //studEditor.addStudent(students, programs);
                        break;
                    case 2:
                        CW.newLine();
                        studentDAO.delete(inputId());
                        //studEditor.deleteStudent(students);
                        break;
                    case 3:
                        CW.newLine();
                        Student foundStudent = studIdChecker.IdCheck(studentDAO.getAll());
                        if (foundStudent != null) {
                            CW.newLine();
                            infoChangeMenu(foundStudent);
                        } else {
                            mainMenu();
                        }
                        break;
                    case 4:
                        CW.newLine();
                        studentListMenu();
                        break;
                    case 5:
                        output.getNumberOfStudents(studentDAO.studDbCounter());
                        break;
                    case 6:
                        CW.newLine();
                        CW.print(CW.exitSystemMsg());
                        userContinue = false;
                        System.exit(0);
                        break;
                    default:
                        CW.newLine();
                        CW.print(CW.defaultSwitchMsg());
                        CW.newLine();
                        mainMenu();
                        break;
                }
            } catch (InputMismatchException e) {
                CW.newLine();
                CW.print(CW.mismatchExceptionMsg());
                UserInput.intIn.next();
                CW.newLine();
                mainMenu();
            }
        }
    }

    private void mainMenuOptions() {
        CW.printMenu(
                "Main menu",
                "Add a student to the system",
                "Delete a student from the system",
                "Change student info",
                "List menu",
                "Total number of students in system",
                "Exit system"
        );
    }

    private int inputId() {
        CW.print("Please enter the students ID");
        return UserInput.intIn.nextInt();
    }

    private Student setStudent() {
        Student stud = new Student();
        CW.print("Please enter the students name: ");
        stud.setName(UserInput.in.nextLine());

        CW.print("Please enter the students date of birth: ");
        stud.setBirthDate(UserInput.in.nextLine());

        CW.print("Please enter the students birth year: ");
        stud.setBirthYear(UserInput.in.nextLine());

        CW.print("Please enter the students address: ");
        stud.setAddress(UserInput.in.nextLine());

        CW.print("Please enter the students phone number: ");
        stud.setPhone(UserInput.in.nextLine());

        CW.print("Please enter the students program: ");
        stud.setProgram(UserInput.in.nextLine());

        return stud;
    }

    public void infoChangeMenu(Student student) {
        boolean userContinue = true;
        while (userContinue) {
            infoChangeMenuOptions();
            switch (UserInput.intIn.nextInt()) {
                case 1:
                    CW.newLine();
                    service.changeName(student);
                    break;
                case 2:
                    CW.newLine();
                    service.changeDOB(student);
                    break;
                case 3:
                    CW.newLine();
                    service.changeBirthYear(student);
                    break;
                case 4:
                    CW.newLine();
                    service.changeAddress(student);
                    break;
                case 5:
                    CW.newLine();
                    service.changePhoneNumber(student);
                    break;
                case 6:
                    CW.newLine();
                    service.changeProgram(student);
                    break;
                case 7:
                    CW.newLine();
                    CW.print(CW.exitToMainMenuMsg());
                    CW.newLine();
                    userContinue = false;
                    mainMenu();
                    break;
                default:
                    CW.newLine();
                    CW.print(CW.defaultSwitchMsg());
                    CW.newLine();
                    infoChangeMenu(student);
            }
        }
    }

    private void infoChangeMenuOptions() {
        CW.printMenu(
                "Student Information change",
                "Change student name",
                "Change student date of birth",
                "Change student birth year",
                "Change student address",
                "Change student phone number",
                "Change student program",
                "Exit to main menu"
        );
    }

    public void studentListMenu() {
        boolean userContinue = true;
        while (userContinue) {
            studentListMenuOptions();
            try {
                switch (UserInput.intIn.nextInt()) {
                    case 1:
                        output.listAllStudents(studentDAO.getAll());
                        break;
                    case 2:
                        output.listNameAndId(studentDAO.getAll());
                        break;
                    case 3:
                        output.listStudentInfoByID(studentDAO.getAll());
                        break;
                    case 4:
                        output.findNumbStudentsByProgram(studentDAO.getAll());
                        break;
                    case 5:
                        output.findStudentsByProgram(studentDAO.getAll());
                        break;
                    case 6:
                        output.findStudentsByBirthYear(studentDAO.getAll());
                        break;
                    case 7:
                        CW.newLine();
                        CW.print(CW.exitToMainMenuMsg());
                        CW.newLine();
                        userContinue = false;
                        mainMenu();
                        break;
                    default:
                        CW.newLine();
                        CW.print(CW.defaultSwitchMsg());
                        CW.newLine();
                        studentListMenu();
                        break;
                }
            } catch (InputMismatchException e) {
                CW.newLine();
                CW.print(CW.mismatchExceptionMsg());
                CW.newLine();
                UserInput.intIn.next();
            }
        }
    }

    private void studentListMenuOptions() {
        CW.printMenu(
                "Student List",
                "List all student information",
                "List all students name and ID",
                "List student info by specified ID",
                "List number of students by specified program",
                "List student name and ID by specified program",
                "List student name and ID by specified birth year",
                "Exit to main menu"
        );
    }
}
