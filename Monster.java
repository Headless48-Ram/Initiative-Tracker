public class Monster{
    private String name;
    private int health;
    private int initiative;
    private int[] statBlock;
    private String[][] attacks;
    private int speed;
    public Monster(String n, int h, int i,int[] s, String[][] a, int spee){
        name=n;
        health=h;
        statBlock=s;
        initiative=i+statBlock[1];
        attacks=a;
        speed=spee;
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public int getInitiative(){
        return initiative;
    }
    public String[][] getAttacks(){
        return attacks;
    }
    public void changeHealth(int change){
        health+=change;
    }
    public int getSpeed(){
        return speed;
    }
    public int[] getStats(){
        return statBlock;
    }
    public void printAttacks(){
        for(String[] attack : attacks){
            if(attack[3].toLowerCase().equals("ranged")){
                System.out.println("     "+attack[0]+", "+attack[1]+" + "+statBlock[1]+" "+attack[2]+", extra notes: "+attack[4]);
            }
            else{
                System.out.println("     "+attack[0]+", "+attack[1]+" + "+statBlock[0]+" "+attack[2]+", extra notes: "+attack[4]);
            }
        }
    }
    public void printStats(){
        System.out.println("     Strength: "+statBlock[0]);
        System.out.println("     Dexterity: "+statBlock[1]);
        System.out.println("     Constitution: "+statBlock[2]);
        System.out.println("     Intelligence: "+statBlock[3]);
        System.out.println("     Wisdom: "+statBlock[4]);
        System.out.println("     Charisma: "+statBlock[5]);
    }
}