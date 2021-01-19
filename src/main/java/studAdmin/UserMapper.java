package studAdmin;

import java.util.ArrayList;
import java.util.List;

//DOESNT WORK!! GET HELP

public class UserMapper {

    public User mapFromDatabaseObject(UserDB userDB) {
        User user = new User();
        userDB.setUsername(user.getUsername());
        userDB.setPassword(user.getPassword());
        userDB.setHasAdminStatus(user.getAdminStatus());

        return user;
    }

    public UserDB mapToDatabaseObject(User user) {
        UserDB userDB = new UserDB();
        user.setUsername(userDB.getUsername());
        user.setPassword(userDB.getPassword());
        user.setHasAdminStatus(userDB.hasAdminStatus());
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
