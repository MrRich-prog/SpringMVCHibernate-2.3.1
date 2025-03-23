package web.DAO;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Users (" +
                "`id` INT NOT NULL AUTO_INCREMENT," +
                "`name` VARCHAR(45) NOT NULL," +
                "`age` INT NOT NULL," +
                "PRIMARY KEY (`id`))";
        entityManager.createNativeQuery(sql).executeUpdate();
    }

    @Override
    public void dropUsersTable() {
        entityManager.createNativeQuery("DROP TABLE IF EXISTS Users").executeUpdate();
    }

    @Override
    public void saveUser(String name, int age) {
        User user = new User(name, age);
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("select user from User user", User.class);
        return query.getResultList();
    }

    @Override
    public void cleanUsersTable() {
        entityManager.createQuery("DELETE FROM User").executeUpdate();
    }
}
