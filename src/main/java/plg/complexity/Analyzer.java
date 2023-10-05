package plg.complexity;

import plg.model.Process;

import java.util.Set;

public interface Analyzer {
    public Set<Measure> analyze(Process process);
}
