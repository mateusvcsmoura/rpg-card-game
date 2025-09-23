import java.util.List;

public class RpgCardGame {

    public static void main(String[] args) {
        Player mateus = new Player("mats");
        for (int i = 0; i < 5; i++) {
            List<Character> cards = mateus.getCards();
            cards.get(i).showCharacterStatus();
        }

        // Warrior > Mago
        // Mago > Rogue
        // Rogue > Warrior

//        Mage mats = new Mage("mats");
//        Rogue itzy = new Rogue("itzy");
//        Warrior garen = new Warrior("garen");
//
//        mats.showCharacterStatus();
//        itzy.showCharacterStatus();
//        garen.showCharacterStatus();

        // itzy.attack(mats);
        // mats.attack(itzy);
        // garen.attack(mats);
        // itzy.attack(garen);
        // mats.attack(garen);
        // garen.attack(itzy);

        // itzy.attack(garen);
        // garen.attack(itzy);
        // itzy.attack(garen);
        // garen.attack(itzy);

        // mats.attack(garen);
        // garen.attack(mats);
        // mats.attack(garen);
        // garen.attack(mats);
        // mats.attack(garen);
        // garen.attack(mats);

        // itzy.setDefenseStance(true);
        // mats.attack(itzy);
        // mats.attack(itzy);
        // itzy.setDefenseStance(false);
        // mats.attack(itzy);
        // mats.attack(itzy);
        // mats.attack(itzy);

        // itzy.walk();


//        mats.showCharacterStatus();
//        itzy.showCharacterStatus();
//        garen.showCharacterStatus();
    }
}