import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ParseException {
        ConnectSQL.connectionSQL();
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("=========================== MENU ===========================");
            System.out.println("1. Manage information document");
            System.out.println("2. Information Readers, Employees");
            System.out.println("3. Information manage ticket books borrow");
            System.out.println("0. Exit");
            System.out.print("#Select: ");
            choice = scanner.nextInt();
            if(choice == 1) {
                Menu1.menu1();
            }
            else if(choice == 2) {
                Menu2.menu2();
            }
            else if(choice == 3) {
                Menu3.menu3();
            }
            else if(choice == 0) {
                break;
            }
            else {
                System.out.println("Wrong input, please enter number 0 -> 3");
            }
        }
    }
}















