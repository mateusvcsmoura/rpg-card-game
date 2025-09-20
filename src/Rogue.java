import java.util.Random;

public class Rogue extends Character {
    public Rogue (String name) {
        super(name, generatePowerPoints(), generateLifePoints(), generateDefensePoints(), "Rogue");
    }

    private static int generatePowerPoints (){
        Random random = new Random();

        int powerPoints = random.nextInt((95 - 81) + 1) + 81;

        return powerPoints;
    }

    private static int generateLifePoints (){
        Random random = new Random();

        int lifePoints = random.nextInt((40 - 26) + 1) + 26;

        return lifePoints;
    }

    private static int generateDefensePoints (){
        Random random = new Random();

        int defensePoints = random.nextInt((37 - 21) + 1) + 21;

        return defensePoints;
    }
}