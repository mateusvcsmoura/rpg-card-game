import java.util.Random;

public class Mage extends Character {

    public Mage (String name) {
        super(name, generatePowerPoints(), generateLifePoints(), generateDefensePoints(), "Mage");
    }

    private static int generatePowerPoints (){
        Random random = new Random();

        int powerPoints = random.nextInt((81 - 65) + 1) + 65;

        return powerPoints;
    }

    private static int generateLifePoints (){
        Random random = new Random();

        int lifePoints = random.nextInt((71 - 48) + 1) + 48;

        return lifePoints;
    }

    private static int generateDefensePoints (){
        Random random = new Random();

        int defensePoints = random.nextInt((43 - 27) + 1) + 27;

        return defensePoints;
    }
}