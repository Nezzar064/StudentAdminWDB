package studAdmin;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserDB implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "hasAdminStatus")
    @Convert(converter = YesNoBooleanConverter.class)
    private boolean hasAdminStatus;

    @Column(name = "salt")
    private byte[] salt;

    @Override
    public String toString() {
        return
                "Username: " + username + "\n" +
                        "Admin Status: " + hasAdminStatus + "\n"
                ;
    }

    public UserDB() {
    }

    public UserDB(String username, String password, boolean hasAdminStatus, byte[] salt) {
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

    public boolean hasAdminStatus() {
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
