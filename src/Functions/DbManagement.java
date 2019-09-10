package Functions;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManagement {

    //Connecting DB
    public static Connection Connect(){
        Connection connection = null;

        String url = "jdbc:mysql://remotemysql.com:3306/RgYUS051m6";
        String username = "RgYUS051m6";
        String password = "ugzTQhF0WG";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return connection;
    }
}
