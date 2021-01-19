package studAdmin;

public class VerifyPassword {

    EncryptPassword encryptPassword = new EncryptPassword();

    public void verifyPassword(Menu menu, String dbPassword, String inputPassword, boolean adminStatus, byte[] salt) {
        if (dbPassword.equals(getInputHashedPassword(inputPassword, salt)) && adminStatus) {
            CW.print("Access granted!");
            CW.newLine();
            menu.adminMenu();
        }
        if (dbPassword.equals(getInputHashedPassword(inputPassword, salt)) && !adminStatus) {
            CW.print("Access granted!");
            CW.newLine();
            menu.mainMenu();
        }
        else {
            CW.print("ERROR: Invalid password, please try again");
            menu.loginScreen();
        }
    }

    public String getInputHashedPassword(String password, byte[] salt) {
        byte[] hashedInputPass = encryptPassword.encrypt(password, salt);
        return new String(hashedInputPass);
    }
}
