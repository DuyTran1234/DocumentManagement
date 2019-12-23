import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PrintTicket {
    static void printTicket() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String ticketID = "";
        while(true) {
            System.out.println("Enter TicketID need print: ");
            ticketID = scanner.nextLine();
            ResultSet resultSet = ConnectSQL.selectSQL("select * from TicketBorrow where TicketID = " + "'" + ticketID + "'");
            if(showResult(resultSet)) {
                break;
            }
            else {
                System.out.println("Not exist TicketID, please enter again!");
            }
        }
    }
    static boolean showResult(ResultSet resultSet) throws SQLException {
        boolean check = false;
        Ticket ticket = new Ticket();
        String[] list = new String[5];
        while(resultSet.next()) {
            ticket.setTicketID(resultSet.getString("TicketID"));
            ticket.setDateBorrow(resultSet.getString("DateBorrow"));
            ticket.setDeadline(resultSet.getString("Deadline"));
            ticket.setReaderID(resultSet.getString("ReaderID"));
            list[0] = resultSet.getString("BorrowBook1");
            list[1] = resultSet.getString("BorrowBook2");
            list[2] = resultSet.getString("BorrowBook3");
            list[3] = resultSet.getString("BorrowBook4");
            list[4] = resultSet.getString("BorrowBook5");
            ticket.setBorrowBook(list);
            ticket.setEmployeeID(resultSet.getString("EmployeeID"));
            ticket.setDeposit(resultSet.getDouble("Deposit"));
            ticket.setAmountBook(resultSet.getInt("AmountBook"));
            ticket.showTicket();
            check = true;
        }
        return check;
    }
}












