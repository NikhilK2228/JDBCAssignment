
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class RowInsert {

    public static void main(String[] args) {

        // auto close connection and statement
        try (Connection conn = DriverManager.getConnection(
        		"jdbc:mysql://127.0.0.1:3306/practice", "root", "root");
             Statement statement = conn.createStatement()) {

            int row = statement.executeUpdate(generateInsert("Nikhil", new BigDecimal(100.00)));

            // rows affected
            System.out.println("Row inserted: "+row);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String generateInsert(String name, BigDecimal salary) {

        return "INSERT INTO EMPLOYEE (NAME, SALARY) " +
                "VALUES ('" + name + "','" + salary + "')";

    }
}