package web.dao;

import web.models.User;

import java.util.List;

public interface UserDAO {

    void saveUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();

    User getUserById(long id);

    void updateUser(User user);
}
