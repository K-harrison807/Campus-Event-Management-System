package SchoolProject;
import java.util.*;
import java.time.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;




public class  StudentUsers extends User {
    public static Scanner userInput=new Scanner(System.in);
  
   
    @Override
  void viewEvents(ArrayList<Event>arr){  
       System.out.println("Sort by: 1.Name  2.Date  3.None");
    int option=userInput.nextInt();
    userInput.nextLine();
    
     if(option !=1 && option!=2 && option !=3){
        System.out.println("Invalid option");
        return;}

   //sort by name
   //compares two events
   //then print sorted array
   //event1 and event2 are temporary variables acting as events. Then we access the fields 
    if(option==1){
  Collections.sort(arr,(event1,event2)->event1.Name.compareToIgnoreCase(event2.Name));
    
    for(int i=0;i<arr.size();i++){
        System.out.println(
"ID: " + arr.get(i).ID +
" | Name: " + arr.get(i).Name +
" | Date: " + arr.get(i).date +
" | Time: " + arr.get(i).time +
" | Location: " + arr.get(i).Location +
" | Registrations: " + arr.get(i).Registrations.size() +
" | WaitList: " + arr.get(i).WaitList.size() + "\n"
); 
        }
    
    }
    //sort by date
  if(option==2){
  Collections.sort(arr,(eventDate1,eventDate2)->eventDate1.date.compareTo(eventDate2.date));
   for(int i=0;i<arr.size();i++){
        System.out.println(
"ID: " + arr.get(i).ID +
" | Name: " + arr.get(i).Name +
" | Date: " + arr.get(i).date +
" | Time: " + arr.get(i).time +
" | Location: " + arr.get(i).Location +
" | Registrations: " + arr.get(i).Registrations.size() +
" | WaitList: " + arr.get(i).WaitList.size() + "\n"
); 
        }
  
  }  
    
    
    if(option==3){
    for(int i=0;i<arr.size();i++){
        System.out.println(
"ID: " + arr.get(i).ID +
" | Name: " + arr.get(i).Name +
" | Date: " + arr.get(i).date +
" | Time: " + arr.get(i).time +
" | Location: " + arr.get(i).Location +
" | Registrations: " + arr.get(i).Registrations.size() +
" | WaitList: " + arr.get(i).WaitList.size() + "\n"
); 
        }
   
    }
}
  
  
void registerEvent(ArrayList<Event> arr){

    System.out.print("Enter event ID: ");
    int eventID = userInput.nextInt();
    userInput.nextLine();

    int eventIndex = -1;

    // find event
    for(int i = 0; i < arr.size(); i++){
        if(arr.get(i).ID == eventID){
            eventIndex = i;
            break;
        }
    }

    if(eventIndex == -1){
        System.out.println("Event not found");
        return;
    }
    
    System.out.print("Enter student ID: ");
    String studentID = userInput.nextLine();

    Event event = arr.get(eventIndex);

    // check if already registered
    for(String s : event.Registrations){
        if(s.equals(studentID)){
            System.out.println("Student already registered");
            return;
        }
    }

    // check if registartion size is < than max participants
    //if its < then add student to reigistrtion
    if(event.Registrations.size() < event.MaximumParticipants){
        event.Registrations.add(studentID);
        System.out.println("S"+studentID + " registered for event: " + event.ID);
    } 
    else { //if its registration is full, add to waitlist
        event.WaitList.add(studentID);
        System.out.println("Event full S"+studentID + " added to waitlist for event: " + event.ID);
    }

    // save updated events to file
    try(FileWriter myFile = new FileWriter("Events")){
        for(int i = 0; i < arr.size(); i++){
             myFile.write(
"ID= " + arr.get(i).ID +
" | Name= " + arr.get(i).Name +
" | Date= " + arr.get(i).date +
" | Time= " + arr.get(i).time +
" | Location= " + arr.get(i).Location +
" | MaxParticipants= " +arr.get(i).MaximumParticipants +
" | Registrations= " + arr.get(i).Registrations +
" | WaitList= " + arr.get(i).WaitList + "\n"
);  
        }

        
    } catch(Exception e){
        System.out.println("Error saving file");
    }
}
  
  @Override
  void cancelEvent(ArrayList<Event>arr){
      
  System.out.print("Enter event ID: ");
  int eventID=userInput.nextInt();
  userInput.nextLine();
  System.out.print("Cancel on 1.Registration:   2. Waitlist: ");
  int option=userInput.nextInt();
  userInput.nextLine();
  
  if(option !=1 && option!=2){
  System.out.println("Invalid option");
  return;
  }
  
  int eventIndex = -1;

    // find event
    for(int i = 0; i < arr.size(); i++){
        if(arr.get(i).ID == eventID){
            eventIndex = i;
            break;
        }
    }

    if(eventIndex == -1){
        System.out.println("Event not found");
        return;
    }
  
  
  System.out.print("Enter student ID: ");;
  String studentID=userInput.nextLine();
  
if(option==1){
  boolean found=false;
  for(int i = 0; i < arr.get(eventIndex).Registrations.size(); i++){

    if(arr.get(eventIndex).Registrations.get(i).equals(studentID)){

        arr.get(eventIndex).Registrations.remove(i); // remove student

        if(!arr.get(eventIndex).WaitList.isEmpty()){//check if wait list is not empty
            String promoted = arr.get(eventIndex).WaitList.poll();// get the first person in the wait list
            arr.get(eventIndex).Registrations.add(promoted);//move the person to registration list
            System.out.println("Registration cancelled. " + promoted + " promoted from waitlist");
        }else{
            System.out.println("Registration cancelled.");
        }

        found = true;
        break;
    }
}
}
if(option==2){
    boolean found = false;

    for(String s : arr.get(eventIndex).WaitList){
        if(s.equals(studentID)){
            arr.get(eventIndex).WaitList.remove(s);
            System.out.println("Removed from waitlist.");
            found = true;
            break;
        }
    }

    if(!found){
        System.out.println("Student not found in waitlist");
    }

}
  //update file
  try(FileWriter myFile=new FileWriter("Events")){
        for(int i=0;i<arr.size();i++){
        myFile.write(
"ID= " + arr.get(i).ID +
" | Name= " + arr.get(i).Name +
" | Date= " + arr.get(i).date +
" | Time= " + arr.get(i).time +
" | Location= " + arr.get(i).Location +
" | MaxParticipants= " +arr.get(i).MaximumParticipants +
" | Registrations= " + arr.get(i).Registrations +
" | WaitList= " + arr.get(i).WaitList + "\n"
);   
        }
    
        
    }catch(IOException e){
    System.out.println("Error saving event");
    }
  }
 
  //Search method
  void searchEvent(ArrayList<Event>arr){
      boolean match=false;
      
      System.out.println("Enter Event Name or Date(yyyy-MM-dd): ");
      String search=userInput.nextLine();
      String searchEvent=search.trim();
      
      if(searchEvent.isEmpty()){
      System.out.println("No events match your search");
      return;
      }
      
      //search by name(full or partial)
      for(int i=0; i<arr.size();i++){
          if(arr.get(i).Name.contains(searchEvent)){
           System.out.println("ID: " + arr.get(i).ID +
            " | Name: " + arr.get(i).Name +
            " | Date: " + arr.get(i).date +
            " | Time: " + arr.get(i).time +
            " | Location: " + arr.get(i).Location +
            " | Registrations: " + arr.get(i).Registrations.size() +
            " | WaitList: " + arr.get(i).WaitList.size() + "\n");
           match=true;
           return;
          }
          }
      
    
      
      for(int i = 0; i < arr.size(); i++){
    if(arr.get(i).date.toString().equals(searchEvent)){
         System.out.println("ID: " + arr.get(i).ID +
            " | Name: " + arr.get(i).Name +
            " | Date: " + arr.get(i).date +
            " | Time: " + arr.get(i).time +
            " | Location: " + arr.get(i).Location +
            " | Registrations: " + arr.get(i).Registrations.size() +
            " | WaitList: " + arr.get(i).WaitList.size() + "\n");
         match=true;
         return;   
    }
}
      if(!match){System.out.println("No events match your search");}    
     
  }
      
  
 //View their registration status (Registered or Waitlisted)
  
  void viewRegisStatus(ArrayList<Event>arr){
      
      System.out.print("Enter studentID: ");
      String studentID=userInput.nextLine();
      
      System.out.print("Enter Event ID; ");
      int eventID=userInput.nextInt();
      userInput.nextLine();
      
      int eventIndex=-1;
      
      
      //check student in registrations
      for(int i=0; i<arr.size();i++){
 
          if(arr.get(i).ID==eventID){
            eventIndex=i;
            break;
          }
      }
      
           if(eventIndex==-1){
      System.out.println("Event not found");
      return;
           }
           
           
           
       //checks student in registration list    
      for(int j=0; j<arr.get(eventIndex).Registrations.size();j++){
       if(arr.get(eventIndex).Registrations.get(j).equals(studentID)){
           System.out.println("Status: Registed");
           return;
       }
      }
      //checks student in wait list
       for(String s:arr.get(eventIndex).WaitList){
       if(s.equals(studentID)){
       System.out.println("....You are on wait list....");
       return;
       }
       }
       System.out.println("You are not registered neither on waitlist");
      }
      
       
          
}
   
  
  

  
  


   
   
  
  
  
  
   
  
  
  
  
  
  
  
  
  

    

