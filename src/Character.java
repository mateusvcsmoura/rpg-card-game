public class Character {
    private String name;
    private final String rpgClass;
    private int power;
    private int lifePoints;
    private int defensePoints;
    private boolean defenseStance;
    private boolean isAlive;
    private double baseAttackFailRate;

    public Character (String name, int power, int lifePoints, int defensePoints, String rpgClass) {
        this.name = name;
        this.rpgClass = rpgClass;
        this.power = power;
        this.lifePoints = lifePoints;
        this.defensePoints = defensePoints;

        this.defenseStance = false;
        this.isAlive = true;
        this.baseAttackFailRate = 0.15;
    }

    public void showCharacterStatus() {
        System.out.println("\nCharacter: " + this.getName());
        System.out.println("RPG Class: " + this.getRpgClass());
        System.out.println("Power: " + this.getPower());
        System.out.println("Life Points: " + this.getLifePoints());
        System.out.println("Defense Points: " + this.getDefensePoints());
    }

    public void attack (Character target) { // char power -> target defense
        boolean isAttackerHealthy = this.checkCharacterHealth();
        boolean isTargetAlive = target.getIsAlive();

        if (!isAttackerHealthy) {
            System.out.println(this.getName() + " is not healthy enough to do any action.");
            return;
        }

        if (!isTargetAlive) {
            System.out.println(target.getName() + " is already dead.");
            return;
        }

        double damageMultiplier = 1.0;
        double currentFailRate = this.getBaseAttackFailRate();

        AttackModifier modifier = GameRules.getModifier(this.getRpgClass(), target.getRpgClass());

        if (modifier != null) {
            System.out.println("Counter class detected! " + this.getRpgClass() + " vs " + target.getRpgClass());
            damageMultiplier = modifier.damageMultiplier();
            currentFailRate = modifier.failRate();
        }

        if (Math.random() < currentFailRate) {
            System.out.println(this.getName() + " tried to attack but got bad luck (RNG)!");
            return;
        }

        if (target.getDefensePoints() >= this.getPower()) {
            System.out.println(this.getName() + " tried attacking " + target.getName() + " but failed!\n");
            return;
        }

        int baseDamage = this.getPower() - target.getDefensePoints();

        if (target.getDefenseStance()) {
            baseDamage = baseDamage - 15;
        }

        int finalDamage = (int) Math.round(baseDamage * damageMultiplier);
        if (finalDamage <= 0) finalDamage = 1; // guarantees minimum damage


        System.out.println(this.getName() + " has attacked " + target.getName() + " dealing " + finalDamage + " damage");

        target.updateLife(-finalDamage);
    }

    public void defend () {
        boolean isCharacterHealthy = this.checkCharacterHealth();
        if (!isCharacterHealthy) {
            System.out.println(this.getName() + " is too tired to defend.");
            return;
        }

        System.out.println(this.getName() + " is taking a defensive stance!");
        this.setDefenseStance(true);
    }

    private void updateLife (int amount) {
        int updatedLife = this.getLifePoints() + amount;

        if (updatedLife < 1) {
            updatedLife = 0;
            this.die();
        }

        this.setLifePoints(updatedLife);
    }

    private boolean checkCharacterHealth () {
        return this.getIsAlive();
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

    public String getRpgClass() {
        return this.rpgClass;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }

    private void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public int getPower() {
        return this.power;
    }

    private void setLifePoints(int life) {
        this.lifePoints = life;
    }

    public int getLifePoints() {
        return this.lifePoints;
    }

    public int getDefensePoints() {
        return this.defensePoints;
    }

    public double getBaseAttackFailRate() {
        return this.baseAttackFailRate;
    }
}