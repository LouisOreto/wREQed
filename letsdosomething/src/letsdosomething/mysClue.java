/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package letsdosomething;

/**
 *
 * @author lnaoreto
 */
public class mysClue extends Clues{
    public static int Case;
    public static void generateLocationMysClue(Location i){
        int a = (int)Math.floor(Math.random() * (4 - 1 + 1) + 1);
        switch(a){
            case 1,2:
                int b = (int)Math.floor(Math.random() * ((Person.AliveList.size()-1) - 0 + 1) + 0);
                System.out.println("It apppears " + Person.PersonList.get(b).name + " left their belongings here");
                Person.currentPersonInvolved1 = Person.PersonList.get(b);
                Person.level ++;
                Case = 1;
                break;
            case 3:
                System.out.println("Writing is written on the walls: " + Person.murderer.enemiedBy.name + " did it");
                Person.currentPersonInvolved1 = Person.murderer.enemiedBy;
                Person.level ++;
                Case = 2;
                break;
            case 4:
                int c = (int)Math.floor(Math.random() * ((Person.AliveList.size()-1) - 0 + 1) + 0);
                System.out.println("Writing is written on the walls: " + Person.PersonList.get(c).name + " did it");
                Person.currentPersonInvolved1 = Person.PersonList.get(c);
                Person.level ++;
                Case = 3;
                break;
            case 5:
                if(bsClue.connectedLocation != null){
                System.out.println("It appears a blood trail leads from " + bsClue.connectedLocation + " to here");
                System.out.println("Person 1 and Person 2's belongings are here");
                Person.currentPersonInvolved1 = Person.PersonList.get(2);
                Person.currentPersonInvolved2 = Person.PersonList.get(3);
                Case = 4;
                Person.level ++;
                break;
                } else if (Location.currentLocation == bsClue.connectedLocation){
                System.out.println(Person.murderer.name + "'s things are here, and some blood surrounding it! We may be onto something");
                Person.currentPersonInvolved1 = Person.murderer;
                Person.level ++;
                apexClue.Available = true;
                Case = 5;
                break;
                } else{
                System.out.println("The weapon is here! Though no signs of someone being here, let's ask them again about this");
                Person.level ++;
                Case = 6;
                break;
                }
                
        }
                
            if(Person.currentPersonInvolved1 == null){
            int d = (int)Math.floor(Math.random() * ((Person.PersonList.size()-1) - 0 + 1) + 0);
            Person.currentPersonInvolved1 = Person.PersonList.get(d);
            Person.level ++;
            }
    if(Person.currentPersonInvolved2 == null){
            int e = (int)Math.floor(Math.random() * ((Person.PersonList.size()-1) - 0 + 1) + 0);
            Person.currentPersonInvolved2 = Person.PersonList.get(e);
            Person.level ++;
            }
    }
    
    
    public static void generateRandomLocationMysClue(Location i){
    int a = (int)Math.floor(Math.random() * (5 - 1 + 1) + 1);
        switch(a){
            case 1,2,3:
                System.out.println("Nothing here, check somewhere else");
                break;
            case 4,5:
                int b = (int)Math.floor(Math.random() * ((Person.AliveList.size()-1) - 0 + 1) + 0);
                System.out.println("Person's belongings are here. Let's ask them about it");
                Person.currentPersonInvolved1 = Person.PersonList.get(b);
                Case = 7;
                break;
        }
        
        if(Person.currentPersonInvolved1 == null){
            int d = (int)Math.floor(Math.random() * ((Person.PersonList.size()-1) - 0 + 1) + 0);
            Person.currentPersonInvolved1 = Person.PersonList.get(d);
            Person.level ++;
            }
    if(Person.currentPersonInvolved2 == null){
            int e = (int)Math.floor(Math.random() * ((Person.PersonList.size()-1) - 0 + 1) + 0);
            Person.currentPersonInvolved2 = Person.PersonList.get(e);
            Person.level ++;
            }
    }
    
    public static void generateInterrogationMysClue(Person i){
        switch(Case){
            case 1:
                System.out.println("I only left this here because I frequently go back here, I do not have any involvment in this");
                i.interrogatedStage2 = true;
                break;
            case 2, 3, 4:
                System.out.println("I Swear I didn't do it! Please! You can ask my friend " + i.friend.name + " to testify for me!");
                Person.currentPersonInvolved2 = i.friend;
                break;
            case 5:
                System.out.println("Someone's trying to frame me! Please do something about this!");
                Person.level ++;
                break;
            case 6:
                if(i == Person.murderer){
                System.out.println("I don't really know where that came from. You can try asking around about it");
                break;
                } else {
                System.out.println("I don't really know where that came from, but I saw " + Person.murderer.name + " enter there, so it must be theirs");
                Person.level ++;
                break;
                }
            case 7:
                System.out.println("Is that really a part of the investigation? There's no traces in the room");
                break;
        }
    }
    
    public static void generateInterrogateFriendMysClue(Person i){
        switch(Case){
            case 2:
                System.out.println(Person.murderer.name + " knows my friend dislikes them, perhaps they were the real murderer");
                Person.level ++;
                break;
            case 3:
                System.out.println("That wasn't them for sure, but it's most likely " + Person.murderer.name + " who did it, I heard they hated the victim");
                break;
            case 4:
                System.out.println("They didn't do it");
                break;
        }
    }
    
}
