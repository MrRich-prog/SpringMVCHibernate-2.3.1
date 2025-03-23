package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAO;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void createUsersTable() {
        userDAO.createUsersTable();
    }

    @Transactional
    @Override
    public void dropUsersTable() {
        userDAO.dropUsersTable();
    }

    @Transactional
    @Override
    public void saveUser(String name, int age) {
        userDAO.saveUser(name, age);
    }

    @Transactional
    @Override
    public void removeUserById(long id) {
        userDAO.removeUserById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public void cleanUsersTable() {
        userDAO.cleanUsersTable();
    }

}
