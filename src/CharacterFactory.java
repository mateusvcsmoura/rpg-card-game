import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CharacterFactory {
    private static final Map<String, List<String>> allNames = Map.of(
            "Rogue", List.of("Valerius", "Lila", "Kaelen", "Seraphina", "Finnian", "Isolde", "Zane", "Anya", "Silas", "Elara"),
            "Warrior", List.of("Borin", "Astrid", "Gideon", "Thyra", "Malik", "Brenna", "Roric", "Ingrid", "Darius", "Freya"),
            "Mage", List.of("Alistair", "Lyra", "Orion", "Rowena", "Eldrin", "Moira", "Jasper", "Seraphine", "Silvanus", "Genevieve")
    );

    private static final List<String> RPG_CLASSES = new ArrayList<>(allNames.keySet());
    private static final Random random = new Random();

    /**
     * Generates a Character List with random names and classes.
     * @param amount The amount of Characters to be generated.
     * @return A list of Character Objects.
     */
    public static List<Character> generateCharacters(int amount) {
        List<Character> generatedCharacters = new ArrayList<>();

        if (amount <= 0) {
            System.out.println("The Character amount should be greater than 0.");
            return generatedCharacters;
        }

        for (int i = 0; i < amount; i++) {
            String randomClass = RPG_CLASSES.get(random.nextInt(RPG_CLASSES.size()));

            List<String> namesForClass = allNames.get(randomClass);

            String randomName = namesForClass.get(random.nextInt(namesForClass.size()));

            Character newCharacter = null;

            switch (randomClass) {
                case "Rogue":
                    newCharacter = new Rogue(randomName);
                    break;
                case "Warrior":
                    newCharacter = new Warrior(randomName);
                    break;
                case "Mage":
                    newCharacter = new Mage(randomName);
                    break;
            }

            if (newCharacter != null) {
                generatedCharacters.add(newCharacter);
            }
        }

        return generatedCharacters;
    }
}