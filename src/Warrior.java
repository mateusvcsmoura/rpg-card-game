import java.util.Random;

public class Warrior extends Character {
    public Warrior (String name) {
        super(name, generatePowerPoints(), generateLifePoints(), generateDefensePoints(), "Warrior");
    }

    private static int generatePowerPoints (){
        Random random = new Random();

        int powerPoints = random.nextInt((65 - 50) + 1) + 50;

        return powerPoints;
    }

    private static int generateLifePoints (){
        Random random = new Random();

        int lifePoints = random.nextInt((100 - 68) + 1) + 68;

        return lifePoints;
    }

    private static int generateDefensePoints (){
        Random random = new Random();

        int defensePoints = random.nextInt((66 - 50) + 1) + 50;

        return defensePoints;
    }
}