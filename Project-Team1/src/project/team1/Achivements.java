
package project.team1;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import static project.team1.jdbclink.con;
import static project.team1.jdbclink.linking;

public class Achivements extends jdbclink
{
     Scanner s=new Scanner(System.in);
    void add()
    {
        System.out.print("Enter total number of achivements to add: ");
        int n=s.nextInt();
        for(int i=0;i<n;i++)
        {
            String evname,win,first_r,second_r;
            
            System.out.print("Enter Event name: ");
            evname=s.next();
            System.out.print("Enter Winner name: ");
            win=s.next();
            System.out.print("Enter Name of 1st Runner up: ");
            first_r=s.next();
            System.out.print("Enter Name of 2nd Runner up: ");
            second_r=s.next();
            String q2="Insert into achievements(Event_name,winner,1st_Runner_Up,2nd_Runner_Up) values(?,?,?,?)";
            try
            {
                linking();
                PreparedStatement ps=con.prepareStatement(q2);
                ps.setString(1,evname);
                ps.setString(2,win);
                ps.setString(3,first_r);
                ps.setString(4,second_r);
                ps.executeUpdate();
                System.out.println("Data Inserted");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    void show()
    {
        try
        {
            linking();
            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery("select * from achievements ");
            System.out.println("No.\t"+"Event Name\t"+"Winner\t\t"+"1st RunnerUp\t\t"+"2nd RunnerUp\t\t");
            while(rs.next())
            {
                String eid=rs.getString("event_id");
                String ename=rs.getString("event_name");
                String win=rs.getString("winner");
                String first=rs.getString("1st_runner_up");
                String second=rs.getString("2nd_runner_up");
                //printing data
                    System.out.print(eid+"\t");
                    System.out.print(ename+"   \t");
                    System.out.print(win+"\t\t");
                    System.out.print(first+"\t\t\t");
                    System.out.println(second+"\t\t");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
