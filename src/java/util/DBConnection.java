package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

    private DBConnection(){
        
    }
    private static DBConnection db;

    public static DBConnection getDb() {
        if(db ==  null){
            db = new DBConnection();
        }
        return db;
    }
    
    public Connection getConnection() {
        final String url = "jdbc:mariadb://localhost:3306/rentacarweb";
        final String user = "root";
        final String password = "3344";
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
           System.out.println("Connected to the MARİADB server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }

    }

