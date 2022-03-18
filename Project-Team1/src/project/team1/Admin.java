package project.team1;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import static project.team1.jdbclink.con;
import static project.team1.jdbclink.linking;

public class Admin extends jdbclink
{
      Scanner s=new Scanner(System.in);
      String aname, sport_incharge;
            int aid, contact;
    void addnew()
   {
     System.out.print("Enter number of admins you want to enter: ");
     int n=s.nextInt();
     for(int i=0;i<n;i++)
      {
            
            System.out.print("Enter admin Id: ");
            aid=s.nextInt();
            System.out.print("Enter new admin name: ");
            aname=s.next();
            System.out.print("The sport which you are going to manage: ");
            sport_incharge=s.next();
            System.out.print("Enter your contact number: ");
            contact=s.nextInt();
            String q2="Insert into admin_details() values(?,?,?,?)";
            try
            {
                linking();
                PreparedStatement ps=con.prepareStatement(q2);
                ps.setInt(1,aid);
                ps.setString(2,aname);
                ps.setString(3,sport_incharge);
                ps.setInt(4,contact);
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
                ResultSet rs =st.executeQuery("select * from admin_details ");

                while(rs.next())
                {
                    int admin_id=rs.getInt("admin_id");
                    String admin_name = rs.getString("admin_name");
                    String Sports_incharge = rs.getString("Sports_Incharge");
                    long no=rs.getLong("contact_number");
                    //printing data
                        System.out.print(admin_id+"\t");
                        System.out.print(admin_name+"\t\t");
                        System.out.print(Sports_incharge+"\t");
                        System.out.println(no+"\t");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        void update()
        {
            System.out.print("Enter admin Id whose record you want to update: ");
            aid=s.nextInt();
            try
            {
                linking();
                PreparedStatement ps =con.prepareStatement("select * from admin_details where admin_id=?");
                ps.setLong(1,aid);
                if(ps.execute()==true)
                {
                    System.out.print("Enter updated admin name: ");
                    aname=s.next();
                    System.out.print("The sport which you are going to manage: ");
                    sport_incharge=s.next();
                    System.out.print("Enter your updated contact number: ");
                    contact=s.nextInt();
                }
                else
                {
                    System.out.println("No Admin of id"+aid+"exsist");
                }
                
            }
            catch(Exception e)
            {
                
            }
            
        }
        Admin()
        {
            System.out.println("1.\tAdd new admin"+"\n2.\tShow admin details"+"\n3.\tUpdate Details"+"\n4.\tExit");
            System.out.print("Enter your choice:");
            int ch=s.nextInt();
            switch(ch)
            {
                case 1:addnew();
                    break;
                case 2:show();
                    break;
                case 3:update();
                    break;
                case 4:
                    break;
                default:System.out.println("WRONG CHOICE");
                break;
            }
      }
}
        
