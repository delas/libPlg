package plg.complexity;

import plg.utils.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Measures extends HashMap<String, Double> {

    public Measures() {
        super();
    }

    public Measures(String name, Double value) {
        put(name, value);
    }

    public Measures add(String name, Double value) {
        put(name, value);
        return this;
    }

    public Set<String> getMeasures() {
        return keySet();
    }

    public Measures join(Measures other) {
        Measures result = new Measures();
        for (Map.Entry<String, Double> entry : entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Double> entry : other.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
