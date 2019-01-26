package springJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC {


    public static void main(String[] args){
        String sql = "select * from instructor";
    }

    public static void JDBCexec(String sql) throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/school", "root", "admin");
            Statement statement = connection.createStatement();



        }catch(Exception e){
            System.out.println("Exception: "+ e);
        }
    }
}
