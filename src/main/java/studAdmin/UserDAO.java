package studAdmin;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.function.Consumer;

public class UserDAO {

    private EntityManager entityManager;

    public UserDAO() {
        entityManager = Persistence.createEntityManagerFactory("StudentAdminWDB").createEntityManager();
    }

    public void add(Users user) {
        EntityTransaction et = null;
        try {
            et = entityManager.getTransaction();
            et.begin();

            entityManager.persist(user);
            et.commit();

        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        }
    }

    public void delete(String username) {
        EntityTransaction et = null;
        Users user = null;
        try {
            et = entityManager.getTransaction();
            et.begin();
            user = entityManager.find(Users.class, username);
            entityManager.remove(user);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        }
    }

    public List<Users> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM Users e");
        List<Users> users;
        users = query.getResultList();
        return users;
    }

    public byte[] getPassword(String username) {
        Query query = entityManager.createQuery("SELECT password FROM Users WHERE Users.username = :username").setParameter("username", username);


    }

    public void save(Users user) {
        executeInsideTransaction(entityManager -> entityManager.persist(user));
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
