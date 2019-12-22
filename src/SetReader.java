import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetReader {
    void setReader() throws SQLException, ParseException {
        boolean check = false;
        String str = "";
        String id = "";
        Pattern pattern;
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        Reader reader = new Reader();
        SetPerson.setPerson(reader, "Reader");
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













