package project.team1;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import static project.team1.jdbclink.con;
import static project.team1.jdbclink.linking;

public class Events
{
    Scanner s=new Scanner(System.in);
    String q1="select * from events ";
    String q2="select * from events order by Event_Name";
    String q3="select * from events order by type_of_event";
    String q4="select * from events where type_of_event=\"out\"";
    String q5="select distinct(event_name) from events ";
    void addnew_event()
    {

        System.out.print("Enter number of events you want to enter: ");
        int n=s.nextInt();
        for(int i=0;i<n;i++)
        {
                String Event_name,TOE,DOE,Time_OE,Venue;
                int participants;
                System.out.print("Enter Event name: ");
                Event_name=s.next();
                System.out.print("Enter Type of Event(in/out): ");
                TOE=s.next();
                System.out.print("Enter Date of Event: ");
                DOE=s.next();
                System.out.print("Enter Time of Event: ");
                Time_OE=s.next();
                System.out.print("Enter no of participants: ");
                participants=s.nextInt();
                System.out.print("Enter Venue: ");
                Venue=s.next();
                String q2="Insert into events(Event_name,type_of_event,date_of_event,Time_of_event,Participants,Venue) values(?,?,?,?,?,?)";
                try
                {
                    linking();
                    PreparedStatement ps=con.prepareStatement(q2);
                    ps.setString(1,Event_name);
                    ps.setString(2,TOE);
                    ps.setString(3,DOE);
                    ps.setString(4,Time_OE);
                    ps.setInt(5,participants);
                    ps.setString(6,Venue);
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
            ResultSet rs =st.executeQuery(q1);
            System.out.println("----------Event List----------");
            System.out.println("No.\t"+"Event Name   \t"+"Type of Event\t"+"Date of Event\t"+"Time\t"+"Participants\t"+"Venue\t");
            while(rs.next())
            {
                  int e_id=rs.getInt("Event_id");
                String e_name = rs.getString("Event_name");
                String TOE = rs.getString("type_of_event");
                String DOE =rs.getString("date_of_event");
                String time= rs.getString("Time_of_event");
                int participants=rs.getInt("Participants");
                String Venue= rs.getString("Venue");
                //printing data
                    System.out.print(e_id+"\t");
                    System.out.print(e_name+"   \t");
                    System.out.print(TOE+"\t\t");
                    System.out.print(DOE+"\t");
                    System.out.print(time+"\t");
                    System.out.print(participants+"\t\t");
                    System.out.println(Venue+"\t");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
  
    void sport_details()
    {
        try
        {
            linking();
            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery(q5);
            System.out.println("Sports Available");
            while(rs.next())
            {
                String e_name = rs.getString("Event_name");
               
                    System.out.print(e_name+"   \t");
                 
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    void sortbydate()
    {
        try
        {
            linking();
            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery(q2);
            
            while(rs.next())
            {
                int e_id=rs.getInt("Event_id");
                String e_name = rs.getString("Event_name");
                String TOE = rs.getString("type_of_event");
                String DOE =rs.getString("date_of_event");
                String time= rs.getString("Time_of_event");
                int participants=rs.getInt("Participants");
                String Venue= rs.getString("Venue");
                //printing data
                    System.out.print(e_id+"\t");
                    System.out.print(e_name+"   \t");
                    System.out.print(TOE+"\t\t");
                    System.out.print(DOE+"\t");
                    System.out.print(time+"\t");
                    System.out.print(participants+"\t");
                    System.out.println(Venue+"\t");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    void sortbyvenue()
    {
        try
        {
            linking();
            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery(q3);
            
            while(rs.next())
            {
                  int e_id=rs.getInt("Event_id");
                String e_name = rs.getString("Event_name");
                String TOE = rs.getString("type_of_event");
                String DOE =rs.getString("date_of_event");
                String time= rs.getString("Time_of_event");
                int participants=rs.getInt("Participants");
                String Venue= rs.getString("Venue");
                //printing data
                    System.out.print(e_id+"\t");
                    System.out.print(e_name+"   \t");
                    System.out.print(TOE+"\t");
                    System.out.print(DOE+"\t");
                    System.out.print(time+"\t");
                    System.out.print(participants+"\t");
                    System.out.println(Venue+"\t");
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
