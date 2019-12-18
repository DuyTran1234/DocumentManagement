import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditDocument {
    static void editDocument() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern;
        Matcher matcher;
        String bookID = "";
        while(true) {
            System.out.println("Enter BookID need edit: ");
            bookID = scanner.nextLine();
            pattern = Pattern.compile("DCMT_[0-9]{6}");
            matcher = pattern.matcher(bookID);
            if(matcher.matches() && SetDocument.checkBookID(bookID)) {
                break;
            }
            else {
                System.out.println("BookID not exists, please enter again!!!");
            }
        }
        while(true) {
            String choice = "";
            String field = "";
            String value = "";
            String sql = "";
            while(true) {
                System.out.println("Select field need edit (NameDocument|Author|BookType|Amount): ");
                field = scanner.nextLine();
                pattern = Pattern.compile("NameDocument|Author|BookType|Amount");
                matcher = pattern.matcher(field);
                if(matcher.matches()) {break;}
                else {
                    System.out.println("Wrong input, please enter again!!!");
                }
            }
            System.out.println("Enter value need edit into field " + field + " : ");
            value = scanner.nextLine();
            if(field.equals("Amount")) {
                int valueAmount = Integer.parseInt(value);
                sql = "update dbo.Document set " + field + " = " + valueAmount + " where BookID = " + "'" + bookID + "'";
                ConnectSQL.settingSQL(sql);
            }
            else {
                sql = "update dbo.Document set " + field + " = " + "'" + value + "'" + " where BookID = " + "'" + bookID + "'";
                ConnectSQL.settingSQL(sql);
            }
            System.out.println("You want continue edit fields of BookID " + bookID + "? (YES: 1/NO: any character): ");
            choice = scanner.nextLine();
            if(!choice.equals("1")) {
                break;
            }
        }
    }
}










