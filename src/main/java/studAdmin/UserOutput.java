package studAdmin;

import java.util.List;

public class UserOutput {

    public void listAllUsers(List<User> users) {
        if (!users.isEmpty()) {
            CW.newLine();
            CW.print("*User information*");
            CW.newLine();
            users.forEach(System.out::println);
        } else {
            CW.newLine();
            CW.print(CW.noUsersRegisteredMsg());
        }
    }
}
