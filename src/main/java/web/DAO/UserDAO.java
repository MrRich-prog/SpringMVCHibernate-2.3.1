package web.DAO;

import web.models.User;

import java.util.List;

public interface UserDAO {

    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, int age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
