import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class Initiative{
    public static ArrayList<Monster> monsters=new ArrayList<Monster>();
    public static void main(String[]args){
        System.out.println("WELCOME TO THE DND INIATIVE TRACKER");
        int choice=-1;
        Scanner input= new Scanner(System.in);
        Scanner input2= new Scanner(System.in);
        while(choice<6){
            try{
                System.out.println("Make a choice!\n     (1) add a new Monster\n     (2) get info on a Monster\n     (3) change a Monsters health\n     (4) view initiative order\n     (5) Roll dice\n     (6) quit");
                System.out.print("ENTER YOUR CHOICE: ");
                choice=input.nextInt();
                if(choice==1){
                    try{
                        System.out.print("What would you like to name your new Monster: ");
                        String name=input2.nextLine();
                        System.out.print("How much hp will this Monster have: ");
                        int health=input.nextInt();
                        System.out.print("Enter the Strength modifier: ");
                        int[] stats= new int[6];
                        stats[0]=input.nextInt();
                        System.out.print("Enter the Dexterity modifier: ");
                        stats[1]=input.nextInt();
                        System.out.print("Enter the Constitution modifier: ");
                        stats[2]=input.nextInt();
                        System.out.print("Enter the Intelligence modifier: ");
                        stats[3]=input.nextInt();
                        System.out.print("Enter the Wisdom modifier: ");
                        stats[4]=input.nextInt();
                        System.out.print("Enter the Charisma modifier: ");
                        stats[5]=input.nextInt();
                        System.out.print("Enter the roll NOT including dexterity modifier for initiative: ");
                        int initiative=input.nextInt();
                        System.out.print("Enter the monsters speed stat: ");
                        int speed=input.nextInt();
                        System.out.print("How many attacks will you have: ");
                        int num=input.nextInt();
                        String[][] attacks= new String[num][5];
                        System.out.println("ENTER ATTACKS IN THIS ORDER --> Name,damage die,attack type(piercing, slashing, etc),Ranged or Melee,notes");
                        for(int i=1;i<=num;i++){
                            System.out.print("attack number #"+i+": ");
                            attacks[i-1]=input2.nextLine().split(",");
                            if(attacks[i-1].length!=5){
                                System.out.println("Invalid input please try again using the exact layout shown above");
                                i--;
                            }
                        }
                        monsters.add(new Monster(name,health,initiative,stats,attacks,speed));
                    }
                    catch(InputMismatchException e){
                        System.out.println("INVALID INPUT DETECTED, PLEASE RESTART CHARACTER BUILDER");
                        input.nextLine();
                    }
                }
                else if(choice==2){
                    try{
                        System.out.print("Which monster do you want the info on? (name): ");
                        String name=input2.nextLine();
                        for(Monster mon: monsters){
                            if(mon.getName().equals(name)){
                                System.out.println("Name: "+mon.getName()+", HP: "+mon.getHealth()+", Speed: "+mon.getSpeed()+", Initiative: "+mon.getInitiative());
                                System.out.println("STATS: ");
                                mon.printStats();
                                System.out.println("ATTACKS: ");
                                mon.printAttacks();
                            }
                        }
                    }
                    catch(InputMismatchException e){
                        System.out.println("INVALID INPUT");
                    }
                }
                else if(choice==3){
                    try{
                        System.out.print("Which monsters health are you changing: ");
                        String name=input2.nextLine();
                        System.out.print("How much are changing the hp by: ");
                        int change=input.nextInt();
                        for(Monster mon: monsters){
                            if(mon.getName().equals(name)){
                                mon.changeHealth(change);
                                System.out.println("Change complete, new hp is: "+mon.getHealth());
                            }
                            if(mon.getHealth()<=0){
                            System.out.println(mon.getName()+" has been slain, removing from iniative");
                            monsters.remove(mon);
                            break;
                        }
                        }
                    }
                    catch(InputMismatchException e){
                        System.out.println("INVALID INPUT");
                    }
                }
                else if(choice==4){
                    for(int i=0;i<monsters.size();i++){
                        int m=i;
                        int value=monsters.get(i).getInitiative();
                        for(int j=i+1;j<monsters.size();j++){
                            if(value<=monsters.get(j).getInitiative()){
                                m=j;
                                value=monsters.get(j).getInitiative();
                            }
                        }
                        if(m!=i){
                            Monster temp=monsters.get(i);
                            monsters.set(i,monsters.get(m));
                            monsters.set(m,temp);
                        }
                    }
                    for(int q=0;q<monsters.size();q++){
                            System.out.println((q+1)+": "+monsters.get(q).getName());
                        }
                }
                else if(choice==5){
                    try{
                        System.out.print("how many sided dice do you wish to roll: ");
                        int sides=input.nextInt();
                        System.out.print("How many dice do you wish to roll: ");
                        int num=input.nextInt();
                        for(int i=0;i<num;i++){
                            System.out.println("Roll #"+(i+1)+": "+((int)(Math.random()*sides)+1));
                        }
                    }
                    catch(InputMismatchException e){
                        System.out.println("INVALID INPUT");
                    }
                }
                else{
                    System.out.println("THANK YOU FOR USING THE DnD INITIATIVE TRACKER!");
                }
                }
            catch(InputMismatchException e){
                System.out.println("INVALID INPUT");
                input.nextLine();
            }
        }
        input.close();
        input2.close();
    }
}