
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String url = "jdbc:mysql://localhost:3306/shopdb";
    private static final String user = "root";
    private static final String password = "Bagh_31122000";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
//Mini interview answer (memorize this)
//The most important way to connect Java to SQL for an interview is JDBC.

//JDBC = Java Database Connectivity
// JDBC is the standard Java API for database access.
// I create a Connection using DriverManager, use PreparedStatement to run SQL safely, and use ResultSet to read query results.
// My honest advice for your interview
// Since you are preparing for Ausbildung / junior-level questions, if they ask about SQL + Java, 90% chance they want the simple JDBC explanation, not deep Hibernate theory.

//So focus on:
// What is JDBC //How to connect //How to run SELECT //How to run INSERT/UPDATE/DELETE
// Why PreparedStatement is better //For YOU as a beginner // //👉 You do NOT need MySQL Shell right now
// For your interview prep, focus on:
// MySQL Workbench //JDBC // Java //basic SQL queries // //That is enough.