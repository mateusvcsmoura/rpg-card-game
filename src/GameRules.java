import java.util.HashMap;
import java.util.Map;

public class GameRules {
    // A estrutura é: Map<Atacante, Map<Alvo, Modificador>>
    private static final Map<String, Map<String, AttackModifier>> COUNTER_RULES = new HashMap<>();

    static {
        // Regras do Rogue
        Map<String, AttackModifier> rogueCounters = new HashMap<>();
        rogueCounters.put("Warrior", new AttackModifier(2.0, 0.20)); // Rogue vs Warrior: 2x dano, 20% falha
        COUNTER_RULES.put("Rogue", rogueCounters);

        // Regras do Mage
        Map<String, AttackModifier> mageCounters = new HashMap<>();
        mageCounters.put("Rogue", new AttackModifier(1.25, 0.35)); // Mage vs Rogue: 1.25x dano, 35% falha
        COUNTER_RULES.put("Mage", mageCounters);

        // Regras do Warrior
        Map<String, AttackModifier> warriorCounters = new HashMap<>();
        warriorCounters.put("Mage", new AttackModifier(1.8, 0.25)); // Warrior vs Mage: 1.8x dano, 25% falha
        COUNTER_RULES.put("Warrior", warriorCounters);
    }

    public static AttackModifier getModifier(String attackerClass, String targetClass) {
        // Retorna o modificador se existir, senão retorna null
        return COUNTER_RULES.getOrDefault(attackerClass, new HashMap<>()).get(targetClass);
    }
}