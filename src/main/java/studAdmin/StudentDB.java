package studAdmin;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class StudentDB implements Serializable {

    //If you change the object, remember to change in mapper as well..

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", unique = true)
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "birthdate")
    private LocalDate birthDate;

    @Column (name = "address")
    private String address;

    @Column (name = "phone", unique = true)
    private String phone;

    @Column (name = "program")
    private String program;

    public String toString() {
        return
                "ID: " + id + "\n" +
                        "Name: " + name + "\n" +
                        "Birthdate: " + birthDate + "\n" +
                        "Address: " + address + "\n" +
                        "Phone: "  + phone + "\n" +
                        "Program: " + program + "\n"
                ;
    }

    public StudentDB() {
    }

    public StudentDB(String program) {
        this.program = program;
    }

    public StudentDB(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentDB(int id, String name, LocalDate birthDate, String address, String phone, String program) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.program = program;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getProgram() {
        return program;
    }

}
