import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetReader {
    private Reader reader = new Reader();
    void setReader() throws SQLException, ParseException {
        String str = "";
        String id = "";
        Pattern pattern;
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter person ID: ");
            id = scanner.nextLine();
            String sql = "select * from Reader, Person where Reader.PersonID = " + "'" + id + "'" + " AND " +
                                                                    "Person.ID = " + "'" + id + "'";
            if(!ConnectSQL.selectSQL(sql).next()) {
                reader.setID(id);
                break;
            }
            else {
                System.out.println("Person ID exists in database, please enter again!!!");
            }
        }
        System.out.println("Enter full name: ");
        str = scanner.nextLine();
        reader.setFullName(str);
        System.out.println("Enter address: ");
        str = scanner.nextLine();
        reader.setAddress(str);
        while(true) {
            System.out.println("Enter Date of Birth (format: yyyy/mm/dd) :");
            str = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            simpleDateFormat.setLenient(false);
            Date date = simpleDateFormat.parse(str);
            if(date != null) {
                reader.setDOB(str);
                break;
            }
            else {
                System.out.println("Wrong input, please enter again!!");
            }
        }
        while(true) {
            System.out.println("Enter Gender (Male|Female): ");
            str = scanner.nextLine();
            pattern = Pattern.compile("Male|Female");
            matcher = pattern.matcher(str);
            if(matcher.matches()) {
                reader.setGender(str);
                break;
            }
            else {
                System.out.println("Wrong input, please enter again!!");
            }
        }
        String sqlPerson = "insert dbo.Person values(" + "'" + reader.getID() + "'" + "," +
                                                        "'" + reader.getFullName() + "'" + "," +
                                                        "'" + reader.getAddress() + "'" + "," +
                                                        "'" + reader.getDOB() + "'" + "," +
                                                        "'" + reader.getGender() + "'" + ")";
        ConnectSQL.settingSQL(sqlPerson);
        while(true) {
            System.out.println("Enter Reader ID: ");
            str = scanner.nextLine();
            pattern = Pattern.compile("BD_[0-9]{6}");
            matcher = pattern.matcher(str);
            String sql = "select ReaderID from Reader where ReaderID = " + "'" + str + "'";
            if(matcher.matches() && !ConnectSQL.selectSQL(sql).next()) {
                reader.setReaderID(str);
                break;
            }
            else {
                System.out.println("Wrong Input, please enter again!!!");
            }
        }
        System.out.println("Enter Reader Type");
        str = scanner.nextLine();
        reader.setReaderType(str);
        System.out.println("Enter Phone Number: ");
        str = scanner.nextLine();
        reader.setPhoneNumber(str);
        System.out.println("Enter Email: ");
        str = scanner.nextLine();
        reader.setEmail(str);
        String sqlReader = "insert dbo.Reader values(" + "'" + reader.getReaderID() + "'" + "," +
                                                        "'" + reader.getReaderType() + "'" + "," +
                                                        "'" + reader.getPhoneNumber() + "'" + "," +
                                                        "'" + reader.getEmail() + "'" + "," +
                                                        "'" + reader.getID() + "'" + ")";
        ConnectSQL.settingSQL(sqlReader);
    }
}













