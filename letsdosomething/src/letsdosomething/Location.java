/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package letsdosomething;
import java.util.ArrayList;
/**
 *
 * @author lnaoreto
 */
public class Location {
    public final String name;
    public String description;
    public String murderDesc;
    public static ArrayList<Location> locationList = new ArrayList<>();
    public static Location murderLocation;
    public static Location currentLocation;
    public static Location currentInvolvedLocation;
    public boolean alreadyVisitedStage1 = false;
    public boolean alreadyVisitedStage2 = false;
    public String BSclue;
    
    public Location(String n, String d){
    name = n;
    description = d;
    locationList.add(this);
    }
    
    public static void chooseMurderLocation(){
    int i = (int)Math.floor(Math.random() * ((locationList.size()-1) - 0 + 1) + 0);
    murderLocation = locationList.get(i);
    System.out.println("location of murder is set in " + murderLocation.name);
    if(Person.chosenWeapon.equals("Knife")==true){murderLocation.murderDesc = "A knife is left on the floor covered in blood, right beside the body";}
    if(Person.chosenWeapon.equals("Gun")==true){murderLocation.murderDesc = "Bullet casings are left scattered on the floor";}
    }
    
    public static void investigate(Location i){
    currentLocation = i;
    System.out.println(i.description);
    if(Person.level == 1){
        if(currentLocation==murderLocation && currentLocation.alreadyVisitedStage1 == false){
            System.out.println(murderLocation.murderDesc);
            if(Person.level == 1){
                bsClue.generateBaseClue(i);
                System.out.println(i.BSclue);
                Person.level += 1;
            }
            currentLocation.alreadyVisitedStage1 = true;
        }
    } 
    if(Person.level == 3){
    if(currentLocation==currentInvolvedLocation && currentLocation.alreadyVisitedStage2 == false){
    mysClue.generateLocationMysClue(currentLocation);
    currentLocation.alreadyVisitedStage2 = true;
    } else { mysClue.generateRandomLocationMysClue(currentLocation); currentLocation.alreadyVisitedStage2 = true;}
}
    
    }}
