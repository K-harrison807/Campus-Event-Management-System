package SchoolProject;
import java.time.*;
import java.util.*;

public class Main {
    public static ArrayList<Event>events=new ArrayList<Event>();//array for events
  
    public static Scanner userInput=new Scanner(System.in);

    
    public static void main(String[]args){
         User u;
         StaffUsers staff=new StaffUsers();
         staff.loadEvents(events); 
         StudentUsers student=new StudentUsers();
         
         
         
         
         boolean runLoop=true;
         while(runLoop){
         System.out.println("Welcome to Richfiled Event Mangement System");
         System.out.println("1.Student");
         System.out.println("2.Staff");
         System.out.println("Select your Role: ");
         
         int role=userInput.nextInt();
         
         userInput.nextLine();
         if(role==1){
             u=new StudentUsers();
             while(runLoop){
         
            System.out.println("1.View Events");
            System.out.println("2.Register for Event");
            System.out.println("3.Cancel");
            System.out.println("4.Search Events");
            System.out.println("5.View Registration Status");
            System.out.println("6.Exit");
            int choice=userInput.nextInt();
            switch(choice){//student options
            
                case 1:u.viewEvents(events);
                break;
                case 2:student.registerEvent(events);
                break;
                case 3:u.cancelEvent(events);
                break;
                case 4:student.searchEvent(events);
                break;
                case 5:student.viewRegisStatus(events);
                break;
                case 6:System.out.println("Exiting Student menu . . . . . ");
                        runLoop=false;
                 break;
                default:System.out.println("Invalide option");
            
            }
             
         }
         }
         
         else if(role==2){
         u=new StaffUsers();
         while(runLoop){    //staff options
            System.out.println("1.Create Event");
            System.out.println("2.Update Event");
            System.out.println("3.Cancel Event");
            System.out.println("4.View Events");
            System.out.println("5.View Registered & Waitlisted participants");
            System.out.println("6..Exit");
            int choice=userInput.nextInt();
             switch(choice){
            
                case 1:staff.createEvents(events);
                break;
                case 2:staff.updateEvent(events);
                break;
                case 3:u.cancelEvent(events);
                break;
                case 4:u.viewEvents(events);
                break;
                case 5:staff.viewAllParticipants(events);
                break;
                case 6:System.out.println("Exiting Staff  menu . . . . . ");
                        runLoop=false;
                 break;
                default:System.out.println("Invalide option");
            
            }
         
         }
         }
         else{System.out.println("Invalid option");}
         
         
         }
         
         
         
         
         
         
         }
           
        
                
                
                
                
                
                
                
                
                
                
                
               
        
}

