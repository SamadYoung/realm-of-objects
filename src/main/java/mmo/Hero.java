package mmo;

public class Hero {

    public static final int STARTING_LEVEL = 1;

    private String name;
    private int level ;
    private int currentHP;
    private int maxHP;

    public Hero(String name, int maxHP) {

        if (name == null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (maxHP < 0){
            throw new IllegalArgumentException("Max HP cannot be null");
        }

        this.name = name;
        this.level = STARTING_LEVEL;
        this.maxHP = maxHP;
        this.currentHP = maxHP;

    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void takeDamage(int amount){
        if (amount < 0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (amount > getCurrentHP()){
            throw new IllegalArgumentException("Amount cannot be greater than the current HP");
        }
        this.currentHP = getCurrentHP() - amount;
    }

    public void heal(int amount){

        if (amount < 0){
            throw new IllegalArgumentException("Cannot heal with negative value");
        }
        if ((amount + getCurrentHP()) > getCurrentHP()){
            throw new IllegalArgumentException("Cannot inflate health pool by healing");
        }
        if{


    }

}
