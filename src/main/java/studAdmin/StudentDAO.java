package studAdmin;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class StudentDAO implements Dao<StudentDB> {

    private EntityManager entityManager;

    public StudentDAO() {
        entityManager = Persistence.createEntityManagerFactory("StudentAdminWDB").createEntityManager();
    }

    public void closeEntityManager() {
        entityManager.close();
    }

    @Override
    public Optional<StudentDB> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<StudentDB> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM StudentDB e");
        List<StudentDB> students;
        students = query.getResultList();
        return students;
    }

    @Override
    public void add(StudentDB student) {
        EntityTransaction et = null;
        try {
            et = entityManager.getTransaction();
            et.begin();

            entityManager.persist(student);
            et.commit();

        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void save(StudentDB student) {
        executeInsideTransaction(entityManager -> entityManager.persist(student));
    }

    @Override
    public void delete(int id) {
        EntityTransaction et = null;
        StudentDB student = null;
        try {
            et = entityManager.getTransaction();
            et.begin();
            student = entityManager.find(StudentDB.class, id);
            entityManager.remove(student);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        }
    }

    public List<String> studDbCounter() {
        Query query = entityManager.createQuery("SELECT count(e) FROM StudentDB e");
        return (List<String>) query.getResultList();
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
