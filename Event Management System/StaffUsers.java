package SchoolProject;
import java.util.*;
import java.time.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;



public class StaffUsers extends User{
    public static Scanner userInput=new Scanner(System.in);
    
   
//method for creating event
    
  void createEvents(ArrayList<Event>arr){
      DateTimeFormatter Dateformat=DateTimeFormatter.ofPattern("dd-MM-yyyy");
      DateTimeFormatter timeFormat=DateTimeFormatter.ofPattern("HH:mm");
      LocalDate Date=null;
      LocalTime Time=null;
  
    System.out.print("Enter Event ID: ");
    int eventID=userInput.nextInt();
    
    userInput.nextLine();
    for(int i=0; i<arr.size();i++){
    if(arr.get(i).ID==eventID){ //check if event already exists to prevent duplicates
    System.out.println("Event already exists");
    return;
    }
    }
    
    System.out.print("Enter Name: ");
    String name=userInput.nextLine();
    
    
    String date="";
    while(Date==null){ //force user to enter correct date format
    System.out.print("Enter date DD-MM-YY: ");
    date=userInput.nextLine();
    try{
        
    Date=LocalDate.parse(date,Dateformat);
    
    }catch(DateTimeParseException e){
    System.out.println("Invalid date format");
    }
    }
    
   
    String time="";
    while(Time==null){ //force user to enter correct time format
    System.out.print("Enter time HH:mm: ");
    time=userInput.nextLine();
    try{
    Time=LocalTime.parse(time,timeFormat);
    
    }catch(DateTimeParseException e){
    System.out.println("Invalid time format");
    }
    }
    
    System.out.print("Enter location: ");
    String location=userInput.nextLine();
    
    System.out.print("Enter maximum participants: ");
    int maxParticipants=userInput.nextInt();
    
    Event event=new Event(eventID,name,Date,Time,location,maxParticipants);
    arr.add(event);
    
    System.out.println("Even created successfully");
    
    //write event to file
    
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
" | WaitList= " + arr.get(i).WaitList   + "\n"
);  
        }
    
        
    }catch(IOException e){
    System.out.println("Error saving event");
    }
    
  }
  
    
  //function to update event details
void updateEvent(ArrayList<Event>arr){
    DateTimeFormatter Dateformat=DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter timeFormat=DateTimeFormatter.ofPattern("HH:mm");
    LocalDate Date=null;
    LocalTime Time=null;
     
    int eventIndex=-1;
    System.out.print("Enter event ID to update ");
    
    int eventID=userInput.nextInt();
     userInput.nextLine();
     
     //check if eventID exists
    for(int i=0; i<arr.size();i++){
    if(arr.get(i).ID==eventID){
       eventIndex=i;//save event index
        break;
    
    }
    }
    if (eventIndex == -1) {
    System.out.println("Event not found");
    return;
}
    
    
    System.out.print("Enter new name (leave blank to skip): ");
    String newName=userInput.nextLine();
   
    //force user to enter correct Date format
     String newDate="";
    while(Date==null){
    System.out.print("Enter new date (leave blank to skip): ");
    newDate=userInput.nextLine();
    if(newDate.trim().isEmpty()){
        break;} //allow user to skip the field
    
    try{
    Date=LocalDate.parse(newDate,Dateformat);
    
    }catch(DateTimeParseException e){
    System.out.println("Invalid date format");
    }
    
    }
    //force user to enter correct Time format 
    String newTime="";
    while(Time==null){
    System.out.print("Enter new time (leave blank to skip): ");
    newTime=userInput.nextLine();
    if(newTime.trim().isEmpty()){break;}//allow user  to skip field
    
    try{
    Time=LocalTime.parse(newTime,timeFormat);
    }catch(DateTimeParseException e){
    System.out.println("Invalid format");
    }
    
    
    }
    
    System.out.print("Enter new location (leave blank to skip): ");
    String newLocation=userInput.nextLine();
    
    System.out.print("Enter new maximum participants (leave blank to skip): ");
    String newMaxParticipants=userInput.nextLine();
    
    
    
    //updating Event array
    if(!newName.trim().isEmpty()){
        arr.get(eventIndex).Name=newName;
    }
    if(!newDate.trim().isEmpty()){
        arr.get(eventIndex).date=Date;
    }
    if(!newTime.trim().isEmpty()){
        arr.get(eventIndex).time=Time;
    }
    if(!newLocation.trim().isEmpty()){
        arr.get(eventIndex).Location=newLocation;
    }
    if(!newMaxParticipants.trim().isEmpty()){
        int maxParticipants=Integer.parseInt(newMaxParticipants);
        arr.get(eventIndex).MaximumParticipants=maxParticipants;
    }
    
    
           //takes updated array and update the file
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
    
    
    System.out.println("Event Updated succcesful");
    
} 
//method to cancel an event
@Override
void cancelEvent(ArrayList<Event>arr){
    System.out.print("Enter event ID: ");
    int eventID=userInput.nextInt();
    
  boolean found=false;  
for(int i=0 ;i<arr.size();i++){
if(arr.get(i).ID ==eventID){ 
 arr.remove(i);//remove the event provided by the staff
 found=true;
 break;
}

}
if(!found){
System.out.println("Event not found");
}
//update the file
try(FileWriter myFile=new FileWriter("Events")){
for(int i=0; i<arr.size();i++){
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

}
catch(IOException e){System.out.println("Error updating event");}
      
}


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
   //event1 and event2 are temporary variables acting as events. The we access the fields 
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



void viewAllParticipants(ArrayList<Event>arr){

    //print list of registered participants
System.out.println("All Registered Particippants");

 for(int i=0;i<arr.size();i++){
     System.out.println("Event:"+arr.get(i).ID);
      for(int j=0; j<arr.get(i).Registrations.size(); j++){
        System.out.print("Registered:" + arr.get(i).Registrations.get(j));
        System.out.println("\n");
        }
      System.out.println("\n");
 }
System.out.println(" - - -  -  - -  - - -  - -  -  - - -  - -");


//print waitlisted participants
System.out.println("All Waitlisted Particippants");

 for (int i = 0; i < arr.size(); i++) {
    System.out.println("Event ID: " + arr.get(i).ID);

    for (String student : arr.get(i).WaitList) {
        System.out.println("WaitListed:" + student);
    }
    System.out.println("\n");
}
 

}


void loadEvents(ArrayList<Event>arr){
DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

//Tis function read from file and load to events Arraylist
try(BufferedReader br=new BufferedReader(new FileReader("Events"))){
String line;
while((line=br.readLine())!=null){

    if(line.trim().isEmpty()) continue;
//Where we see pipe(|) we split the line into parts
//we take each part value[1] and trim space then put into object
String[]parts=line.split("\\|");


 if (parts.length <8) {
                continue; // skip the line if the parts are missing
       }

//Remove the (=)

String[] idParts = parts[0].trim().split("=");
String[] nameParts = parts[1].trim().split("=");
String[] dateParts = parts[2].trim().split("=");
String[] timeParts = parts[3].trim().split("=");
String[] locationParts = parts[4].trim().split("=");
String[] maxParts = parts[5].trim().split("=");
String[] regParts = parts[6].trim().split("=");
String[] waitParts = parts[7].trim().split("=");

// used this line for extra safety coz i kept getting index error
//so this line makes sure that the load method dont collect event with parts that are < 2( missing fields)
if(idParts.length < 2 || nameParts.length < 2 || dateParts.length < 2 ||
   timeParts.length < 2 || locationParts.length < 2 || maxParts.length < 2 ||
   regParts.length < 2 || waitParts.length < 2){
    continue;
}

//we get the values at index 1 from  parts warrays
int ID=Integer.parseInt(idParts[1].trim());
String Name=nameParts[1].trim();
LocalDate Date=LocalDate.parse(dateParts[1].trim());//theres error here
LocalTime Time=LocalTime.parse(timeParts[1].trim());
String Location=locationParts[1].trim();
int MaxParticipants=Integer.parseInt(maxParts[1].trim());



Event event=new Event(ID,Name,Date,Time,Location,MaxParticipants);

//We remove the the square brackets and replace them with empty string
String Registrations = regParts[1].trim().replace("[", "").replace("]", "");
String WaitList = waitParts[1].trim().replace("[", "").replace("]", "");

//Rebuild registrations
//We load the registered students from file
if(!Registrations.equals("0") && !Registrations.isEmpty()){

String[] regStudents=Registrations.split(",");
     for (String r : regStudents) {
                event.Registrations.add(r.trim());
        }


}
//We load the wait students from file
                
    String[] waitStudents=WaitList.split(",");
    
if(!WaitList.equals("0") && !WaitList.isEmpty()){


     for (String w : waitStudents) {
                event.WaitList.add(w.trim());
        }

}
 
arr.add(event);
}
}catch(IOException e){System.out.println("File not found");}

}

        
             
    
}
    

