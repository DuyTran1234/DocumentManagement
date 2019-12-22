import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Menu2 {
    static void menu2() throws SQLException, ParseException {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("=========== Information Readers, Employees ===========");
            System.out.println("1. Reader");
            System.out.println("2. Employee");
            System.out.println("0. Back to menu");
            System.out.println("#Select: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 0) {
                break;
            }
            else if(choice == 1) {
                int select = 0;
                while(true) {
                    System.out.println("================== Reader ==================");
                    System.out.println("1. Add a new Reader into database");
                    System.out.println("2. Edit reader based on ReaderID");
                    System.out.println("3. Delete a record reader based on ReaderID");
                    System.out.println("4. Search reader based on: ");
                    System.out.println("0. Back to Information Readers, Employees");
                    System.out.print("#Select: ");
                    select = scanner.nextInt();
                    scanner.nextLine();
                    if(select == 0) {
                        break;
                    }
                    else if(select == 1) {
                        SetReader setReader = new SetReader();
                        setReader.setReader();
                    }
                    else if(select == 2) {
                        EditReader.editReader();
                    }
                    else if(select == 3) {
                        DeleteReader.deleteReader();
                    }
                    else if(select == 4) {
                        int choice1 = 0;
                        while(true) {
                            System.out.println("============= Search reader based on: =============");
                            System.out.println("1. Name Reader");
                            System.out.println("2. ReaderID");
                            System.out.println("3. Reader Type");
                            System.out.println("0. Back to Reader");
                            System.out.print("#Select: ");
                            choice1 = scanner.nextInt();
                            scanner.nextLine();
                            if(choice1 == 0) {
                                break;
                            }
                            else if(choice1 == 1) {
                                SearchReader.searchReaderBasedOnName();
                            }
                            else if(choice1 == 2) {
                                SearchReader.searchReaderBasedOnReaderID();
                            }
                            else if(choice1 == 3) {
                                SearchReader.searchReaderBasedOnReaderType();
                            }
                            else {
                                System.out.println("Wrong input, please enter again number 0->2");
                            }
                        }
                    }
                }
            }
            else if(choice == 2) {
                int select = 0;
                while(true) {
                    System.out.println("================== Employee ==================");
                    System.out.println("1. Add a new Employee into database");
                    System.out.println("2. Edit Employee based on EmployeeID");
                    System.out.println("3. Delete a record Employee based on EmployeeID");
                    System.out.println("4. Search Employee based on: ");
                    System.out.println("0. Back to Information Readers, Employees");
                    System.out.print("#Select: ");
                    select = scanner.nextInt();
                    scanner.nextLine();
                    if(select == 0) {
                        break;
                    }
                    else if(select == 1) {
                        SetEmployee.addEmployee();
                    }
                    else if(select == 2) {
                        EditEmployee.editEmployee();
                    }
                    else if(select == 3) {
                        DeleteEmployee.deleteEmployee();
                    }
                    else if(select == 4) {
                        System.out.println("============ Search Employee based on ============");
                        System.out.println("1. Full Name");
                        System.out.println("2. EmployeeID");
                        System.out.println("3. Position");
                        System.out.println("0. Exit");
                        System.out.println("#Select: ");
                        int choice1 = scanner.nextInt();
                        scanner.nextLine();
                        if(choice1 == 0) {
                            break;
                        }
                        else if(choice1 == 1) {
                            SearchEmployee.searchEmployeeBasedOnName();
                        }
                    }
                    else {
                        System.out.println("Wrong input, please enter number 0 -> 4");
                    }
                }
            }
        }
    }
}
