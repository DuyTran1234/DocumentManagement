public class Reader extends Person {
    private String ReaderID;
    private String ReaderType;
    private String phoneNumber;
    private String email;

    String getReaderID() {
        return ReaderID;
    }

    String getReaderType() {
        return ReaderType;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    String getEmail() {
        return email;
    }

    void setReaderID(String readerID) {
        ReaderID = readerID;
    }

    void setReaderType(String readerType) {
        ReaderType = readerType;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    void setEmail(String email) {
        this.email = email;
    }

    void showReader() {
        System.out.println("ID: " + getID());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Address: " + getAddress());
        System.out.println("Date of Birth: " + getDOB());
        System.out.println("Gender: " + getGender());
        System.out.println("ReaderID: " + getReaderID());
        System.out.println("Reader Type: " + getReaderType());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
    }
}
