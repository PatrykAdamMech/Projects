import java.util.Random;

public class DnDCharacter {
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int healthPoints = 10;
    private int healthModifier;
    Random random = new Random();
    DnDCharacter() {
        this.strength = statistic(rollFour());
        this.dexterity = statistic(rollFour());


        int[] rolls = rollFour();
        int stat = statistic(rolls);
        this.healthModifier = (stat - 10 )/ 2;
        this.healthPoints = 10 + healthModifier;
        this.constitution = stat;

        this.intelligence = statistic(rollFour());
        this.wisdom = statistic(rollFour());
        this.charisma = statistic(rollFour());

    }
    public int getStrength() {
        return this.strength;
    }
    public int getDexterity() {
        return this.dexterity;
    }
    public int getConstitution() {
        return this.constitution;
    }
    public int getIntelligence() {
        return this.intelligence;
    }
    public int getWisdom() {
        return this.wisdom;
    }
    public int getCharisma() {
        return this.charisma;
    }
    public int getHealthPoints() {
        return this.healthPoints;
    }
    public int getHealthModifier() {
        return this.healthModifier;
    }

    //Roll -> Lowest -> Ability
    public int[] rollFour() {
        int[] rolls= {0,0,0,0};
        for(int i = 0;i<4;i++) {
            int roll = random.nextInt(6)+1;
            rolls[i] = roll;
        }
        return rolls;
    }

    //Returns the lowest number
    public int lowest(int[] rolls) {
        int lowestNumber = rolls[0];
        for(int i = 0;i<4;i++) {
            if(rolls[i]<lowestNumber) {
                lowestNumber = rolls[i];
            }
        }
        return lowestNumber;
    }

    int statistic(int[] rolls) {
        int stat = 0;
        int lowestNumber = lowest(rolls);
        for(int i = 0;i<4;i++) {
            if(!(rolls[i]==lowestNumber)) stat+=rolls[i];
        }
        return stat;
    }


}
