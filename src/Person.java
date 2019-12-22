import java.util.Date;

public class Person {
    private String ID;
    private String fullName;
    private String address;
    private String DOB;
    private String gender;

    void setID(String ID) {
        this.ID = ID;
    }

    void setFullName(String fullName) {
        this.fullName = fullName;
    }

    void setAddress(String address) {
        this.address = address;
    }

    void setDOB(String DOB) {
        this.DOB = DOB;
    }

    void setGender(String gender) {
        this.gender = gender;
    }

    String getID() {
        return ID;
    }

    String getFullName() {
        return fullName;
    }

    String getAddress() {
        return address;
    }

    String getDOB() {
        return DOB;
    }

    String getGender() {
        return gender;
    }

    void showPerson() {
        System.out.println("ID: " + this.getID());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Address: " + getAddress());
        System.out.println("Date of Birth: " + getDOB());
        System.out.println("Gender: " + getGender());
    }
}
