package studAdmin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private byte[] password;

    @Override
    public String toString() {
        return
                "Username: " + username + "\n" +
                "Password: " + Arrays.toString(password)
                ;
    }

    public Users() {
    }

    public Users(String username, byte[] password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }
}
