package studAdmin;

public class User {

    private String username;
    private String password;
    private boolean hasAdminStatus;
    private byte[] salt;

    @Override
    public String toString() {
        return
                "Username: " + username + "\n" +
                "Admin Status: " + hasAdminStatus + "\n"
                ;
    }

    public User() {

    }

    public User(String username, String password, boolean hasAdminStatus, byte[] salt) {
        this.username = username;
        this.password = password;
        this.hasAdminStatus = hasAdminStatus;
        this.salt = salt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAdminStatus() {
        return hasAdminStatus;
    }

    public void setHasAdminStatus(boolean hasAdminStatus) {
        this.hasAdminStatus = hasAdminStatus;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}
