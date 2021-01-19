package studAdmin;

import org.apache.commons.codec.binary.Hex;

public class VerifyPassword {

    EncryptPassword encryptPassword = new EncryptPassword();

    public void verifyPassword(Menu menu, String dbPassword, String inputPassword, boolean adminStatus) {
        if (dbPassword.equals(getInputHashedPassword(inputPassword)) && adminStatus) {
            CW.print("Access granted!");
            menu.adminMenu();
        }
        if (dbPassword.equals(getInputHashedPassword(inputPassword)) && !adminStatus) {
            CW.print("Access granted!");
            menu.mainMenu();
        }
        else {
            CW.print("ERROR: Invalid password, please try again");
            menu.loginScreen();
        }
    }

    private String getInputHashedPassword(String password) {
        byte[] hashPassInBytes = encryptPassword.encrypt(password);
        return Hex.encodeHexString(hashPassInBytes);
    }
}
