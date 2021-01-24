package studAdmin;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public User mapFromDatabaseObject(UserDB userDB) {
        User user = new User();
        user.setUsername(userDB.getUsername());
        user.setPassword(userDB.getPassword());
        user.setHasAdminStatus(userDB.getAdminStatus());
        user.setSalt(userDB.getSalt());

        return user;
    }

    public UserDB mapToDatabaseObject(User user) {
        UserDB userDB = new UserDB();
        userDB.setUsername(user.getUsername());
        userDB.setPassword(user.getPassword());
        userDB.setHasAdminStatus(user.getAdminStatus());
        userDB.setSalt(user.getSalt());
        return userDB;
    }

    public List<User> mapListFromDatabaseList(List<UserDB> userDBlist) {
        List<User> userList = new ArrayList<>();
        userDBlist.forEach(user -> userList.add(mapFromDatabaseObject(user)));
        return userList;
    }

    public List<UserDB> mapListToDatabaseList(List<User> userList) {
        List<UserDB> userDbList = new ArrayList<>();
        userList.forEach(user -> userDbList.add(mapToDatabaseObject(user)));
        return userDbList;
    }
}
