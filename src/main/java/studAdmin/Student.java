package studAdmin;

public class Student {

    //If you change the object, remember to change in mapper as well.

    private int id;
    private String name;
    private String birthDate;
    private String birthYear;
    private String address;
    private String phone;
    private String program;

    @Override
    public String toString() {
        return
                "ID: " + "\"" + id + "\"" + "\n" +
                        "Name: " + "\"" + name + "\"" + "\n" +
                        "Birth Date: " + "\"" + birthDate + "\"" + "\n" +
                        "Birth Year: " + "\"" + birthYear + "\"" + "\n" +
                        "Address: " + "\"" + address + "\"" + "\n" +
                        "Phone: " + "\"" + phone + "\"" + "\n" +
                        "Program: " + "\"" + program + "\"" + "\n"
                ;
    }

    public Student() {
    }

    public Student(String program) {
        this.program = program;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id, String name, String birthDate, String birthYear, String address, String phone, String program) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.birthYear = birthYear;
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

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthYear() {
        return birthYear;
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

