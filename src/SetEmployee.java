import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetEmployee {
    static void addEmployee() throws SQLException, ParseException {
        Employee employee = new Employee();
        SetPerson.setPerson(employee, "Employee");
        Pattern pattern;
        Matcher matcher;
        String str = "";
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Enter EmployeeID: ");
            str = scanner.nextLine();
            pattern = Pattern.compile("NVTV_[0-9]{4}");
            matcher = pattern.matcher(str);
            String sql = "select * from Employee where EmployeeID = " + "'" + str + "'";
            if(matcher.matches() && !ConnectSQL.selectSQL(sql).next()) {
                employee.setEmployeeID(str);
                break;
            }
            else {
                System.out.println("Wrong input, please enter again!!!");
            }
        }
        System.out.println("Enter position: ");
        str = scanner.nextLine();
        employee.setPosition(str);

        System.out.println("Enter Work Flow: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        employee.setWorkFlow(num);

        String sqlEmployee = "insert Employee values(" + "'" + employee.getEmployeeID() + "'" + "," +
                                                        "'" + employee.getPosition() + "'" + "," +
                                                                employee.getWorkFlow() + "," +
                                                        "'" + employee.getID() + "'" + ")";
        ConnectSQL.settingSQL(sqlEmployee);
    }
}




















