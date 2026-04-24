package SchoolProject;
import java.util.*;
import java.time.*;


public class Event {
    
 ArrayList<String>Registrations;
 Queue<String>WaitList;
    
 int ID; 
 String Name;
 LocalDate date;
 LocalTime time; 
 String Location;
 int MaximumParticipants;
 
 //creating event constructor
 Event( int ID,String Name,LocalDate date,LocalTime time,String Location,int MaximumParticipants){
 this.ID=ID;
 this.Name=Name;
 this.date=date;
 this.time=time;
 this.Location=Location;
 this.MaximumParticipants=MaximumParticipants;
         
 //create new register list and waitlist for every event, 
 //so each event get its own register and waitlist
 Registrations=new ArrayList<String>();
 WaitList=new LinkedList<>();
 
 
 }
 






 
    
}
