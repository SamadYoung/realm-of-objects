package mmo;

public class Hero {

    public static final int STARTING_LEVEL = 1;

    private String name;
    private int level ;
    private int currentHP;
    private int maxHP;

    public Hero(String name, int maxHP) {

        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (maxHP <= 0){
            throw new IllegalArgumentException("Max HP must be greater than 0");
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

        if ((getCurrentHP() - amount) < 0){

            this.currentHP = 0;

        } else{

            this.currentHP = getCurrentHP() - amount;
        }
    }

    public void heal(int amount){

        if (amount < 0){
            throw new IllegalArgumentException("Cannot heal with negative value");
        }

        if (getCurrentHP() == 0){
            return;
        }

        if ((amount + getCurrentHP() > getMaxHP())){

            this.currentHP = getMaxHP();
        }

        if ((amount + getCurrentHP() <= getMaxHP())) {
            this.currentHP = amount + getCurrentHP();
        }

    }

    public boolean isAlive(){

        return getCurrentHP() > 0;
    }

    public void levelUp(){

        this.level += 1;
        this.maxHP += 10;
        this.currentHP = maxHP;
    }



}
