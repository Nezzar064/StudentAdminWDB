package studAdmin;

import java.time.LocalDate;

public class CW {

    public static String menuBars() {
        return ("\n-----------------------------------------------------\n");
    }

    public static void newLine() {
        System.out.println();
    }

    public static String mismatchExceptionMsg() {
        return "Please enter the right input format!";
    }

    public static String defaultSwitchMsg() {
        return "Input format is not valid! Returning to menu";
    }

    public static String exitToMainMenuMsg() {
        return "Returning to main menu!";
    }

    public static String exitSystemMsg() {
        return "Exiting system, see you next time!";
    }

    public static String headline() {
        return "------------Student Administration System------------";
    }

    public static String noStudentsRegisteredMsg() {
        return "System has no students registered! Returning to menu";
    }

    public static String noUsersRegisteredMsg() {
        return "System has no users registered! Returning to menu";
    }

    public static String deletedUserMsg(String username) {
        return "User: " + username + " successfully deleted";
    }

    public static String successMsgForBirthDate(LocalDate date) {
        return ("Birthdate successfully changed to: " + date);
    }

    public static String deletedStudentMsg(int id) {
        return "Student " + id + " successfully deleted";
    }

    public static String noVarInRegisteredForStudentsMsg(String var) {
        return "System has no students assigned to \"" + var + "\"! Returning to menu";
    }

    public static String noIntInRegisteredForStudentsMsg(int id) {
        return "System has no students assigned to ID: (" + id + ")! Returning to menu";
    }

    public static String noProgramsRegistered() {
        return "System has no programs registered!";
    }

    public static String infoChangeSuccessForVar(String var) {
        return "Information successfully changed to: " + var;
    }

    public static void printMenu(String menuNameString, String... menuOptions) {
        System.out.println(headline());
        newLine();
        System.out.println("*" + menuNameString + "*");
        newLine();
        if (menuOptions.length > 0) {
            for (int i = 0; i < menuOptions.length; i++) {
                System.out.println(i + 1 + ". " + menuOptions[i]);
            }
        }
        System.out.println(menuBars());
    }

    public static void print(String text) {
        System.out.println(text);
    }

    public static void printInt(int integer) {
        System.out.println(integer);
    }
}
