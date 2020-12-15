package studAdmin;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DBChanger {

    public void changeID(Student student) {
        int id;
        CW.print("Please enter the new ID of the student: ");
        id = UserInput.intIn();
        student.setId(id);
        CW.newLine();
        CW.print("Information successfully changed to: " + id);
        CW.newLine();
    }

    public void changeName(DBController DB) {
        EntityManager em = DB.getEntityManager();
        EntityTransaction et = null;
        Student stud = null;

        try {
            et = em.getTransaction();
            et.begin();

            CW.print("Please enter the new name");
            String name = UserInput.in.nextLine();

            //stud = em.find(Student.class, ?????); what goes in hereeee, and how do i change it in Menu.InfoChangeMenu ??
            stud.setName(name);

            em.persist(stud);
            et.commit();

            CW.newLine();
            CW.print(CW.infoChangeSuccessForVar(name));
            CW.newLine();

        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void changeDOB(Student student) {
        String birthDate;
        CW.print("Please enter the new date of birth: ");
        birthDate = UserInput.strIn();
        student.setBirthDate(birthDate);
        CW.newLine();
        CW.print(CW.infoChangeSuccessForVar(birthDate));
        CW.newLine();
    }

    public void changeBirthYear(Student student) {
        String birthYear;
        CW.print("Please enter the new birth year: ");
        birthYear = UserInput.strIn();
        student.setBirthYear(birthYear);
        CW.newLine();
        CW.print(CW.infoChangeSuccessForVar(birthYear));
        CW.newLine();
    }

    public void changeAddress(Student student) {
        String address;
        CW.print("Please enter the new address: ");
        address = UserInput.strIn();
        student.setAddress(address);
        CW.newLine();
        CW.print(CW.infoChangeSuccessForVar(address));
        CW.newLine();
    }

    public void changePhoneNumber(Student student) {
        String phone;
        CW.print("Please enter the new phone number: ");
        phone = UserInput.strIn();
        student.setPhone(phone);
        CW.newLine();
        CW.print(CW.infoChangeSuccessForVar(phone));
        CW.newLine();
    }

    public void changeProgram(Student student) {
        String program;
        CW.newLine();
        CW.print("Please enter the new program: ");
        program = UserInput.strIn();
        student.setProgram(program);
        CW.newLine();
        CW.print(CW.infoChangeSuccessForVar(program));
        CW.newLine();
    }

}
