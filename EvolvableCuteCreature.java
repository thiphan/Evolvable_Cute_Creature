public class EvolvableCuteCreature extends cuteCreature{
    private String element="";
        
    public EvolvableCuteCreature(){//defaut constructor
        super();
    }
    
    public EvolvableCuteCreature(String species,int level,int maximumHitPoints,int attackDamage, 
    int experienceValue, boolean isSpecial, String element){//constructor
        super(species,level,maximumHitPoints,attackDamage, experienceValue, isSpecial);
        this.element = element;
    }
    
        public String getElement(){
        return this.element;
    }

    public void elementalAttack(cuteCreature c){
        
        if(this.element.equals(""))
            System.out.println(this.species + " need to evolves to use this attack feature!");
        else{
            if(c instanceof EvolvableCuteCreature){
                EvolvableCuteCreature downCastC = ((EvolvableCuteCreature)c);//downcast c
                System.out.println(this.species + " attacks " + c.getSpecies() +"!");
                int hit = 0;
                
                //same element attack
                if((downCastC.getElement().equals(this.element))&&(this.currentHitPoints!=0&&c.getCurrentHitPoints()!=0)){
                    hit = 0;
                    c.takeDamage(hit);
                    System.out.println("Same element!the element attack deals zero damage\n");
                }
                
                //target creature's element resists the attacking creature's element
                else if((isResist(this.element,downCastC.getElement()))&&(this.currentHitPoints!=0&&c.getCurrentHitPoints()!=0)){
                        hit = (int)(Math.round(0.25*this.attackDamage));
                        c.takeDamage(hit);
                        System.out.println("Hit! "+ c.getSpecies()+" took " + hit + " damage!\n");
                        if(c.getCurrentHitPoints() ==0){
                            System.out.println(this.species + " defeated " + c.getSpecies()+"!");
                            gainExp(c.getExperienceValue());
                        }
                        if(this.currentHitPoints ==0){
                            System.out.println(c.getSpecies() + " defeated " + this.species +"!");
                            c.gainExp(this.experienceValue);
                        }
                }
                
                //target creature's element is vulneable the attacking creature's element
                else if((isVulnerable(this.element,downCastC.getElement()))&&(this.currentHitPoints!=0&&c.getCurrentHitPoints()!=0)){
                        hit = 4*this.attackDamage;
                        c.takeDamage(hit);
                        System.out.println("Hit! "+ c.getSpecies()+" took " + hit + " damage!\n");
                        if(c.getCurrentHitPoints() ==0){
                            System.out.println(this.species + " defeated " + c.getSpecies()+"!");
                            gainExp(c.getExperienceValue());
                        }
                        if(this.currentHitPoints ==0){
                            System.out.println(c.getSpecies() + " defeated " + this.species +"!");
                            c.gainExp(this.experienceValue);
                        }
                }
                
                //attack in others cases
                else if(this.currentHitPoints!=0&&c.getCurrentHitPoints()!=0){            
                        hit = this.attackDamage;
                        c.takeDamage(hit);
                        System.out.println("Hit! "+ c.getSpecies()+" took " + hit + " damage!\n");
                        if(c.getCurrentHitPoints() ==0){
                            System.out.println(this.species + " defeated " + c.getSpecies()+"!");
                            gainExp(c.getExperienceValue());
                        }
                        if(this.currentHitPoints ==0){
                            System.out.println(c.getSpecies() + " defeated " + this.species +"!");
                            c.gainExp(this.experienceValue);
                        }
                }
                else { //to avoid a "healthy" cuteCreature attack a defeated one & get its experience
                    if(this.currentHitPoints==0)
                        System.out.println("Can not attack! " + this.species + " has been incapacitate");
                    if(c.getCurrentHitPoints()==0)
                        System.out.println("Can not attack! " + c.getSpecies()+ " has been incapacitate");
                }
                
            }
        }
    }
    
    public boolean isResist(String attackElement, String beAttacked){
        if((attackElement =="Fire" && beAttacked == "Water")||((attackElement =="Water" && beAttacked == "Earth")||
        (attackElement =="Air" && beAttacked == "Fire"))||(attackElement =="Earth" && beAttacked == "Air"))
            return true;
        else    
            return false;
    }
     public boolean isVulnerable(String attackElement, String beAttacked){
        if((attackElement =="Fire" && beAttacked == "Air")||((attackElement =="Water" && beAttacked == "Fire")||
        (attackElement =="Air" && beAttacked == "Earth"))||(attackElement =="Earth" && beAttacked == "Water"))
            return true;
        else    
            return false;
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
        
        if(this.isSpecial ==true && this.level==20){ //evolution 
            if(this.species.charAt(0)>='A' &&this.species.charAt(0)<='G')
                this.element ="Fire";
            if(this.species.charAt(0)>='H' &&this.species.charAt(0)<='M')
                this.element ="Water";
            if(this.species.charAt(0)>='N' &&this.species.charAt(0)<='S')
                this.element ="Air";
            if(this.species.charAt(0)>='T' &&this.species.charAt(0)<='Z')
                this.element ="Earth";
            System.out.println(this.species + " attuned to " + this.element +"!");
            this.currentHitPoints +=15;
            this.maximumHitPoints +=15;
            this.attackDamage +=3;
        }
        
    }
    
    public String toString(){
        String s;
        if(!this.element.equals("")){
            s = new String( 
            "Level: " + this.level + " " + this.species + "\n" +
            "----------------------" + "\n" +
            "*** " + this.element +" ***\n" +
            "HP: " + this.currentHitPoints + "/" + this.maximumHitPoints + "\n" +
            "Attack Dmg: " + this.attackDamage + "\n" +
            "XP: " + this.experiencePoints + "/" + this.totalExpPointsNeeded + "\n" +
            "XP Value: " + this.experienceValue); 
        }
        else if(isSpecial){
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