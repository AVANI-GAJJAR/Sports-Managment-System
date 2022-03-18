package project.team1;
import java.io.*;
import java.sql.*;
import java.util.*;
import static project.team1.jdbclink.con;
import static project.team1.jdbclink.linking;

class admin extends student_function
{
    Scanner scan=new Scanner(System.in);
    Events e=new Events();
    void student()//admin student function
    {
        int ch=0;
        while(ch!=4)
        {
            System.out.println("--------------Student List--------------");
            System.out.println("\n1.\tAdd New Registration"+"\n2.\tDetail"+"\n3.\tRemove"+"\n4.\tExit");
            System.out.print("Enter your choice:"); 
            ch=scan.nextInt();//taking input from user 
            switch(ch)
            {
                case 1:writing();//writing in file 
                        break;
                case 2:reading();//reading from file
                        break;
                case 3:deleting();//deleting in file
                        break;
                case 4:break;
                default:System.out.println("WRONG CHOICE");//wrong choice alternative
                        break;//exiting the program 
            }
        }
    }
    void equipment()
    {
        Equipment_function ex= new Equipment_function();
        ex.show();
        System.out.println("\n\n\n|If you want to update existing data then please select update\n|If you want to enter new value please select add\n");
        int ch=0;
        while(ch!=4)
        {
            System.out.println("--------------Equipment List--------------");
            System.out.println("1.\tAdd Equipments"+"\n2.\tAvailable equipments"+"\n3.\tUpdate"+"\n4.\tExit");
            System.out.print("Enter your choice:");
            ch=scan.nextInt();
            switch(ch)
            {
                case 1:ex.addnew_equi();
                    break;
                case 2:ex.show();
                    break;
                case 3:ex.update();
                    break;
                case 4:break;
                default:System.out.println("WRONG CHOICE");
                break;
            }
        }
    }
    void events()
    {
        int ch=0;
        while(ch!=3)
        {
            System.out.println("--------------Event List--------------");
            System.out.println("1.\tAdd Events"+"\n2.\tShow Events"+"\n3.\tExit");
            System.out.print("Enter your choice:");
            ch=scan.nextInt();
            switch(ch)
            {
                case 1:e.addnew_event();
                    break;
                case 2:e.show();
                    break;
                case 3:
                    break;
                default:System.out.println("WRONG CHOICE");
                break;
            }
        }
    }
    void achivements()
    {
        Achivements ac=new Achivements();
        int ch=0;
        while(ch!=3)
        {
            System.out.println("--------------Achivement List--------------");
            System.out.println("1.\tAdd Achivements"+"\n2.\tShow Achivements"+"\n3.\tExit");
            System.out.print("Enter your choice:");
            ch=scan.nextInt();
            switch(ch)
            {
                case 1:ac.add();
                    break;
                case 2:ac.show();
                    break;
                case 3:
                    break;
                default:System.out.println("WRONG CHOICE");
                break;
            }
        }
    }
    void details()
        {
            Admindetails aa=new Admindetails();
            int ch=0;
            while(ch!=4)
            {
                System.out.println("--------------Admin List--------------");
                System.out.println("1.\tAdd new admin"+"\n2.\tShow admin details"+"\n3.\tUpdate Details"+"\n4.\tExit");
                System.out.print("Enter your choice:");
                ch=scan.nextInt();
                switch(ch)
                {
                    case 1:aa.addnew();
                        break;
                    case 2:aa.show();
                        break;
                    case 3:aa.update();
                        break;
                    case 4:
                        break;
                    default:System.out.println("WRONG CHOICE");
                    break;
                }
            }
      }
    admin()
    {
        int ch=0;
        while(ch!=6)
        {
            System.out.println("\n\n----------------------------------------------------------------------------");
            System.out.println("\t\t\t\t Admin Menu");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("1.\tStudent\n" +"2.\tEquipments\n" +"3.\tUpcoming events\n" +"4.\tAdmin details\n" +"5.\tAchievements\n" +"6.\tExit");
            System.out.print("Enter your choice:");
            ch=scan.nextInt();
            switch(ch)
            {
                case 1:student();
                        break;
                case 2:equipment();
                        break;
                case 3:events();
                        break;
                case 4:details();
                        break;
                case 5:achivements();
                        break;
                case 6:break;
                default: System.out.println("WRONG CHOICE");
            }
        }
    }
}
class student 
{
    Events e =new Events();
    Achivements ac=new Achivements();
    Equipment_function ex= new Equipment_function();
    Admindetails aa=new Admindetails();
    Scanner scan=new Scanner(System.in);
    void events1()
    {
        int ch=0;
        
        while(ch!=4)
        {
            System.out.println("1.\tShow Events"+"\n2.\tSort according to Event Name"+"\n3.\tSort according type of event"+"\n4.\tExit");
            System.out.print("Enter your choice:");
            ch=scan.nextInt();
            switch(ch)
            {
                case 1:e.show();
                    break;
                case 2:e.sortbydate();
                    break;
                case 3:e.sortbyvenue();
                    break;
                case 4:
                    break;
            }
        }
    }
  
    student()
    {
        Scanner scan=new Scanner(System.in);
        int ch=0;
        while (ch!=6)
        {
            System.out.println("\n\n----------------------------------------------------------------------------");
            System.out.println("\t\t\t\t Student Menu");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("1.\tContact Details of admins\n" +"2.\tEvents List\n" +"3.\tAchievements\n" +"4.\tSports available(indoor/outdoor)\n" +"5.	Equipments\n" +"6.\tExit\n");
            System.out.println("Enter Your choice:");
            ch=scan.nextInt();
            switch(ch)
            {
                case 1:aa.show();
                        break;
                case 2:events1();
                        break;
                case 3:ac.show();
                        break;
                case 4:e.sport_details();
                        break;
                case 5:ex.show();
                        break;
                case 6:break;
                default: System.out.println("WRONG CHOICE");
        }
        }
    }
}
class login 
{
    Scanner scan=new Scanner(System.in);
    void admin_login()
    {
        String uname,passwd;
        System.out.print("Enter Username\n(only in caps):");
        uname=scan.next();
        System.out.print("Enter Password:");
        passwd=scan.next();
        try
        {
            File f=new File("C:\\Users\\avani\\OneDrive\\Desktop\\SEMESTER 3\\OOP Project\\admin_login.txt");
            FileReader fr=new FileReader("C:\\Users\\avani\\OneDrive\\Desktop\\SEMESTER 3\\OOP Project\\admin_login.txt");
            BufferedReader br=new BufferedReader(fr);
            if(f.exists())//checking if the file exist
            {
                String s;
                String[] words ;
                int count=0;
                while((s=br.readLine())!=null)   //Reading Content from the file
                {
                    words=s.split(" ");  //Split the word using space
                    for (String word : words) 
                    {
                        if (uname.equals(word)&&passwd.equals("123"))   //Search for the given word
                        {
                            System.out.println("\n\nWelcome "+uname);
                            admin ad=new admin();   
                            count++;
                        }
                    }
                    if(count==0)
                    {
                        System.out.println("Failed to login!!");
                    }
                }
            }
        }
        catch(IOException e)
        {
            System.out.print(e.getMessage());
        }
    }

    public void student_login()
    {
        String enroll_no;
        System.out.print("Enter Your Enrollment:");
        enroll_no=scan.next();
        try
        {
            File f=new File("C:\\Users\\avani\\OneDrive\\Desktop\\SEMESTER 3\\OOP Project\\student_login.txt");
            FileReader fr=new FileReader("C:\\Users\\avani\\OneDrive\\Desktop\\SEMESTER 3\\OOP Project\\student_login.txt");
            BufferedReader br=new BufferedReader(fr);
            if(f.exists())
            {
                String s;
                String[] roll ;
                int count=0;
                while((s=br.readLine())!=null)   //Reading Content from the file
                {
                    roll=s.split(" ");  //Split the word using space
                    for (String word : roll) 
                    {
                        if (word.equals(enroll_no))   //Search for the given enrollment
                        {
                            System.out.println("\n\nWelcome "+enroll_no);
                            student st=new student();   
                            count++;
                        }

                    }
                    if(count==0)
                    {
                        System.out.println("Failed to login!!");
                    }
                }
            }
        }
        catch(IOException e)
        {
            System.out.print(e.getMessage());
        }
    }
}
public class ProjectTeam1 
{
    private static final Connection NULL=null;
    public static void main(String[] args) 
    {
        Scanner scan=new Scanner(System.in);
        login log=new login();// creating instance of login
        System.out.println("WELCOME TO SPORTS CORNER OF GANPAT UNIVERSITY\n");
        System.out.println("1.Admin \n2.Student");
        System.out.print("Enter choice:");
        int ch=scan.nextInt();
        switch(ch)
        {
            case 1:log.admin_login();
            break;
            case 2:log.student_login();
            break;
            default:System.out.println("Enter correct choice");
            break;
        }
    }   
}