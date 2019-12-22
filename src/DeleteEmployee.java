import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployee {
    static void deleteEmployee() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            while(true) {
                System.out.println("Enter EmployeeID need delete: ");
                String employeeID = scanner.nextLine();
                String sql = "select * from Employee where EmployeeID = " + "'" + employeeID + "'";
                if(ConnectSQL.selectSQL(sql).next()) {
                    ConnectSQL.settingSQL("delete from Employee where EmployeeID = " + "'" + employeeID + "'");
                    System.out.println("Delete success!!");
                    break;
                }
                else {
                    System.out.println("EmployeeID not exists");
                    break;
                }
            }
            System.out.println("You want continue delete Employee? (Y:YES|Any character:NO) : ");
            String choice = scanner.nextLine();
            if(!choice.equals("Y")) {
                break;
            }
        }
    }
}











