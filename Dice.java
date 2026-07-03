import java.util.Scanner;
public class Dice{
    public static void main(String[]args){
        int choice=-1;
        Scanner input = new Scanner(System.in);
        while(choice<2){
            System.out.println("Welcome to the Dice Game!");
            System.out.println("(1) roll a die\n(2) quit");
            System.out.print("What do you choose: ");
            choice=input.nextInt();
            if(choice==1){
                System.out.print("How many sided die do you want to roll: ");
                int sides=input.nextInt();
                System.out.println((int)(Math.random()*sides)+1);
            }
        }
        input.close();
    }
}