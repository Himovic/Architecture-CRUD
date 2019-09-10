package Functions;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbManagement {

    //Connecting DB
    public static Connection Connect(){
        Connection connection = null;

        String url = "jdbc:mysql://url";
        String username = "username";
        String password = "password";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return connection;
    }
}
