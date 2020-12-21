package studAdmin;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class StudentDAO implements Dao<Student> {

    private EntityManager entityManager;

    public StudentDAO() {
        entityManager = Persistence.createEntityManagerFactory("StudentAdminWDB").createEntityManager();
    }

    public void closeEntityManager() {
        entityManager.close();
    }

    @Override
    public Optional<Student> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Student> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM Student e");
        List<Student> students;
        students = query.getResultList();
        return students;
    }

    @Override
    public void add(Student student) {
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
    public void save(Student student) {
        executeInsideTransaction(entityManager -> entityManager.persist(student));
    }

    @Override
    public void delete(int id) {
        EntityTransaction et = null;
        Student student = null;
        try {
            et = entityManager.getTransaction();
            et.begin();
            student = entityManager.find(Student.class, id);
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
        Query query = entityManager.createQuery("SELECT count(e) FROM Student e");
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
