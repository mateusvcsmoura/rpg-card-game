public class Character {
    private String name;
    private final String cardValue;
    private final String rpgClass;
    private int power;
    private int lifePoints;
    private int defensePoints;
    private int weariness;
    private boolean defenseStance;
    private boolean isAlive;

    public Character (String name, int power, int lifePoints, int defensePoints, String rpgClass) {
        this.name = name;
        this.cardValue = "1C";
        this.rpgClass = rpgClass;
        this.power = power;
        this.lifePoints = lifePoints;
        this.defensePoints = defensePoints;

        this.weariness = 0;
        this.defenseStance = false;
        this.isAlive = true;
    }

    public void showCharacterStatus() {
        System.out.println("\nCharacter: " + this.getName());
        System.out.println("Card Value: " + this.getCardValue());
        System.out.println("RPG Class: " + this.getRpgClass());
        System.out.println("Power: " + this.getPower());
        System.out.println("Life Points: " + this.getLifePoints());
        System.out.println("Defense Points: " + this.getDefensePoints());
        System.out.println("Weariness: " + this.getWeariness() + "\n");
    }

    public void walk() {
        boolean isHealthy = this.checkCharacterHealth();

        if (!isHealthy) {
            System.out.println(this.getName() + " is not healthy enough to do any action. Check Character Life or Weariness");
            return;
        }

        System.out.println(this.getName() + " is walking...");
        this.updateWeariness(1);
    }

    public void attack (Character target) { // char power -> target defense
        boolean isAttackerHealthy = this.checkCharacterHealth();
        boolean isTargetAlive = target.getIsAlive();

        if (!isAttackerHealthy) {
            System.out.println(this.getName() + " is not healthy enough to do any action. Check Character Life or Weariness");
            return;
        }

        if (!isTargetAlive) {
            System.out.println(target.getName() + " is already dead.");
            return;
        }

        if (target.getDefensePoints() >= this.getPower()) {
            System.out.println(this.getName() + " tried attacking " + target.getName() + " but failed!\n");
            return;
        }

        int damage = this.getPower() - target.getDefensePoints();

        if (target.getDefenseStance()) {
            damage = damage - 15;
        }

        if (this.getRpgClass().equals("Rogue")) {
            if (target.getRpgClass().equals("Warrior")) {
                damage = (int) Math.round(damage * 2);
            }
        }

        if (this.getRpgClass().equals("Mage")) {
            if (target.getRpgClass().equals("Rogue")) {
                damage = (int) Math.round(damage * 1.25);
            }
        }

        if (this.getRpgClass().equals("Warrior")) {
            if (target.getRpgClass().equals("Mage")) {
                damage = (int) Math.round(damage * 1.8);
            }
        }

        System.out.println(this.getName() + " has attacked " + target.getName() + " dealing " + damage + " damage");

        target.updateLife(-damage);
        this.updateWeariness(3);
    }

    public void rest () {
        System.out.println(this.getName() + " is resting...");
        this.updateLife(15);
        this.updateWeariness(-15);
    }

    private void updateLife (int amount) {
        int updatedLife = this.getLifePoints() + amount;

        if (updatedLife < 1) {
            updatedLife = 0;
            this.die();
        }

        this.setLifePoints(updatedLife);
    }

    private void updateWeariness (int amount) {
        this.setWeariness(this.getWeariness() + amount);
    }
    private boolean checkCharacterHealth () {
        return this.getWeariness() < 15 && this.getIsAlive();
    }

    private void die () {
        System.out.println(this.getName() + " has died");
        this.setIsAlive(false);
    }

    public boolean getDefenseStance () {
        return this.defenseStance;
    }

    public void setDefenseStance(boolean newStance) {
        this.defenseStance = newStance;
    }

    public String getName() {
        return this.name;
    }

    public String getCardValue() {
        return this.cardValue;
    }

    public String getRpgClass() {
        return this.rpgClass;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }

    private void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getLifePoints() {
        return this.lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getDefensePoints() {
        return this.defensePoints;
    }

    public void setDefensePoints(int defensePoints) {
        this.defensePoints = defensePoints;
    }

    public int getWeariness() {
        return this.weariness;
    }

    public void setWeariness(int weariness) {
        this.weariness = weariness;
    }
}