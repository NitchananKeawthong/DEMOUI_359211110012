package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private static final String SQCONN="jdbc:sqlite:src/School.sqlite";
    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("org.sqlte.JDBC");
            return DriverManager.getConnection(SQCONN);

        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return null;
    }




}//class
