import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditReader {
    static void editReader() throws SQLException {
        String readerID = "";
        String field = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter ReaderID need edit: ");
            readerID = scanner.nextLine();
            String sql = "select ReaderID from Reader where ReaderID = " + "'" + readerID + "'";
            if(ConnectSQL.selectSQL(sql).next()) {
                break;
            }
        }
        while(true) {
            String choice = "";
            System.out.println("Select a field need edit (ReaderID|ReaderType|PhoneNumber|Email|FullName|Address|DOB|Gender): ");
            field = scanner.nextLine();
            Pattern pattern = Pattern.compile("ReaderID|ReaderType|PhoneNumber|Email|FullName|Address|DOB|Gender");
            Matcher matcher = pattern.matcher(field);
            if(matcher.matches()) {
                if(field.equals("ReaderID")) {
                    String value = "";
                    while(true) {
                        System.out.println("Enter value of " + field + " need edit: ");
                        value = scanner.nextLine();
                        String sql = "select ReaderID from Reader where ReaderID = " + "'" + value + "'";
                        Pattern pattern1 = Pattern.compile("BD_[0-9]{6}");
                        Matcher matcher1 = pattern1.matcher(value);
                        if(matcher1.matches() && !ConnectSQL.selectSQL(sql).next()) {
                            break;
                        }
                        else {
                            System.out.println("Wrong input, please enter again!!");
                        }
                    }
                    String sql = "update Reader set " + field + " = " + "'" + value + "'" + " where ReaderID = " + "'" + readerID + "'";
                    ConnectSQL.settingSQL(sql);
                }
                else if(field.equals("ReaderType") || field.equals("PhoneNumber") || field.equals("PhoneNumber")) {
                    String value = "";
                    System.out.println("Enter value of " + field + " need edit: ");
                    value = scanner.nextLine();
                    String sql = "update Reader set " + field + " = " + "'" + value + "'" + " where ReaderID = " + "'" + readerID + "'";
                    ConnectSQL.settingSQL(sql);
                }
                else if(field.equals("FullName") || field.equals("Address") || field.equals("DOB") || field.equals("Gender")) {
                    String value = "";
                    System.out.println("Enter value of " + field + " need edit: ");
                    value = scanner.nextLine();
                    String sql = "declare @check nvarchar(255); " +
                            "set @check = (select ID from Person, Reader " +
                            " where Reader.ReaderID = " + "'" + readerID + "'" +
                            " and Reader.PersonID = Person.ID) " + "update Person set " + field + " = " + "'" + value + "'" +
                            " where ID = @check";
                    ConnectSQL.settingSQL(sql);
                }
            }
            System.out.print("You want continue? (1:YES|any different character:NO): ");
            choice = scanner.nextLine();
            if(!choice.equals("1")) {break;}
        }
    }
}











