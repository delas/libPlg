package plg.complexity;

import plg.utils.Pair;

public class Measure extends Pair<String, Double> {
    public Measure(String name, Double value) {
        super(name, value);
    }

    public String getName() {
        return getFirst();
    }

    public Double getValue() {
        return getSecond();
    }
}
