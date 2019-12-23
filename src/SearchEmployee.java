import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchEmployee {

    static void searchEmployeeBasedOnName() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            while(true) {
                System.out.println("Enter Name Employee need search: ");
                String name = scanner.nextLine();
                ResultSet resultSet = ConnectSQL.selectSQL("select * from Person, Employee where Person.FullName = " + "'" + name + "'" + " and " + "Person.ID = Employee.PersonID");
                if(showResult(resultSet)) {
                    break;
                }
                else {
                    System.out.println("Name not exists in database!!!");
                    break;
                }
            }
            System.out.println("You want continue search? (Y:YES|Any Character: NO): ");
            String choice = scanner.nextLine();
            if(!choice.equals("Y")) {
                break;
            }
        }
    }
    static void searchEmployeeBasedOnEmployeeID() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            while(true) {
                System.out.println("Enter EmployeeID need search: ");
                String id = scanner.nextLine();
                ResultSet resultSet = ConnectSQL.selectSQL("select * from Person, Employee where Employee.EmployeeID = " + "'" + id + "'" + " and " + "Person.ID = Employee.PersonID");
                if(showResult(resultSet)) {
                    break;
                }
                else {
                    System.out.println("Name not exists in database!!!");
                    break;
                }
            }
            System.out.println("You want continue search? (Y:YES|Any Character: NO): ");
            String choice = scanner.nextLine();
            if(!choice.equals("Y")) {
                break;
            }
        }
    }
    static void searchEmployeeBasedOnPosition() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            while(true) {
                System.out.println("Enter EmployeeID need search: ");
                String position = scanner.nextLine();
                ResultSet resultSet = ConnectSQL.selectSQL("select * from Person, Employee where Employee.Position = " + "'" + position + "'" + " and " + "Person.ID = Employee.PersonID");
                if(showResult(resultSet)) {
                    break;
                }
                else {
                    System.out.println("Name not exists in database!!!");
                    break;
                }
            }
            System.out.println("You want continue search? (Y:YES|Any Character: NO): ");
            String choice = scanner.nextLine();
            if(!choice.equals("Y")) {
                break;
            }
        }
    }

    static boolean showResult(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        boolean check = false;
        while(resultSet.next()) {
            check = true;
            employee.setID(resultSet.getString("ID"));
            employee.setFullName(resultSet.getString("FullName"));
            employee.setAddress(resultSet.getString("Address"));
            employee.setDOB(resultSet.getString("DOB"));
            employee.setGender(resultSet.getString("Gender"));
            employee.setEmployeeID(resultSet.getString("EmployeeID"));
            employee.setPosition(resultSet.getString("Position"));
            employee.setWorkFlow(resultSet.getInt("WorkFlow"));
            employee.showEmployee();
        }
        return check;
    }
}














