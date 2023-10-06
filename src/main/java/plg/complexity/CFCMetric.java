package plg.complexity;

import plg.model.Process;
import plg.model.gateway.ExclusiveGateway;
import plg.model.gateway.Gateway;
import plg.model.gateway.ParallelGateway;

import java.util.Set;

/**
 * This class implements the Control-Flow Complexity (CFC) metric. This metric which measures the amount of branching
 * induced by the split gateways in a process model and is described in:
 *
 * - Cardoso JS (2008) Business process control-flow complexity: metric, evaluation, and validation.
 *   Int J Web Serv Res 5(2):49–76
 *
 */
public class CFCMetric implements Analyzer {
    @Override
    public Measures analyze(Process process) {
        double tot_gateways = 0;
        double cfc_abs = 0;
        for (Gateway g : process.getGateways()) {
            if (g instanceof ExclusiveGateway && g.getOutgoingObjects().size() > 1) {
                // XOR split
                cfc_abs += g.getOutgoingObjects().size();
                tot_gateways++;
            } else if (g instanceof ParallelGateway && g.getOutgoingObjects().size() > 1) {
                // AND split
                cfc_abs += 1;
                tot_gateways++;
            }
        }

        return new Measures("CFC", cfc_abs / tot_gateways);
    }
}
