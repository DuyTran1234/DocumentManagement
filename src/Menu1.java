import java.sql.SQLException;
import java.util.Scanner;

public class Menu1 {
    static void menu1() throws SQLException {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("=================== Manage information document ===================");
            System.out.println("1. Import new a document into Database");
            System.out.println("2. Edit information a book based on BookID");
            System.out.println("3. Delete record a book based on BookID");
            System.out.println("4. Search information book based on: ");
            System.out.println("0. Back to menu");
            System.out.print("#Select: ");
            choice = scanner.nextInt();
            if(choice == 1) {
                SetDocument setDocument = new SetDocument();
                setDocument.importDocument();
            }
            else if(choice == 2) {
                EditDocument.editDocument();
            }
            else if(choice == 0) {
                break;
            }
            else if(choice == 3) {
                DeleteDocument.deleteDocument();
            }
            else if(choice == 4) {
                int select = 0;
                while(true) {
                    System.out.println("========= Search information book based on: =========");
                    System.out.println("1. Name Document");
                    System.out.println("2. Author");
                    System.out.println("0. Back to Manage information document");
                    System.out.print("#Select: ");
                    select = scanner.nextInt();
                    scanner.nextLine();
                    if(select == 0) {
                        break;
                    }
                    else if(select == 1) {
                        SearchDocument.searchDocumentBasedOnNameDocument();
                    }
                    else if(select == 2) {
                        SearchDocument.searchDocumentBasedOnAuthor();
                    }
                    else {
                        System.out.println("Wrong input, please enter number 0 -> 2");
                    }
                }
            }
            else {
                System.out.println("Wrong input, please enter number 0 -> 4");
            }
        }
    }
}














