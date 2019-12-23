import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CountBorrowBook {
    static void maxBorrowBook() throws SQLException {
        String maxBook = "dcm";
        ArrayList<String> list = new ArrayList<>();
        ResultSet resultSet = ConnectSQL.selectSQL("select * from TicketBorrow");
        while(resultSet.next()) {
            for(int i = 0; i < 5; i++) {
                list.add(resultSet.getString("BorrowBook" + (i + 1)));
            }
        }
        int count = 0;
        int max = 0;
        for(int i = 0; i < list.size(); i++) {
            if(i == 0) {
                max = count;
            }
            max = count;
            count = 1;
            if(!list.get(i).equals("null")) {
                for(int j = 0; j < list.size(); j++) {
                    if(list.get(i).equals(list.get(j)) && j != i) {
                        count++;
                    }
                }
            }
            if(count > max) {
                maxBook = list.get(i);
                max = count;
            }
        }
        System.out.println("BookID borrowed max in library: " + maxBook);
    }
    static void minBorrowBook() throws SQLException {
        int count = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        String minBook = "";
        ArrayList<String> list = new ArrayList<>();
        ResultSet resultSet = ConnectSQL.selectSQL("select * from TicketBorrow");
        while(resultSet.next()) {
            for(int i = 0; i < 5; i++) {
                list.add(resultSet.getString("BorrowBook" + (i + 1)));
            }
        }

        for(int i = 0; i < list.size(); i++) {
            if(i == 0) {
                min = count;
            }
            count = 1;

            if(!list.get(i).equals("null")) {
                for(int j = 0; j < list.size(); j++) {
                    if(list.get(i).equals(list.get(j)) && i != j) {
                        count++;
                    }
                }
            }

            if(count < min) {
                min = count;
                minBook = list.get(i);
            }
        }
        System.out.println("BookID borrowed min in library: " + minBook);
    }
}
