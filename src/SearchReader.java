import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchReader {
    static void searchReaderBasedOnName() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String nameReader = "";
        String sql = "";
        while(true) {
            System.out.println("Enter Name Reader need search: ");
            nameReader = scanner.nextLine();
            sql = "select * from Person, Reader where Person.FullName = " + "'" + nameReader + "'" + " and Person.ID = Reader.PersonID";
            if(showResult(ConnectSQL.selectSQL(sql))) {
                break;
            }
            else {
                System.out.println("Not exists name reader entered!!");
            }
        }
    }
    static void searchReaderBasedOnReaderID() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String readerID = "";
        String sql = "";
        while(true) {
            System.out.println("Enter ReaderID need search: ");
            readerID = scanner.nextLine();
            sql = "select * from Person, Reader where Reader.ReaderID = " + "'" + readerID + "'" + " and Person.ID = Reader.PersonID";
            if(showResult(ConnectSQL.selectSQL(sql))) {
                break;
            }
            else {
                System.out.println("Not exists name reader entered!!");
            }
        }
    }
    static void searchReaderBasedOnReaderType() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String readerType = "";
        String sql = "";
        while(true) {
            System.out.println("Enter ReaderID need search: ");
            readerType = scanner.nextLine();
            sql = "select * from Person, Reader where Reader.ReaderType = " + "'" + readerType + "'" + " and Person.ID = Reader.PersonID";
            if(showResult(ConnectSQL.selectSQL(sql))) {
                break;
            }
            else {
                System.out.println("Not exists name reader entered!!");
            }
        }
    }
    static boolean showResult(ResultSet resultSet) throws SQLException {
        boolean check = false;
        while(resultSet.next()) {
            Reader reader = new Reader();
            reader.setID(resultSet.getString("ID"));
            reader.setFullName(resultSet.getString("FullName"));
            reader.setAddress(resultSet.getString("Address"));
            reader.setDOB(resultSet.getString("DOB"));
            reader.setGender(resultSet.getString("Gender"));
            reader.setReaderID(resultSet.getString("ReaderID"));
            reader.setReaderType(resultSet.getString("ReaderType"));
            reader.setPhoneNumber(resultSet.getString("PhoneNumber"));
            reader.setEmail(resultSet.getString("Email"));
            reader.showReader();
            System.out.println();
            check = true;
        }
        return check;
    }
}











