
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreate {

    private static final String SQL_CREATE = "CREATE TABLE EMPLOYEE"
            + "("
            + " ID serial,"
            + " NAME varchar(100) NOT NULL,"
            + " SALARY numeric(15, 2) NOT NULL,"
            + " PRIMARY KEY (ID)"
            + ")";

    public static void main(String[] args) {

		// auto close 
        try (Connection conn = DriverManager.getConnection(
        		"jdbc:mysql://127.0.0.1:3306/practice", "root", "root");
             Statement statement = conn.createStatement()) {

            // if DDL failed, it will raise an SQLException
            statement.execute(SQL_CREATE);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}