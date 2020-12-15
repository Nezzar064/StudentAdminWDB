package studAdmin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.*;

public class DBController {

    private EntityManagerFactory emf;

    private Connection conn;

    private Connection con = DriverManager.getConnection("jdbc:mysql://localhost/studentAdministration?serverTimezone=UTC", "root", "sTrongPW64");


    public DBController() throws SQLException {
        emf = Persistence.createEntityManagerFactory("StudentAdministrationWithDB");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/studentAdministration?serverTimezone=UTC", "root", "sTrongPW64");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void addStudent(Student student) {
        EntityManager em = getEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();

            em.persist(student);
            et.commit();

            CW.newLine();
            CW.print("Student successfully added to the system!");
            CW.newLine();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            // Close EntityManager
            em.close();
        }
    }

    public void deleteStudent() {
        EntityManager em = getEntityManager();
        EntityTransaction et = null;
        Student stud = null;

        try {
            CW.print("Please enter the students ID");
            int id = UserInput.intIn.nextInt();
            et = em.getTransaction();
            et.begin();
            stud = em.find(Student.class, id);
            em.remove(stud);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public String studentDbCounter() throws SQLException {
        Statement stm;
        stm = con.createStatement();
        String sql = "SELECT COUNT(*) FROM students";
        ResultSet rst = stm.executeQuery(sql);
        String counter = null;
        while (rst.next()) {
            counter = rst.getString(1);
        }
        return counter;
    }

    public void studentUpdater(Student student) {
        EntityManager em = getEntityManager();
        EntityTransaction et = null;

        try {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }
}
