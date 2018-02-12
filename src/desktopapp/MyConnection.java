package desktopapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnection {

    public static Connection getConnection() {

        Connection con = null;

        java.util.Locale locale = java.util.Locale.getDefault();
        java.util.Locale.setDefault(java.util.Locale.ENGLISH);

        try {
            con = DriverManager.getConnection("jdbc:sqlite:d:\\MyData\\StoreDataBase.db");
            return con;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
