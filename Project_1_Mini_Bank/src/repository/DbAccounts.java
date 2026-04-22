package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbAccounts {

        private static final String url = "jdbc:mysql://localhost:3306/accounts";
        private static final String user = "root";
        private static final String password = "Bagh_31122000";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, user, password);
        }

    }
