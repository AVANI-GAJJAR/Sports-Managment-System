package project.team1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import static project.team1.jdbclink.con;
import static project.team1.jdbclink.linking;

class Equipment_function extends jdbclink
{
 
    Scanner s=new Scanner(System.in);
    void show()
    {
        try
        {
            linking();
            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery("select * from equipment ");
            System.out.println("No.\t"+"Name\t\t\t"+"Total Quantity\t\t\t"+"Taken\t");
            while(rs.next())
            {
                int eid=rs.getInt("equi_id");
                String equi_name=rs.getString("equi_name");
                int tot=rs.getInt("total_qty");
                int ava=rs.getInt("taken");
                //printing data
                    System.out.print(eid+"\t");
                    System.out.print(equi_name+"   \t\t\t");
                    System.out.print(tot+"\t\t\t");
                    System.out.println(ava+"\t");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
     void update()
     {
        linking();
        System.out.print("Enter equipment you want to update: ");
        String equi = s.next();
        System.out.println("Do you want to \n1)return \n2)borrow item?");
        int n = s.nextInt();
        
        if(n==1)
        {
            try 
            {
                System.out.print("Enter number of item: ");
                int a = s.nextInt();
                String q2="update equipment set taken=taken+? where equi_name=?";
                PreparedStatement ps=con.prepareStatement(q2);
                ps.setInt(1,a);
                ps.setString(2,equi);
                ps.executeUpdate();
                show();

            } catch (Exception ex) 
            {
                
            }
        }
        else if(n==2)
        {
            try 
            {
                System.out.print("Enter number of item: ");
                int a = s.nextInt();
                String q2="update equipment set taken=taken-? where equi_name=?";
                PreparedStatement ps=con.prepareStatement(q2);
                ps.setInt(1,a);
                ps.setString(2,equi);
                ps.executeUpdate();

            } catch (Exception ex) 
            {
                
            }
        }
    }
    
    void addnew_equi()
    {
        System.out.print("Enter number of equipments you want to enter: ");
        int n=s.nextInt();
        for(int i=0;i<n;i++)
        {
            String ename;
            int eid,tqty;
            System.out.print("Enter Equipment name: ");
            ename=s.next();
            System.out.print("Enter Equipment Id: ");
            eid=s.nextInt();
            System.out.print("Enter Quantity available: ");
            tqty=s.nextInt();
            String q2="Insert into equipment() values(?,?,?,?)";
            try
            {
                linking();
                PreparedStatement ps=con.prepareStatement(q2);
                ps.setInt(1,eid);
                ps.setString(2,ename);
                ps.setInt(3,tqty);
                ps.setInt(4,tqty);
                ps.executeUpdate();
                System.out.println("Data Inserted");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    


    
    
}