import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleteDocument {
    static void deleteDocument() throws SQLException {
        Pattern pattern;
        Matcher matcher;
        String bookID = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter BookID need delete: ");
            bookID = scanner.nextLine();
            pattern = Pattern.compile("DCMT_[0-9]{6}");
            matcher = pattern.matcher(bookID);
            if(matcher.matches() && SetDocument.checkBookID(bookID)) {
                break;
            }
            else {
                System.out.println("BookID entered not exists, please enter again!!!");
            }
        }
        String sql = "delete from dbo.Document where BookID = " + "'" + bookID + "'";
        ConnectSQL.settingSQL(sql);
    }
}



















