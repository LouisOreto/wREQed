/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package letsdosomething;

/**
 *
 * @author lnaoreto
 */
public class bsClue extends Clues{
    public static Location connectedLocation;
    /*1: Connected Locations Clue
      2: Weapon Evidence
      3: Event Happening
    */
    public static void generateBaseClue(Location i){
    if(i == Location.murderLocation){
    int a = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
    switch(a){
        case 1:
            int b = (int)Math.floor(Math.random() * ((Location.locationList.size()-1) - 0 + 1) + 0);
            description = "There are footsteps trailing out of this room towards " + Location.locationList.get(b).name;
            Location.currentInvolvedLocation = Location.locationList.get(b);
            break;
        case 2:
            description = "You notice stab marks on the victim's body, with blood trails leading out the door";
            break;
        case 3:
            description = "Posters are plastered on the walls talking about an event at SHB";
            break;
    } i.BSclue = description;
    }
    else{
    int a = (int)Math.floor(Math.random() * (3 - 1 + 1) + 1);
    switch(a){
        case 1:
            int b = (int)Math.floor(Math.random() * ((Location.locationList.size()-1) - 0 + 1) + 0);
            description = "There are footsteps trailing out of this room towards " + Location.locationList.get(b).name;
            Location.currentInvolvedLocation = Location.locationList.get(b);
            break;
        case 2:
            description = "Someone's wallet is hidden here";
            break;
        case 3:
            description = "Posters are plastered on the walls talking about an event at SHB";
            break;
    }
    }
    }
}
