import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetDocument {
    private Document document = new Document();

    void importDocument() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern;
        Matcher matcher;
        String str = "";
        int flag = 0;
        do {
            System.out.println("Enter BookID: ");
            str = scanner.nextLine();
            document.setBookID(str);
            pattern = Pattern.compile("DCMT_[0-9]{6}");
            matcher = pattern.matcher(document.getBookID());
        }while(!matcher.matches() || checkBookID(document.getBookID()));
        System.out.println("Enter Name Document: ");
        str = scanner.nextLine();
        document.setNameDocument(str);
        System.out.println("Enter Author: ");
        str = scanner.nextLine();
        document.setAuthor(str);
        System.out.println("Enter book type: ");
        str = scanner.nextLine();
        document.setBookType(str);
        System.out.println("Enter Amount Book: ");
        flag = scanner.nextInt();
        document.setAmount(flag);
        scanner.nextLine();
        String sql = "insert Document values(" + "'" + document.getBookID() + "'" + "," +
                                                "'" + document.getNameDocument() + "'" + "," +
                                                "'" + document.getAuthor() + "'" + "," +
                                                "'" + document.getBookType() + "'" + "," +
                                                        document.getAmount() +
                                                ")";
        ConnectSQL.settingSQL(sql);
    }
    static boolean checkBookID(String BookID) throws SQLException {
        String sql = "Select * from dbo.Document where BookID = " + "'" + BookID + "'";
        ResultSet resultSet = ConnectSQL.selectSQL(sql);
        return resultSet.next();
    }
}

















