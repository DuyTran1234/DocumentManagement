import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditEmployee {
    static void editEmployee() throws SQLException, ParseException {
        Pattern pattern;
        Scanner scanner = new Scanner(System.in);
        Matcher matcher;
        String employeeID;
        while(true) {
            System.out.println("Enter EmployeeID need edit: ");
            employeeID = scanner.nextLine();
            pattern = Pattern.compile("NVTV_[0-9]{4}");
            matcher = pattern.matcher(employeeID);
            String sql = "select * from Employee where EmployeeID = " + "'" + employeeID + "'";
            if(matcher.matches() && ConnectSQL.selectSQL(sql).next()) {
                break;
            }
            else {
                System.out.println("EmployeeID not exists, please enter again!!");
            }
        }
        while(true) {
            while(true) {
                System.out.println("Select 1 field need edit (Position|WorkFlow|PersonID) : ");
                String field = scanner.nextLine();
                if(field.equals("Position")) {
                    System.out.println("Enter values of " + field + " : ");
                    String values = scanner.nextLine();
                    ConnectSQL.settingSQL("update Employee set " + field + " = " + "'" + values + "'" + " where EmployeeID = " + "'" + employeeID + "'");
                    System.out.println("Update success!!");
                    break;
                }
                else if(field.equals("WorkFlow")) {
                    System.out.println("Enter values of " + field + " : ");
                    int values = scanner.nextInt();
                    scanner.nextLine();
                    ConnectSQL.settingSQL("update Employee set " + field + " = " + values + " where EmployeeID = " + "'" + employeeID + "'");
                    System.out.println("Update success!!");
                    break;
                }
                else if(field.equals("PersonID")) {
                    System.out.println("Enter values of " + field + " : ");
                    Person person = new Person();
                    SetPerson.setPerson(person, "Employee");
                    if(!person.getID().equals("false")) {
                        String sql = "update Employee set " + field + " = " + "'" + person.getID() + "'" + " where EmployeeID = " + "'" + employeeID + "'";
                        ConnectSQL.settingSQL(sql);
                        System.out.println("Update success!!");
                    }
                    break;
                }
                System.out.println("You want continue edit? (Y: YES|Any character: NO) : ");
                String choice = scanner.nextLine();
                if(!choice.equals("Y")) {
                    break;
                }
            }
        }
    }
}
