/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package letsdosomething;
import java.util.ArrayList;
/**
 *
 * @author lnaoreto
 */
public class wREQed {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person John = new Person("John");
        Person Wilbur = new Person("Wilbur");
        Person Joshua = new Person("Joshua");
        Person Louis = new Person("Louis");
        Person Rafa = new Person("Rafa");
        Person JJ = new Person("JJ");
        Person Teal = new Person("Teal");
        Person Indigo = new Person("Indigo");
        Person Velvet = new Person("Velvet");
        Location SHB = new Location("SHB", "This is a corridor");
        Location Edge = new Location("Edge Classroom", "This is a classroom with a bunch of computers");
        Location Kitchen = new Location("Kitchen", "This place has food");
        Location Blob = new Location("Blob", "Tables line the room, and in front, stalls that serve food");
        Location Flob = new Location("Flob","An open room adjacent to the admin building, people hang out here");
        Location Admin = new Location("Admin Building", "A bunch of office rooms filled with personnel");
        Location ASTB = new Location("ASTB", "This is a yet another corridor");
        Location Field = new Location("Field", "An open space");
        Location Gym = new Location("Gym", "This place has many courts and a pool");
        
        //Sometimes, these scenarios will not function and cause the code to error and exit, giving an exception that the input i is null
        //This is due to the fact the exception defined for this problem hasnt been put yet. However, there is currently a hot fix that 
        //Mostly fixes it, however doesn't encourage seamless connection of events, so this hot fix will be replaced soon
        
        //Scenario 1:
        Person.randomizeRelationships(); //program randomizes enemies and friends of each person
        Person.pickMurderer(); 
        Location.chooseMurderLocation();
        Person.Interrogate(Wilbur);
        Location.investigate(Location.murderLocation);
        Person.Interrogate(Person.Deceased.friend);
        Person.Interrogate(Person.murderer);
        Location.investigate(Location.currentInvolvedLocation);
        Person.Interrogate(Person.currentPersonInvolved1);
        Person.Interrogate(Person.currentPersonInvolved2);
        Person.Interrogate(Person.murderer);
        Person.Accuse(Person.murderer);
        
        Person.reset();
        
        //Scenario 2:
        Person.randomizeRelationships();
        Person.pickMurderer();
        Location.chooseMurderLocation();
        Person.Interrogate(Joshua);
        Location.investigate(Location.murderLocation);
        Person.Interrogate(Person.Deceased.friend);
        Person.Interrogate(Person.murderer);
        Location.investigate(Location.currentInvolvedLocation);
        Person.Interrogate(Person.currentPersonInvolved1);
        Person.Interrogate(Person.currentPersonInvolved2);
        Person.Interrogate(Person.murderer);
        Person.Accuse(Person.murderer);
        
        Person.reset();
        
        //Scenario 3:
        Person.randomizeRelationships();
        Person.pickMurderer();
        Location.chooseMurderLocation();
        Person.Interrogate(John);
        Location.investigate(Location.murderLocation);
        Person.Interrogate(Person.Deceased.friend);
        Person.Interrogate(Person.murderer);
        Location.investigate(Location.currentInvolvedLocation);
        Person.Interrogate(Person.currentPersonInvolved1);
        Person.Accuse(Person.murderer.friend);
    }
    
}

/*Randomizers:
Person: (int)Math.floor(Math.random() * ((Person.PersonList.size()-1) - 0 + 1) + 0)
Alive Person: (int)Math.floor(Math.random() * ((Person.AliveList.size()-1) - 0 + 1) + 0)
Location: (int)Math.floor(Math.random() * ((Location.locationList.size()-1) - 0 + 1) + 0)
Number: (int)Math.floor(Math.random() * (max - min + 1) + min);
*/