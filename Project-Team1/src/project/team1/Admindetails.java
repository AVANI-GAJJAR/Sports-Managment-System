/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.team1;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import static project.team1.jdbclink.con;
import static project.team1.jdbclink.linking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import static project.team1.jdbclink.con;
import static project.team1.jdbclink.linking;

public class Admindetails extends jdbclink
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
                System.out.println("No.\t"+"Name\t\t"+"Sport Incharge\t\t"+"Contact Number");
                while(rs.next())
                {
                    int admin_id=rs.getInt("admin_id");
                    String admin_name = rs.getString("admin_name");
                    String Sports_incharge = rs.getString("Sports_Incharge");
                    long no=rs.getLong("contact_number");
                    //printing data
                        System.out.print(admin_id+"\t");
                        System.out.print(admin_name+"\t\t");
                        System.out.print(Sports_incharge+"\t\t\t");
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
            int aid=s.nextInt();
            System.out.print("Enter admin name whose record you want to update: ");
            String name=s.next();
            System.out.print("Enter admin Sports: ");
            String sports=s.next();
            System.out.print("Enter admin Contact number: ");
            int Cno=s.nextInt();
            
            try
            {
                linking();
                PreparedStatement ps =con.prepareStatement("update admin_details SET `admin_name`=?, `Sports_incharge`=?,`contact_number`=? WHERE `admin_id`=?;");
                ps.setString(1,name);
                ps.setString(2,sports);
                ps.setInt(3,Cno);
                ps.setInt(4,aid);
                ps.executeUpdate();
                show();
            }
            
            catch(Exception e)
            {
                
            }   
        }
        
        
}
        

