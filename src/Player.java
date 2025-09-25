import java.util.List;

public class Player {
    private final String name;
    private List<Character> cards;

    public Player (String name) {
        this.name = name;
        cards = CharacterFactory.generateCharacters(5);
    }

    public List<Character> getCards () {
        return this.cards;
    }

    public String getName () {
        return this.name;
    }
}
