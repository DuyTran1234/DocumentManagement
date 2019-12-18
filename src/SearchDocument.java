import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchDocument {
    static void searchDocumentBasedOnNameDocument() throws SQLException {
        String nameDocument = "";
        String sql = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter Name Document need search: ");
            nameDocument = scanner.nextLine();
            sql = "select * from Document where NameDocument = " + "'" + nameDocument + "'";
            ResultSet resultSet = ConnectSQL.selectSQL(sql);
            int check = showResult(resultSet);
            if(check == 0) {
                System.out.println("Name Document not exist in database, please enter again!");
            }
            else {break;}
        }
    }
    static void searchDocumentBasedOnAuthor() throws SQLException {
        String author = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter Author need search");
            author = scanner.nextLine();
            String sql = "select * from Document where Author = " + "'" + author + "'";
            ResultSet resultSet = ConnectSQL.selectSQL(sql);
            int check = showResult(resultSet);
            if(check == 0) {
                System.out.println("Author not exist in database, please enter again!");
            }
            else {break;}
        }
    }
    static int showResult(ResultSet resultSet) throws SQLException {
        int count = 0;
        while(resultSet.next()) {
            Document document = new Document();
            document.setBookID(resultSet.getString("BookID"));
            document.setNameDocument(resultSet.getString("NameDocument"));
            document.setAuthor(resultSet.getString("Author"));
            document.setBookType(resultSet.getString("BookType"));
            document.setAmount(resultSet.getInt("Amount"));
            document.showDocument();
            System.out.println();
            count++;
        }
        return count;
    }
}



















