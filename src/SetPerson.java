import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetPerson {
     static Person setPerson(Person person, String tableName) throws SQLException, ParseException {
        person.setID("false"); person.setAddress(""); person.setFullName(""); person.setDOB(""); person.setGender("");
        boolean check = false;
        Pattern pattern;
        Matcher matcher;
        String str = "";
        String id = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter ID: ");
            id = scanner.nextLine();
            String sql1 = "select * from Person where ID = " + "'" + id + "'";
            String sql2 = "select * from " + tableName + " where PersonID = " + "'" + id + "'";
            if(!ConnectSQL.selectSQL(sql1).next()) {
                System.out.println("Person ID not exists database, you want proceed import information Person? (Y: YES|Any character: NO) ");
                String choice = scanner.nextLine();
                if(choice.equals("Y")) {
                    check = true;
                    person.setID(id);
                    break;
                }
            }
            else if(ConnectSQL.selectSQL(sql1).next() && !ConnectSQL.selectSQL(sql2).next()) {
                System.out.println("Person ID exists in Person database, proceed import information: ");
                person.setID(id);
                break;
            }
            else {
                System.out.println("Person ID exists in 2 database Person and " + tableName + ", please enter Person ID again!!!");
            }
        }
        if(check == true) {
            System.out.println("Enter Full Name: ");
            str = scanner.nextLine();
            person.setFullName(str);
            System.out.println("Enter Address: ");
            str = scanner.nextLine();
            person.setAddress(str);
            while(true) {
                System.out.println("Enter Date Of Birth (format: YYYY/MM/DD): ");
                str = scanner.nextLine();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
                simpleDateFormat.setLenient(false);
                Date date = simpleDateFormat.parse(str);
                if(date != null) {
                    person.setDOB(str);
                    break;
                }
                else {
                    System.out.println("Wrong input, please enter again!");
                }
            }
            while(true) {
                System.out.println("Enter Gender (Male|Female): ");
                str = scanner.nextLine();
                pattern = Pattern.compile("Male|Female");
                matcher = pattern.matcher(str);
                if(matcher.matches()) {
                    person.setGender(str);
                    break;
                }
                else {
                    System.out.println("Wrong input, please enter again!!!");
                }
            }
            String sqlPerson = "insert Person values(" + "'" + person.getID() + "'" + "," +
                    "'" + person.getFullName() + "'" + "," +
                    "'" + person.getAddress() + "'" + "," +
                    "'" + person.getDOB() + "'" + "," +
                    "'" + person.getGender() + "'" + ")";
            ConnectSQL.settingSQL(sqlPerson);
        }
        return person;
    }
}
