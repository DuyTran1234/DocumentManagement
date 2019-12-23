import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditTicket {
    static void editTicket() throws SQLException, ParseException {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern;
        Matcher matcher;
        String field = "";
        String ticketID = "";
        while(true) {
            System.out.println("Enter TicketID need edit: ");
            ticketID = scanner.nextLine();
            if(ConnectSQL.selectSQL("select * from TicketBorrow where TicketID = " + "'" + ticketID + "'").next()) {
                break;
            }
            else {
                System.out.println("Wrong input TicketID, please enter again!!");
            }
        }
        while(true) {
            System.out.println("Enter a field need edit (TicketID|DateBorrow|Deadline|ReaderID|BorrowBook1|BorrowBook2|BorrowBook3|BorrowBook4|BorrowBook5|EmployeeID|Deposit): ");
            field = scanner.nextLine();
            pattern = Pattern.compile("TicketID|DateBorrow|Deadline|ReaderID|BorrowBook1|BorrowBook2|BorrowBook3|BorrowBook4|BorrowBook5|EmployeeID|Deposit");
            matcher = pattern.matcher(field);
            if(matcher.matches()) {
                break;
            }
        }
        System.out.println("Enter value of " + field + " need edit: ");
        if(field.equals("Deposit")) {
            double value = scanner.nextDouble();
            scanner.nextLine();
            ConnectSQL.settingSQL("update TicketBorrow set " + field + " = " + value + " where TicketID = " + "'" + ticketID + "'");
            System.out.println("Update Success!");
        }
        else if(field.equals("DateBorrow") || field.equals("Deadline")) {
            String str = "";
            while(true) {
                System.out.println("Enter " + field + " (Format: YYYY/MM/DD) : ");
                str = scanner.nextLine();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
                simpleDateFormat.setLenient(false);
                Date date = simpleDateFormat.parse(str);
                if(date != null) {
                    ConnectSQL.settingSQL("update TicketBorrow set " + field + " = " + "'" + str + "'" + " where TicketID = " + "'" + ticketID + "'");
                    System.out.println("Update Success!");
                    break;
                }
                else {
                    System.out.println("Wrong input, please enter again!!");
                }
            }
        }
        else if(field.equals("BorrowBook1") || field.equals("BorrowBook2") || field.equals("BorrowBook3") || field.equals("BorrowBook4") || field.equals("BorrowBook5")) {
            int count = 0;
            while(true) {
                System.out.println("Enter value: ");
                String value = scanner.nextLine();
                pattern = Pattern.compile("null");
                matcher = pattern.matcher(value);
                String sql = "select * from Document where BookID = " + "'" + value + "'";
                if(matcher.matches() || ConnectSQL.selectSQL(sql).next()) {
                    ConnectSQL.settingSQL("update TicketBorrow set " + field + " = " + "'" + value + "'" + " where TicketID = " + "'" + ticketID + "'");
                    System.out.println("Update Success!");
                    break;
                }
                else {
                    System.out.println("Wrong input, please enter again!!");
                }
            }
            ResultSet resultSet = ConnectSQL.selectSQL("select * from TicketBorrow where TicketID = " + "'" + ticketID + "'");
            while(resultSet.next()) {
                for(int i = 0; i < 5; i++) {
                    if(!resultSet.getString("BorrowBook" + (i + 1)).equals("null")) {
                        count++;
                    }
                }
            }
            ConnectSQL.settingSQL("update TicketBorrow set AmountBook = " + count + " where TicketID = " + "'" + ticketID + "'");
        }
        else if(field.equals("ReaderID")) {
            while(true) {
                System.out.println("Enter value: ");
                String value = scanner.nextLine();
                String sql = "select * from Reader where ReaderID = " + "'" + value + "'";
                if(ConnectSQL.selectSQL(sql).next()) {
                    ConnectSQL.settingSQL("update TicketBorrow set " + field + " = " + "'" + value + "'" + " where TicketID = " + "'" + ticketID + "'");
                    System.out.println("Update Success!");
                    break;
                }
                else {
                    System.out.println("Not exists ReaderID, please enter again!");
                }
            }
        }
        else if(field.equals("EmployeeID")) {
            while(true) {
                System.out.println("Enter value: ");
                String value = scanner.nextLine();
                String sql = "select * from Employee where EmployeeID = " + "'" + value + "'";
                if(ConnectSQL.selectSQL(sql).next()) {
                    ConnectSQL.settingSQL("update TicketBorrow set " + field + " = " + "'" + value + "'" + " where TicketID = " + "'" + ticketID + "'");
                    System.out.println("Update Success!");
                    break;
                }
                else {
                    System.out.println("Not exists EmployeeID, please enter again!");
                }
            }
        }
        else if(field.equals("TicketID")) {
            while(true) {
                System.out.println("Enter value: ");
                String value = scanner.nextLine();
                String sql = "select * from TicketBorrow where TicketID = " + "'" + value + "'";
                if(!ConnectSQL.selectSQL(sql).next()) {
                    ConnectSQL.settingSQL("update TicketBorrow set " + field + " = " + "'" + value + "'" + " where TicketID = " + "'" + ticketID + "'");
                    System.out.println("Update Success!");
                    break;
                }
                else {
                    System.out.println("Wrong input, please enter again!");
                }
            }
        }
    }
}









