/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package letsdosomething;

/**
 *
 * @author lnaoreto
 */
public class albClue extends Clues{
    public static void generateFriendedVictimAlbClue(Person i){
    System.out.println("Last I saw them, " + i.friend.name + " was walking over to the kitchen to get food for the party");
    i.interrogatedStage1 = true;
    }
    
    public static void generateFriendedByVictimAlbClue(Person i){
    int f = (int)Math.floor(Math.random() * (4 - 1 + 1) + 1);
                    switch(f){
                       case 1: //about hated by victim
                        System.out.println("I heard that" + Person.Deceased.enemy.name + "hasn't been in the party ");
                        Person.Deceased.enemy.enemiedByInterrogated = true;
                        break;
                       case 2: //about hates victim
                        System.out.println("I saw " + Person.Deceased.enemiedBy.name + " go out the door a few moments after " + Person.Deceased.name + " left");
                        Person.Deceased.enemy.enemyInterrogated = true;
                        break;
                       case 3: //about hated by i
                        System.out.println("I don't think Ive seen " + i.enemy.name + " in the party");
                        i.enemy.enemiedByInterrogated = true;
                        break;
                       case 4: //about hates i
                        System.out.println("Not sure about " + i.enemiedBy.name + ", but I think something's off about them");
                        i.enemy.enemyInterrogated = true;
                        break;
                    }
                i.interrogatedStage1 = true;
                if(Location.currentInvolvedLocation == null){
            int d = (int)Math.floor(Math.random() * ((Location.locationList.size()-1) - 0 + 1) + 0);
            Location.currentInvolvedLocation = Location.locationList.get(d);
            Person.level ++;
            }
    }
    
    public static void generateMurdererAlbClue(Person i){
    if(i.enemyInterrogated == true){
                int a = (int)Math.floor(Math.random() * ((Location.locationList.size()-1) - 0 + 1) + 0);
                System.out.println("I was only heading to "+ Location.locationList.get(a).name + " to get my bag");
                Location.currentInvolvedLocation = Location.locationList.get(a);
                Person.currentPersonInvolved1 = i;
                Person.level += 1;
                i.interrogatedStage1 = true;
                } else if(i.enemiedByInterrogated == true) {
                System.out.println("Don't believe a word " + i.enemiedBy.name +" says, they're trying to trick you");
                i.interrogatedStage1 = true;
                } else if(i.interrogatedStage1 == false){
                int a = (int)Math.floor(Math.random() * (2 - 1 + 1) + 1);
                    switch(a){
                        case 1:
                            int b = (int)Math.floor(Math.random() * ((Person.PersonList.size()-1) - 0 + 1) + 0);
                            System.out.println("I don't think Ive seen " + Person.PersonList.get(b).name + " in the party.");
                            i.interrogatedStage1 = true;
                            break;
                        case 2:
                            System.out.println("Maybe " + i.enemiedBy.name + " might know something about this case");
                            i.enemiedBy.enemyInterrogated = true;
                            break;
                    }
                }
    if(Location.currentInvolvedLocation == null){
            int d = (int)Math.floor(Math.random() * ((Location.locationList.size()-1) - 0 + 1) + 0);
            Location.currentInvolvedLocation = Location.locationList.get(d);
            Person.level ++;
            }
    }
    
    public static void generateAlbClue(Person i){
    if(i.enemyInterrogated == true){
                System.out.println("I've only been minding my business, ");
                i.interrogatedStage1 = true;
                } else if(i.enemiedByInterrogated == true) {
                int b = (int)Math.floor(Math.random() * (2 - 1 + 1) + 1);
                    switch(b){
                        case 1:
                        System.out.println("Nonsense, I've been in this party the whole time");
                        i.interrogatedStage1 = true;
                        break;
                        case 2:
                        int c = (int)Math.floor(Math.random() * ((Location.locationList.size()-1) - 0 + 1) + 0);
                        System.out.println("I left the vicinity to go to " + Location.locationList.get(c).name + " to get something, I was not aware of a murder happening");
                        i.interrogatedStage1 = true;
                        break;
                }
                } else if(i.interrogatedStage1 == false){
                int a = (int)Math.floor(Math.random() * (2 - 1 + 1) + 1);
                    switch(a){
                        case 1:
                            int b = (int)Math.floor(Math.random() * ((Person.PersonList.size()-1) - 0 + 1) + 0);
                            System.out.println("I don't think Ive seen " + Person.PersonList.get(b).name + " in the party.");
                            i.interrogatedStage1 = true;
                            break;
                        case 2:
                            System.out.println("Maybe " + i.enemiedBy.name + " might know something about this case");
                            i.enemiedBy.enemyInterrogated = true;
                            break;
                    }
                }
    if(Location.currentInvolvedLocation == null){
            int d = (int)Math.floor(Math.random() * ((Location.locationList.size()-1) - 0 + 1) + 0);
            Location.currentInvolvedLocation = Location.locationList.get(d);
            Person.level ++;
            }
    }
}
