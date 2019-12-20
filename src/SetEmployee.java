import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetEmployee {
    private Employee employee = new Employee();

    void addEmployee() throws SQLException {
        Pattern pattern;
        Matcher matcher;
        String str = "";
        String id = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter ID: ");
            id = scanner.nextLine();
            pattern = Pattern.compile("NVTV_[0-9]{4}");
            matcher = pattern.matcher(id);
            String sql = "select * from Employee, Person where Person.ID = " + "'" + id + "'" + " and " +
                                                                "Employee.PersonID = " + "'" + id + "'";
            if(matcher.matches() && !ConnectSQL.selectSQL(sql).next()) {
                employee.setID(id);
                break;
            }
        }
    }
}




















