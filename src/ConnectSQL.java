import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ConnectSQL {
    static Connection connectionSQL() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=DocumentManagement";
        String user = "sa";
        String password = "kid1412";
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    static ResultSet selectSQL(String sql) throws SQLException {
        if (connectionSQL() != null) {
            PreparedStatement statement = connectionSQL().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        }
        else {
            System.out.println("Cannot Connect Database");
            return null;
        }
    }

    static void settingSQL(String sql) throws SQLException {
        if(connectionSQL() != null) {
            PreparedStatement statement = connectionSQL().prepareStatement(sql);
            statement.executeUpdate();
        }
        else {
            System.out.println("Cannot Connect Database");
            return;
        }
    }
}


















