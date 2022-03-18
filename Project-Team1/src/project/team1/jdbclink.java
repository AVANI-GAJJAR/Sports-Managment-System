package project.team1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbclink extends Exception
{
    public static Connection con;
    static void linking()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); //loading driver 
            String driverUrl = "jdbc:mysql://localhost:3306/sportsmanagement";
            con = DriverManager.getConnection(driverUrl,"root","");//creating connection
        }
        catch(Exception e)
        {        
            System.out.println(e);
        }
    }
}
