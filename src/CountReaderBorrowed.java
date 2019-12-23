import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CountReaderBorrowed {
    static void maxReaderBorrowed() throws SQLException {
        ArrayList<Ticket> list = new ArrayList<Ticket>();
        int amount = 0;
        int max = 0;
        String maxReader = "";
        ResultSet resultSet = ConnectSQL.selectSQL("select * from TicketBorrow");
        while(resultSet.next()) {
            Ticket ticket = new Ticket();
            ticket.setReaderID(resultSet.getString("ReaderID"));
            ticket.setAmountBook(resultSet.getInt("AmountBook"));
            list.add(ticket);
        }
        for(int i = 0; i < list.size(); i++) {
            if(i == 0) {
                max = amount;
            }
            amount = list.get(i).getAmountBook();
            for(int j = 0; j < list.size(); j++) {
                if(list.get(i).getReaderID().equals(list.get(j).getReaderID()) && i != j) {
                    amount = amount + list.get(j).getAmountBook();
                }
            }
            if(amount > max) {
                max = amount;
                maxReader = list.get(i).getReaderID();
            }
        }
        System.out.println("Reader borrowed book max: " + maxReader + " and borrowed " + max + " book");
    }

    static void minReaderBorrowed() throws SQLException {
        ArrayList<Ticket> list = new ArrayList<Ticket>();
        int amount = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        String minReader = "";
        ResultSet resultSet = ConnectSQL.selectSQL("select * from TicketBorrow");
        while(resultSet.next()) {
            Ticket ticket = new Ticket();
            ticket.setReaderID(resultSet.getString("ReaderID"));
            ticket.setAmountBook(resultSet.getInt("AmountBook"));
            list.add(ticket);
        }
        for(int i = 0; i < list.size(); i++) {
            if(i == 0) {
                min = amount;
            }
            amount = list.get(i).getAmountBook();
            for(int j = 0; j < list.size(); j++) {
                if(list.get(i).getReaderID().equals(list.get(j).getReaderID()) && i != j) {
                    amount = amount + list.get(j).getAmountBook();
                }
            }
            if(amount < min) {
                min = amount;
                minReader = list.get(i).getReaderID();
            }
        }
        System.out.println("Reader borrowed book max: " + minReader + " and borrowed " + min + " book");
    }
}











