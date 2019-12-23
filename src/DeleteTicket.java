import java.sql.SQLException;
import java.util.Scanner;

public class DeleteTicket {
    static void deleteTicket() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String ticketID = "";
        while(true) {
            System.out.println("Enter TicketID need delete: ");
            ticketID = scanner.nextLine();
            if(ConnectSQL.selectSQL("select * from TicketBorrow where TicketID = " + "'" + ticketID + "'").next()) {
                ConnectSQL.settingSQL("delete from TicketBorrow where TicketID = " + "'" + ticketID + "'");
                System.out.println("Delete Success!!");
                break;
            }
            else {
                System.out.println("Not exist TicketID, please enter again!");
            }
        }
    }
}











