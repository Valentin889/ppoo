package cs108;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class LSystem {
    private final String string;
    private final  Map<Character, String> rules;
    private final Set<Character> lineChars;
    private final int turningAngle;

    public LSystem(String string, Map<Character, String> rules, String lineChars, int turningAngle) {
        this.string = string;
        this.rules = new HashMap<>();
        for (Character character:rules.keySet()) {
            this.rules.put(character, rules.get(character));
        }
        this.lineChars = new HashSet<>();
        lineChars.chars().forEach(e -> this.lineChars.add((char) e));
        this.turningAngle = turningAngle;

    }

    public String string() {
        return string;
    }

    public Map<Character, String> rules() {
        return new HashMap<>(rules);
    }

    public Set<Character> lineChars() {

        return new HashSet<>(lineChars);
    }

    public int turningAngle() {
        return turningAngle;
    }

    public LSystem evolve() {
        StringBuilder builder = new StringBuilder();
        for (Character character : string.toCharArray()) {
            builder.append(rules.getOrDefault(character, character.toString()));
        }
        StringBuilder line = new StringBuilder();
        for (Character character : lineChars) {
            line.append(character);
        }
        return new LSystem(builder.toString(), rules,  line.toString(), turningAngle);
    }

    public LSystem evolve(int steps) {
        LSystem system = this;
        for (int i = 0; i < steps; i++) {
            system = system.evolve();
        }
        return system;
    }
}
