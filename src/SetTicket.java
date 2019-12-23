import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetTicket {
    static void setTicket() throws SQLException, ParseException {
        Ticket ticket = new Ticket();
        int amountBook = 0;
        String[] list = new String[5];
        Scanner scanner = new Scanner(System.in);
        String str = "";
        Pattern pattern;
        Matcher matcher;
        while(true) {
            System.out.println("Enter TicketID: ");
            str = scanner.nextLine();
            pattern = Pattern.compile("PM_[0-9]{6}");
            matcher = pattern.matcher(str);
            String sql = "select * from TicketBorrow where TicketID = " + "'" + str + "'";
            if(matcher.matches() && !ConnectSQL.selectSQL(sql).next()) {
                ticket.setTicketID(str);
                break;
            }
            else {
                System.out.println("TicketID exists in database, please enter again!!");
            }
        }
        while(true) {
            System.out.println("Enter Date Borrow (Format: YYYY/MM/DD) : ");
            str = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            simpleDateFormat.setLenient(false);
            Date date = simpleDateFormat.parse(str);
            if(date != null) {
                ticket.setDateBorrow(str);
                break;
            }
            else {
                System.out.println("Wrong input, please enter again!!");
            }
        }
        while(true) {
            System.out.println("Enter DateLine (Format: YYYY/MM/DD) : ");
            str = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            simpleDateFormat.setLenient(false);
            Date date = simpleDateFormat.parse(str);
            if(date != null) {
                ticket.setDeadline(str);
                break;
            }
            else {
                System.out.println("Wrong input, please enter again!!");
            }
        }
        while(true) {
            System.out.println("Enter readerID borrow book: ");
            str = scanner.nextLine();
            pattern = Pattern.compile("BD_[0-9]{6}");
            matcher = pattern.matcher(str);
            String sql = "select * from Reader where ReaderID = " + "'" + str + "'";
            if(matcher.matches() && ConnectSQL.selectSQL(sql).next()) {
                ticket.setReaderID(str);
                break;
            }
            else {
                System.out.println("Wrong input, please enter again!!");
            }
        }
        for(int i = 0; i < list.length; i++) {
            while(true) {
                System.out.println("Enter BookID of BookBorrow" + (i + 1) + " (null if no borrowBook Or bookID): ");
                str = scanner.nextLine();
                pattern = Pattern.compile("null");
                matcher = pattern.matcher(str);
                String sql = "select * from Document where BookID = " + "'" + str + "'";
                if(matcher.matches() || ConnectSQL.selectSQL(sql).next()) {
                    list[i] = str;
                    break;
                }
                else {
                    System.out.println("Wrong input BookID, please enter again!!");
                }
            }
        }
        ticket.setBorrowBook(list);
        while(true) {
            System.out.println("Enter EmployeeID give BookBorrow: ");
            str = scanner.nextLine();
            pattern = Pattern.compile("NVTV_[0-9]{4}");
            matcher = pattern.matcher(str);
            String sql = "select * from Employee where EmployeeID = " + "'" + str + "'";
            if(matcher.matches() && ConnectSQL.selectSQL(sql).next()) {
                ticket.setEmployeeID(str);
                break;
            }
            else {
                System.out.println("Wrong input EmployeeID, please enter again!!");
            }
        }
        while(true) {
            System.out.println("Enter money deposit (USD): ");
            double deposit = scanner.nextDouble();
            scanner.nextLine();
            if(deposit >= 0 && deposit <= 50) {
                ticket.setDeposit(deposit);
                break;
            }
            else {
                System.out.println("Enter money values 0 to 50 USD !!");
            }
        }
        for(int i = 0; i < ticket.getBorrowBook().length; i++) {
            if(!ticket.getBorrowBook()[i].equals("null")) {
                amountBook++;
            }
        }
        ticket.setAmountBook(amountBook);

        String sql = "insert TicketBorrow values(" + "'" + ticket.getTicketID() + "'" + "," +
                                                    "'" + ticket.getDateBorrow() + "'" + "," +
                                                    "'" + ticket.getDeadline() + "'" + "," +
                                                    "'" + ticket.getReaderID() + "'" + "," +
                                                    "'" + ticket.getBorrowBook()[0] + "'" + "," +
                                                    "'" + ticket.getBorrowBook()[1] + "'" + "," +
                                                    "'" + ticket.getBorrowBook()[2] + "'" + "," +
                                                    "'" + ticket.getBorrowBook()[3] + "'" + "," +
                                                    "'" + ticket.getBorrowBook()[4] + "'" + "," +
                                                    "'" + ticket.getEmployeeID() + "'" + "," +
                                                    ticket.getDeposit() + "," +
                                                    ticket.getAmountBook() + ")";
        ConnectSQL.settingSQL(sql);
    }
}














