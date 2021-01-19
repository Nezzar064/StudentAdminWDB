package studAdmin;

import java.util.Arrays;
import java.util.InputMismatchException;

public class Menu {

    StudentOutput output = new StudentOutput();
    StudIdChecker studIdChecker = new StudIdChecker();
    Controller controller = new Controller();
    UserOutput userOutput = new UserOutput();
    VerifyPassword verify = new VerifyPassword();

    public void loginScreen() {
        /*
        Tester
        System.out.println(controller.getPassword("admin"));
        System.out.println(verify.getInputHashedPassword("admin", controller.getSalt("admin")));
         */
        Menu menu = new Menu();
        String welcomeMsg = "Welcome to the Student Administration System!";
        CW.newLine();
        String loginMsg = "Please enter your username and password!";

        CW.print(welcomeMsg);
        CW.print(loginMsg);
        CW.newLine();
        System.out.print("Username:");
        String username = UserInput.in.nextLine();
        System.out.print("Password:");
        String password = UserInput.in.nextLine();
        CW.newLine();
        verify.verifyPassword(menu, controller.getPassword(username), password, controller.getAdminStatus(username), controller.getSalt(username));
    }


    public void mainMenu() {
        boolean userContinue = true;
        while (userContinue) {
            mainMenuOptions();
            try {
                switch (UserInput.intIn.nextInt()) {
                    case 1:
                        CW.newLine();
                        setStudent();
                        CW.newLine();
                        CW.print("Student successfully added to the system!");
                        CW.newLine();
                        break;
                    case 2:
                        CW.newLine();
                        controller.deleteStudent(inputId());
                        CW.newLine();
                        CW.print(CW.deletedStudentMsg(inputId()));
                        CW.newLine();
                        break;
                    case 3:
                        CW.newLine();
                        Student foundStudent = studIdChecker.IdCheck(controller.getAllStudents());
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
                        output.getNumberOfStudents(controller.studDbCounter());
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

    private void setStudent() {
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

        controller.addStudent(name, birthDate, birthYear, address, phone, program);
    }

    public void infoChangeMenu(Student student) {
        boolean userContinue = true;
        while (userContinue) {
            infoChangeMenuOptions();
            switch (UserInput.intIn.nextInt()) {
                case 1:
                    CW.newLine();
                    CW.print("Please enter the new name: ");
                    String name = UserInput.in.nextLine();
                    controller.changeName(student, name);
                    successMsg(name);
                    break;
                case 2:
                    CW.newLine();
                    CW.print("Please enter the new date of birth: ");
                    String birthDate = UserInput.in.nextLine();
                    CW.newLine();
                    controller.changeDOB(student, birthDate);
                    successMsg(birthDate);
                    break;
                case 3:
                    CW.newLine();
                    CW.print("Please enter the new birth year: ");
                    String birthYear = UserInput.in.nextLine();
                    CW.newLine();
                    controller.changeBirthYear(student, birthYear);
                    successMsg(birthYear);
                    break;
                case 4:
                    CW.newLine();
                    CW.print("Please enter the new address: ");
                    String address = UserInput.in.nextLine();;
                    CW.newLine();
                    controller.changeAddress(student, address);
                    successMsg(address);
                    break;
                case 5:
                    CW.newLine();
                    CW.print("Please enter the new phone number: ");
                    String phone = UserInput.in.nextLine();
                    CW.newLine();
                    controller.changePhoneNumber(student, phone);
                    successMsg(phone);
                    break;
                case 6:
                    CW.newLine();
                    CW.print("Please enter the new program: ");
                    String program = UserInput.in.nextLine();
                    CW.newLine();
                    controller.changeProgram(student, program);
                    successMsg(program);
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

    private void successMsg(String var) {
        CW.newLine();
        CW.print(CW.infoChangeSuccessForVar(var));
        CW.newLine();
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
                        output.listAllStudents(controller.getAllStudents());
                        break;
                    case 2:
                        output.listNameAndId(controller.getAllStudents());
                        break;
                    case 3:
                        output.listStudentInfoByID(controller.getAllStudents());
                        break;
                    case 4:
                        output.findNumbStudentsByProgram(controller.getAllStudents());
                        break;
                    case 5:
                        output.findStudentsByProgram(controller.getAllStudents());
                        break;
                    case 6:
                        output.findStudentsByBirthYear(controller.getAllStudents());
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

    public void adminMenu() {
        boolean userContinue = true;
        while (userContinue) {
            adminMenuOptions();
            try {
                switch (UserInput.intIn.nextInt()) {
                    case 1:
                        CW.newLine();
                        setUser();
                        CW.newLine();
                        CW.print("User successfully added to the system!");
                        CW.newLine();
                        break;
                    case 2:
                        CW.newLine();
                        controller.deleteUser(inputUsername());
                        CW.newLine();
                        CW.print(CW.deletedUserMsg(inputUsername()));
                        CW.newLine();
                        break;
                    case 3:
                        userOutput.listAllUsers(controller.getAllUsers());
                        break;
                    case 4:
                        CW.newLine();
                        mainMenu();
                        break;
                    case 5:
                        CW.newLine();
                        CW.print(CW.exitSystemMsg());
                        CW.newLine();
                        userContinue = false;
                        System.exit(0);
                        break;
                    default:
                        CW.newLine();
                        CW.print(CW.defaultSwitchMsg());
                        CW.newLine();
                        adminMenu();
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

    private void adminMenuOptions() {
        CW.printMenu("Admin Menu",
                "Add user",
                "Delete user",
                "List users",
                "Enter secretary menu",
                "Exit to main menu"
                );
    }

    private String inputUsername() {
        CW.print("Please enter the users username");
        return UserInput.in.nextLine();
    }

    private void setUser() {
        CW.print("Please enter the username you want: ");
        String username = UserInput.in.nextLine();

        CW.print("Please enter your password: ");
        String password = UserInput.in.nextLine();

        CW.print("Admin status? (Y/N)");
        String adminStatus = UserInput.in.nextLine();

        controller.addUser(username, password, adminStatus);
    }
}
