/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package letsdosomething;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author lnaoreto
 */
public class Person {
    public final String name;
    public static ArrayList<Person> PersonList = new ArrayList<>();
    public static ArrayList<Person> AliveList = new ArrayList<>();
    public Person friend;
    public Person friendedBy;
    public Person enemy;
    public Person enemiedBy;
    public static Person murderer;
    public static Person Deceased;
    public boolean enemied = false;
    public boolean friended = false;
    public static String[] Weapon = {"Gun", "Knife"};
    public static String chosenWeapon;
    public static int level = 1;
    public boolean interrogatedStage1 = false;
    public boolean interrogatedStage2 = false;
    public boolean enemyInterrogated = false;
    public boolean enemiedByInterrogated = false;
    public static Person currentPersonInvolved1;
    public static Person currentPersonInvolved2;
    public static int Weeks = 8;
    public static int weeksPassed = 0;
    public Person(String n){
    name = n;
    PersonList.add(this);
    AliveList.add(this);
    }
    
    public static void pickMurderer(){
    int min = 0;
    int max = 5;
    int i = (int)Math.floor(Math.random() * (max - min + 1) + min);
    murderer = PersonList.get(i);
    System.out.printf("%s is the murderer!\n", murderer.name);
    Deceased = PersonList.get(i).enemy;
    System.out.printf("%s was the first victim!\n", Deceased.name);
    int f = (int)Math.floor(Math.random() * (1 - 0 + 1) + 0);
    chosenWeapon = Weapon[f];
    AliveList.remove(Deceased);
    }
    
    public static void randomizeRelationships(){
    int min = 1;
    int max = PersonList.size();
    int f;
    int e;
    f = (int)Math.floor(Math.random() * (max - min + 1) + min);
    e =(int)Math.floor(Math.random() * (max - min + 1) + min);
    while(e == f){
    e = (int)Math.floor(Math.random() * (max - min + 1) + min);
    }
    
    for(int i = 0; i <= PersonList.size()-1; i++){
    int j = i + f;
    if(j > PersonList.size()-1){
    j -= PersonList.size();
    }
    PersonList.get(i).friend = PersonList.get(j);
    PersonList.get(j).friendedBy = PersonList.get(i);
    System.out.println(PersonList.get(i).name + "'s friend: "  +PersonList.get(i).friend.name);
    }
    
    System.out.println("");
    for(int i = 0; i <= PersonList.size()-1; i++){
    int k = i + e;
    if(k > PersonList.size()-1){
    k -= PersonList.size();
    }
    PersonList.get(i).enemy = PersonList.get(k);
    PersonList.get(k).enemiedBy = PersonList.get(i);
    System.out.println(PersonList.get(i).name + "'s enemy: "  +PersonList.get(i).enemy.name);
    }
    System.out.println("");
    }
    
    public static void Interrogate(Person i){
    System.out.println("Now interrogating " + i.name);
    if(Person.level < 2){
        System.out.println("Have you done any snooping around yet? Maybe investigate first before interrogating");
        }else 
        
    if(Person.level == 2 && i.interrogatedStage1 == false){
            if(i.friend == Deceased){ //interviewing friended victim
                albClue.generateFriendedVictimAlbClue(i);
            } else
            if(i == Deceased.friend){ //interviewing friended by victim
                albClue.generateFriendedByVictimAlbClue(i);
            } else
            if(i == Deceased.enemiedBy){ //interviewing murderer/ victim enemied by
                albClue.generateMurdererAlbClue(i);
            }
    } else if(Person.level >= 3 && i.interrogatedStage2 == false){
        if(i == currentPersonInvolved1){
            mysClue.generateInterrogationMysClue(i);
            i.interrogatedStage2 = true;
        } else
        if(i == currentPersonInvolved2){
            mysClue.generateInterrogateFriendMysClue(i);
            i.interrogatedStage2 = true;
        } else{
            System.out.println("What's your evidence that I was involved?");
        }
    } else if(Person.level >= 4 && i == murderer){
        System.out.println("Leave me alone! I didn't do it!");
        } else {
    System.out.println("You've already interviewed me, please be mindful of what we say");
    }
    int k = 0;
    for(int j = 0; j < AliveList.size(); j++){
    if(AliveList.get(j).interrogatedStage1 == true){
    k ++;
    }
    }
    
    if(level < 3 && k == (AliveList.size()-1)){
    level ++;
    }
    
    }
    
    public static void Accuse(Person i){
    if(i == murderer){
    System.out.println("\n YOU WIN!!! THE MURDERER WAS " + murderer.name);
    } else{
    System.out.println("\n YOU LOSE!!! THE MURDERER WAS " + murderer.name);
    }
    }
    
    public static void reset(){
    AliveList.add(Deceased);
    level = 1;
    for(int i = 0; i <= (PersonList.size()-1); i++){
    PersonList.get(i).enemiedByInterrogated = false;
    PersonList.get(i).enemyInterrogated = false;
    PersonList.get(i).enemied = false;
    PersonList.get(i).friended = false;
    PersonList.get(i).interrogatedStage1 = false;
    PersonList.get(i).interrogatedStage2 = false;
    }
    
    for(int i = 0; i <= (Location.locationList.size()-1); i++){
    Location.locationList.get(i).alreadyVisitedStage1 = false;
    Location.locationList.get(i).alreadyVisitedStage2 = false;
    PersonList.get(i).enemied = false;
    PersonList.get(i).friended = false;
    PersonList.get(i).interrogatedStage1 = false;
    PersonList.get(i).interrogatedStage2 = false;
    }
    }
    
    public static void timeSkip(){
    int a = (int)Math.floor(Math.random() * ((Person.AliveList.size()-1) - 0 + 1) + 0);
    while(AliveList.get(a) == murderer || AliveList.get(a) == murderer.friend){
    a = (int)Math.floor(Math.random() * ((Person.AliveList.size()-1) - 0 + 1) + 0);
    }
    Deceased = AliveList.get(a);
    AliveList.remove(a);
    weeksPassed ++;
    System.out.println("\n Weeks Passed: "+ weeksPassed);
    System.out.println("\n Weeks Left: "+ (Weeks - weeksPassed));
    }
    }
