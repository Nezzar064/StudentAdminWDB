package studAdmin;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Override
    public String toString() {
        return
                "Username: " + username + "\n" +
                "Password: " + password
                ;
    }

    public Users() {
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
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
}
