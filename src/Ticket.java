import java.util.ArrayList;
import java.util.Date;

public class Ticket {
    private String ticketID;
    private Date dateBorrow;
    private Date deadline;
    private String ReaderID;
    private ArrayList<String> borrowBook = new ArrayList<>(5);
    private String EmployeeID;
    private double deposit;

    public String getTicketID() {
        return ticketID;
    }

    public Date getDateBorrow() {
        return dateBorrow;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getReaderID() {
        return ReaderID;
    }

    public ArrayList<String> getBorrowBook() {
        return borrowBook;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public void setDateBorrow(Date dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setReaderID(String readerID) {
        ReaderID = readerID;
    }

    public void setBorrowBook(ArrayList<String> borrowBook) {
        this.borrowBook = borrowBook;
    }
}
