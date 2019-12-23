import java.util.ArrayList;
import java.util.Date;

public class Ticket {
    private String ticketID;
    private String dateBorrow;
    private String deadline;
    private String ReaderID;
    private String EmployeeID;
    private double deposit;
    private String[] borrowBook = new String[5];
    private int amountBook;

    public String getTicketID() {
        return ticketID;
    }

    public String getDateBorrow() {
        return dateBorrow;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getReaderID() {
        return ReaderID;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public double getDeposit() {
        return deposit;
    }

    public String[] getBorrowBook() {
        return borrowBook;
    }

    public int getAmountBook() {
        return amountBook;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public void setDateBorrow(String dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setReaderID(String readerID) {
        ReaderID = readerID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public void setBorrowBook(String[] borrowBook) {
        this.borrowBook = borrowBook;
    }

    public void setAmountBook(int amountBook) {
        this.amountBook = amountBook;
    }

    public void showTicket() {
        System.out.println("Ticket ID : " + this.ticketID);
        System.out.println("DateBorrow: " + this.dateBorrow);
        System.out.println("DeadLine: " + this.deadline);
        System.out.println("ReaderID borrow book: " + this.ReaderID);
        for(int i = 0; i < borrowBook.length; i++) {
            System.out.println("BorrowBook " + (i + 1) + " : " + borrowBook[i]);
        }
        System.out.println("EmployeeID give borrow book: " + this.EmployeeID);
        System.out.println("Deposit: " + this.deposit + " $");
        System.out.println("Amount Book: " + this.amountBook);
    }
}
