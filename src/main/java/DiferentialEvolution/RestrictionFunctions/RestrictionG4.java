/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiferentialEvolution.RestrictionFunctions;

import Abstract.PenaltyFunction;
import Abstract.RestrictionFunctions;
import DiferentialEvolution.Individual.Individual;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class RestrictionG4 extends RestrictionFunctions{

    public RestrictionG4(ArrayList<Individual> population, PenaltyFunction penaltyFunction) {
        super(population, penaltyFunction);
    }

    @Override
    public void calculateRestrictions() {
        double g[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        
        for(Individual ind: super.getPopulation()){
            g[0] = 85.334407 + 0.0056858*ind.getChromosome().get(1)*ind.getChromosome().get(4) +
                    0.0006262*ind.getChromosome().get(0)*ind.getChromosome().get(3) -
                    0.0022053*ind.getChromosome().get(2)*ind.getChromosome().get(4) - 92.0;
            g[1] = -85.334407 - 0.0056858*ind.getChromosome().get(1)*ind.getChromosome().get(4) -
                    0.0006262*ind.getChromosome().get(0)*ind.getChromosome().get(3) +
                    0.0022053*ind.getChromosome().get(2)*ind.getChromosome().get(4);
            g[2] = 80.51249 + 0.0071317*ind.getChromosome().get(1)*ind.getChromosome().get(4) +
                    0.0029955*ind.getChromosome().get(0)*ind.getChromosome().get(1) +
                    0.0021813*Math.pow(ind.getChromosome().get(2), 2.0) - 110.0;
            g[3] = -80.51249 - 0.0071317*ind.getChromosome().get(1)*ind.getChromosome().get(4) -
                    0.0029955*ind.getChromosome().get(0)*ind.getChromosome().get(1) -
                    0.0021813*Math.pow(ind.getChromosome().get(2), 2.0) + 90.0;
            g[4] = 9.300961 + 0.0047026*ind.getChromosome().get(2)*ind.getChromosome().get(4) +
                    0.0012547*ind.getChromosome().get(0)*ind.getChromosome().get(2) +
                    0.0019085*ind.getChromosome().get(2)*ind.getChromosome().get(3) - 25.0;
            g[5] = -9.300961 - 0.0047026*ind.getChromosome().get(2)*ind.getChromosome().get(4) -
                    0.0012547*ind.getChromosome().get(0)*ind.getChromosome().get(2) -
                    0.0019085*ind.getChromosome().get(2)*ind.getChromosome().get(3) + 20.0;
            
            for(int i = 0; i < ind.getNumRest(); i++)
                ind.getRestrictions().set(i, g[i]);
            
        }
    }

    @Override
    public void calculateSumOfRestrictions() {
        super.getPenaltyFunction().calculateSumOfRestrictions();
    }
    
}
