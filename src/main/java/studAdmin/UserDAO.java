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

    public void add(UserDB user) {
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
        UserDB user = null;
        try {
            et = entityManager.getTransaction();
            et.begin();
            user = entityManager.find(UserDB.class, username);
            entityManager.remove(user);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        }
    }

    public List<UserDB> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM UserDB e");
        List<UserDB> users;
        users = query.getResultList();
        return users;
    }

    public String getPasswordForInputtedUsername(String username) {
        Query query = entityManager.createQuery("SELECT password FROM UserDB WHERE UserDB.username = :username").setParameter("username", username);
        return (String) query.getSingleResult();
    }

    public boolean getAdminStatusForInputtedUsername(String username) {
        Query query = entityManager.createQuery("SELECT hasAdminStatus FROM UserDB WHERE UserDB.username = :username").setParameter("username", username);
        return (boolean)query.getSingleResult();
    }

    public void save(UserDB user) {
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
