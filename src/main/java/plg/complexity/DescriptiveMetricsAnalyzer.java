package plg.complexity;

import plg.model.Process;

import java.util.Set;

/**
 * This analyzer computes the descriptive metrics of a process model. In particular it calculates:
 * - NOA = Number of activities in a process
 * - NOAC = Number of activities and control-flow elements in a process
 * - NOAJS = Number of activities and joins/splits in a process
 *
 * As described in:
 * - J.Cardoso, J.Mendling, G.Neumann, and H.A.Reijers, “A Discourse on Complexity of Process Models,” in Proceedings of
 *   the 2006 International Conference on Business Process Management Workshops, Berlin, Heidelbergpp, 2006, pp. 117–128
 */
public class DescriptiveMetricsAnalyzer implements Analyzer {
    @Override
    public Set<Measure> analyze(Process process) {
        return Set.of(
                new Measure("NOA", (double) process.getTasks().size()),
                new Measure("NOAC", (double) (process.getTasks().size() + process.getGateways().size() + 2)),
                new Measure("NOAJS", (double) (process.getTasks().size() + process.getGateways().size())));
    }
}
