import java.util.*;
public class EvolvableCuteCreatureClient{
   public static void main(String[] args){
       EvolvableCuteCreature e1 = new EvolvableCuteCreature("",1,0,0,0,false,"");
       EvolvableCuteCreature e2 = new EvolvableCuteCreature("",1,0,0,0,false,"");
       cuteCreature cuteOppo = new cuteCreature("",1,0,0,0,false);
       EvolvableCuteCreature cuteOppLv20 = new EvolvableCuteCreature("", 20,0, 0, 0, false,"");
       
       Scanner input = new Scanner(System.in);
       
       System.out.println("Choose your CuteCreature");
       System.out.println("1. A-amo (Fire)\n2. H-hihung (Water)\n3. N-Nhinho(Air)\n4. T-Titon (Earth)");
       System.out.print("Choose the creature: ");
       int choice = input.nextInt();
       
       switch(choice){  //choose element of evolvable cute creature
           case 1: 
               e1 = new EvolvableCuteCreature("A-amo", 19,500, 55, 700, true,"");
               System.out.println(e1.toString());
               break;
       
           case 2:
               e1 = new EvolvableCuteCreature("H-hihung",19, 500, 55, 700, true,"");
               System.out.println(e1.toString());
               break;
       
           case 3:
               e1 = new EvolvableCuteCreature("N-Nhinho", 19,500, 55, 700, true,"");
               System.out.println(e1.toString());
               break;
           case 4:
               e1 = new EvolvableCuteCreature("T-Titon",19, 500, 55, 700, true,"");
               System.out.println(e1.toString());
               break;
       
       }
        System.out.println("\nHERE IS YOUR OPPONENT!");
        cuteOppo = new cuteCreature("CuteOppo",19,800,20,750,false);
        System.out.println(cuteOppo.toString());
        System.out.println("\nStart Fighting!!!\n") ;
         
         // 2 creatures fight until one is defeated
        do{
            e1.attack(cuteOppo);
            if(cuteOppo.getCurrentHitPoints()==0)
                break;
            cuteOppo.attack(e1);
            if(e1.getCurrentHitPoints()==0)
                break;
            
        }while(e1.getCurrentHitPoints() !=0&& cuteOppo.getCurrentHitPoints()!=0);
    
        System.out.print("\nFighting result:\n\n");
        System.out.print(e1.toString()+"\n\n");
        System.out.print(cuteOppo.toString());
    
        System.out.println("\n\nChoose your level 20 Opponent!");
        System.out.println("\n1. EvolvableCuteCreature\n2. CuteCreature");
        int choice2 = input.nextInt();
        int oppoChoice;
       
       if(choice2 == 1) //Opponent is an evolvable cute creature
       {
           System.out.println("Choices: \n1. A-Fire\n2. H-Water \n3. N-Air\n4. T-Earth");
           System.out.print("Choose your opponent: ");
           oppoChoice = input.nextInt();
           System.out.println("HERE IS YOUR OPPONENT!\n");
           switch(oppoChoice){//choose element of evolvable cute creatuare 
               case 1:
                e2 = new EvolvableCuteCreature("A-Fire",20,1000, 40, 1000, true,"Fire");break;
               case 2:
                e2 = new EvolvableCuteCreature("H-Water",20, 1000, 40, 1000, true,"Water");break;
               case 3:
                e2 = new EvolvableCuteCreature("N-Air",20, 1000, 40, 1000, true,"Air");break;
               case 4:
                e2 = new EvolvableCuteCreature("T-Earth",20,1000, 40, 1000, true,"Earth");break;

           }
           System.out.println(e2.toString()+"\n");
       }
       else if(choice2 == 2)//opponent is a normal cute creature
       {
           System.out.println("HERE IS YOUR OPPONENT!\n");
           cuteOppLv20 = new EvolvableCuteCreature("cuteOppLv20", 20,1000, 40, 650, false,"");
           System.out.println(cuteOppLv20.toString());
       }
       
       System.out.print("\nChoose: 1. Normal Attack    2. Elemental Attack: ");
       int attack = input.nextInt();
       if(choice2 == 1){    //nomal attack
           do{    
               if(attack == 1){
                    e1.attack(e2);
                    if(e2.getCurrentHitPoints()==0)
                        break;
                    e2.attack(e1);
                    if(e1.getCurrentHitPoints()==0)
                        break;
               }
               else{
                    e1.elementalAttack(e2);
                    if(e2.getCurrentHitPoints()==0)
                        break;
                    e2.elementalAttack(e1);
                    if(e1.getCurrentHitPoints()==0)
                        break;
               }
            }while(e1.getCurrentHitPoints() !=0&& e2.getCurrentHitPoints()!=0&& !e1.getElement().equals(e2.getElement()));
           System.out.print("\nFighting result:\n\n");
           System.out.print(e1.toString()+"\n\n");
           System.out.print(e2.toString());
       }

       if(choice2 == 2){    //attack by element
           do{
               if(attack == 1){
                    e1.attack(cuteOppLv20);
                    if(cuteOppLv20.getCurrentHitPoints()==0)
                        break;
                    cuteOppLv20.attack(e1);
                    if(e1.getCurrentHitPoints()==0)
                        break;
               }
               else{
                    e1.elementalAttack(cuteOppLv20);
                    if(cuteOppLv20.getCurrentHitPoints()==0)
                        break;
                    cuteOppLv20.attack(e1);//to make a fair fight as cuteOppLv20 can not attack by element
                    if(e1.getCurrentHitPoints()==0)
                        break;
               }
           } while(e1.getCurrentHitPoints() !=0&& cuteOppLv20.getCurrentHitPoints()!=0);   
           System.out.print("\nFighting result:\n\n");
           System.out.print(e1.toString()+"\n\n");
           System.out.print(cuteOppLv20.toString());
       }
   }    
}