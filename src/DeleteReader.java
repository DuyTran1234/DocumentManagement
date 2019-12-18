import java.sql.SQLException;
import java.util.Scanner;

public class DeleteReader {
    static void deleteReader() throws SQLException {
        String readerID = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter ReaderID need delete: ");
            readerID = scanner.nextLine();
            if(ConnectSQL.selectSQL("select ReaderID from Reader where ReaderID = " + "'" + readerID + "'").next()) {
                break;
            }
            else {
                System.out.println("ReaderID entered not exists, please enter again!!");
            }
        }
        String sql = "delete from Reader where ReaderID = " + "'" + readerID + "'";
        ConnectSQL.settingSQL(sql);
    }
}
