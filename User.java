package SchoolProject;
import java.util.*;

//student and staff inherit from this class
//polymorphism in act
public abstract class User {
    
   abstract void viewEvents(ArrayList<Event>arr);
           
   abstract void cancelEvent(ArrayList<Event>arr);
}
