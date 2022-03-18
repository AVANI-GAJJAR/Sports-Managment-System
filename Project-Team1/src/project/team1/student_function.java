package project.team1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class student_function
{
    
    String name,branch,gender,dob;
    long enroll,pnum;
    Scanner scan=new Scanner(System.in);//instance of scanner class
    String r_get()// adding new registration
    {
        //taking input from admin
        System.out.print("Enter your Name: ");
        name=scan.next();
        System.out.print("Enter your Enrollment Number: ");
        enroll=scan.nextLong();
        System.out.print("Enter your Branch: ");
        branch=scan.next();
        System.out.print("Enter your Gender: ");
        gender=scan.next();
        System.out.print("Enter your Date of birth: ");
        dob=scan.next();
        System.out.print("Enter your Contact Detail(ph. no.): ");
        pnum=scan.nextLong();
        //storing it in a single string
        String add_r="\n"+name+"\t\t"+enroll+"\t"+branch+"\t"+gender+"\t"+dob+"\t"+pnum+"\n";
        return add_r;
    }
    void writing()//writing in text file function
    {
        try 
        {
            FileWriter fw= new FileWriter("C:\\Users\\avani\\OneDrive\\Desktop\\SEMESTER 3\\OOP Project\\add_registration.txt",true);
            String temp="";
            fw.write(r_get());       //writing all data inserted by user in file
            fw.close();
            System.out.println("Successfully wrote to the file.");
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
        }
    }
   void reading()//reading from text file
   {
       try
       {
           FileReader fr=new FileReader("C:\\Users\\avani\\OneDrive\\Desktop\\SEMESTER 3\\OOP Project\\add_registration.txt");
           BufferedReader br=new BufferedReader(fr);
           String s;
           String[] words;
           System.out.println("NAME\t\tENROLLMENT\tBRANCH\tGENDER\tDATE OF BIRTH\tPHONE NUMBER\n");
           while((s=br.readLine())!=null)   //Reading Content from the file
            {
                System.out.println(s);//printing contect line by line from file
            }
       }
       catch(IOException ex)
       {
           
       }
   }
   void deleting()
   {
       try
       {    
           File file = new File("C:\\Users\\avani\\OneDrive\\Desktop\\SEMESTER 3\\OOP Project\\add_registration2.txt");
           FileReader fr=new FileReader("C:\\Users\\avani\\OneDrive\\Desktop\\SEMESTER 3\\OOP Project\\add_registration.txt");
           BufferedReader br=new BufferedReader(fr);
           FileWriter fw= new FileWriter(file, true);//file will append the data
           String s;
           String[] words;
           String roll;
           Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+"C:\\Users\\avani\\OneDrive\\Desktop\\SEMESTER 3\\OOP Project\\add_registration.txt");
           System.out.println("Enter Enrollment to delete the record: ");
           roll=scan.next();
           //System.out.println("NAME\t\tENROLLMENT\tBRANCH\tGENDER\tDATE OF BIRTH\tPHONE NUMBER\n");
           while((s=br.readLine())!=null)   //Reading Content from the file
                {
                    int count=0; 
                    String[] Mywords =s.split("\\s");//spiliting words
                    for (String word : Mywords) 
                    {
                        if (word.equals(roll))   //Search for the given word
                        {
                            //System.out.println("i am here2"); 
                            count++;
                            break;
                        }
                    }
                    if(count==0)
                    {
                       fw.write(s);
                       fw.write(System.lineSeparator());
                    }
                    //System.out.println(s);
                }
            fw.close();
            FileReader fin = new FileReader(file);  
            FileWriter fout = new FileWriter("C:\\Users\\avani\\OneDrive\\Desktop\\SEMESTER 3\\OOP Project\\add_registration.txt",false);  
            int c;  
            while ((c=fin.read())!=-1)//it will read till end of the file  
            {  
              fout.write(c);  
            }   
            fin.close();  
            fout.close();  
            FileWriter fout2 = new FileWriter(file,false);
            fout2.close();
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+"C:\\Users\\avani\\OneDrive\\Desktop\\SEMESTER 3\\OOP Project\\add_registration.txt");
       }
       catch(IOException ex)
        {

        }

   }
}

