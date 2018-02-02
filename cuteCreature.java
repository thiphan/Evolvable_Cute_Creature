import java.util.*;

public class cuteCreature{
    protected String species;
    protected int level;
    protected int currentHitPoints;
    protected int maximumHitPoints;
    protected int attackDamage;
    protected int experiencePoints;
    protected int experienceValue;
    protected int totalExpPointsNeeded;
    protected boolean isSpecial;
    
    //default constructor
    public cuteCreature(){
        species ="sloth";
        level = 1;
        currentHitPoints = 0;
        maximumHitPoints = 0;
        experiencePoints = 0;
        experienceValue = 0;
        attackDamage = 0;
        isSpecial = false;
    }
    //custom cuteCreature constructor
    public cuteCreature(String species,int level,int maximumHitPoints,int attackDamage, int experienceValue, boolean isSpecial){
        this.species = species;
        this.level = level;
        this.currentHitPoints = maximumHitPoints;
        this.maximumHitPoints = maximumHitPoints;
        this.experiencePoints =0;
        this.experienceValue = experienceValue;
        this.totalExpPointsNeeded=250;
        this.attackDamage = attackDamage;
        this.isSpecial = isSpecial;
    }
    
    public void takeDamage(int dmg){
        if(this.currentHitPoints >= dmg){
            this.currentHitPoints -= dmg;
        }
        else{
            this.currentHitPoints = 0;
        }
         
    }
    
    protected void levelUp(){
        this.level ++;
        this.experienceValue+=10;
        if(this.level >=2 && this.level<=10){
            this.currentHitPoints +=4;
            this.maximumHitPoints +=4;
            this.attackDamage +=3;
        }
        else if(this.level>=11){
            this.currentHitPoints +=1;
            this.maximumHitPoints +=1;
            this.attackDamage +=1;
        }
        System.out.println(this.species + " leveled to " + this.level +"!");
    }

    public void gainExp(int exp){
        this.experiencePoints += exp;
        int expPointsNeeded = 250;//experience point needed to level up to 2
        System.out.println(this.species + " gained " + exp + " experience!");
        while(this.experiencePoints>=totalExpPointsNeeded){
            levelUp();
            expPointsNeeded+= 50;//eperience points needed increase 50 per level
            this.totalExpPointsNeeded+= expPointsNeeded;
        }
        
    }
    public void attack(cuteCreature c){
        Random chance = new Random();
        int attackChance = chance.nextInt(100)+1; //percentage of attacking
        int high = (int)(Math.round(this.attackDamage*1.2));
        int low = (int)(Math.round(this.attackDamage*0.8));
        int rivalDamagePoint = chance.nextInt(high-low)+low; //random ammount within +-20% of the attack damage
        int hit =0;
        System.out.println(this.species + " attacks " + c.getSpecies() +"!");
        if(attackChance<=80){ //80% chance to hit with the attack
            hit = rivalDamagePoint;
            c.takeDamage(hit);
            System.out.println("Hit! "+ c.getSpecies()+" took " + hit + " damage!\n");
        }
            else if(attackChance<=95){//15 chance of missing altogether
                hit =0;
                System.out.println("Miss!\n");
            }
                else{ //5% chance to score a critical hit
                    hit = rivalDamagePoint*2;
                    c.takeDamage(hit);
                    System.out.println("Critical hit! "+ c.getSpecies()+" took " + hit + " damage!\n");
                }
        if(c.getCurrentHitPoints() ==0){
            System.out.println(this.species + " defeated " + c.getSpecies()+"!");
            gainExp(c.getExperienceValue());
        }
        if(this.currentHitPoints ==0){
            System.out.println(c.getSpecies() + " defeated " + this.species +"!");
            c.gainExp(this.experienceValue);
        }
    }
    public String getSpecies(){
        return this.species;
    }
    public int getCurrentHitPoints(){
        return this.currentHitPoints;
    }
    public int getExperienceValue(){
        return this.experienceValue;
    }
    
    public String toString(){
        String s;
        if(isSpecial){
            s = new String(
            "Level: " + this.level + " " + this.species + "\n" +
            "----------------------" + "\n" +
            "*** Special! ***\n" +
            "HP: " + this.currentHitPoints + "/" + this.maximumHitPoints + "\n" +
            "Attack Dmg: " + this.attackDamage + "\n" +
            "XP: " + this.experiencePoints + "/" + this.totalExpPointsNeeded + "\n" +
            "XP Value: " + this.experienceValue); 
        }
        else {
            s = new String(
            "Level: " + this.level + " " + this.species + "\n" +
            "----------------------" + "\n" +
            "HP: " + this.currentHitPoints + "/" + this.maximumHitPoints + "\n" +
            "Attack Dmg: " + this.attackDamage + "\n" +
            "XP: " + this.experiencePoints + "/" + this.totalExpPointsNeeded + "\n" +
            "XP Value: " + this.experienceValue); 
        }
  
        return s;
    }
}