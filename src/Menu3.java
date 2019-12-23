import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Menu3 {
    static void menu3() throws SQLException, ParseException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("============ Information manage ticket books borrow ============");
            System.out.println("1. Add a new ticket borrow");
            System.out.println("2. Edit a ticket borrow based on TicketID");
            System.out.println("3. Delete a ticket borrow based on TicketID");
            System.out.println("4. Print ticket borrow based on TicketID");
            System.out.println("5. Let me know which book borrowed : ");
            System.out.println("6. Let me know which reader borrowed: ");
            System.out.println("0. Back to menu");
            System.out.print("#Select: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 0) {
                break;
            }
            else if(choice == 1) {
                SetTicket.setTicket();
            }
            else if(choice == 2) {
                EditTicket.editTicket();
            }
            else if(choice == 3) {
                DeleteTicket.deleteTicket();
            }
            else if(choice == 4) {
                PrintTicket.printTicket();
            }
            else if(choice == 5) {
                int select = 0;
                System.out.println("============ Let me know which book borrowed ============");
                System.out.println("1. Max");
                System.out.println("2. Min");
                System.out.println("0. Back to Information manage ticket books borrow");
                System.out.print("#Select: ");
                select = scanner.nextInt();
                scanner.nextLine();
                if(select == 1) {
                    CountBorrowBook.maxBorrowBook();
                }
                else if(select == 2) {
                    CountBorrowBook.minBorrowBook();
                }
                else if(select == 0) {
                    break;
                }
                else {
                    System.out.println("Please enter again number 0 -> 2");
                }
            }
            else if(choice == 6) {
                System.out.println("================ Let me know which reader borrowed ================");
                System.out.println("1. Max borrow book");
                System.out.println("2. Min borrow book");
                System.out.println("0. Back to Information manage ticket books borrow");
                System.out.print("#Select: ");
                int select = scanner.nextInt();
                scanner.nextLine();
                if(select == 0) {
                    break;
                }
                else if (select == 1) {
                    CountReaderBorrowed.maxReaderBorrowed();
                }
                else if(select == 2) {
                    CountReaderBorrowed.minReaderBorrowed();
                }
                else {
                    System.out.println("Please enter again number 0 -> 2 !");
                }
            }
        }
    }
}













