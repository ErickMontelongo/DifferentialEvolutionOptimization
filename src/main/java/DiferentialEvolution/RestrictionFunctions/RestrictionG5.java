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
 * @author Punkid PC
 */
public class RestrictionG5 extends RestrictionFunctions{

    public RestrictionG5(ArrayList<Individual> population, PenaltyFunction penaltyFunction) {
        super(population, penaltyFunction);
    }

    @Override
    public void calculateRestrictions() {
        double g[] = {0.0,0.0,0.0,0.0,0.0};
        double epsilon = 1.0*Math.pow(10.0, - 4.0);
        for(Individual ind: super.getPopulation()){
            g[0] = - ind.getChromosome().get(3) + ind.getChromosome().get(2) - 0.55;
            g[1] = - ind.getChromosome().get(2) + ind.getChromosome().get(3) -0.55;
            g[2] = Math.abs(1000.0*Math.sin(-ind.getChromosome().get(2) - 0.25) + 1000.0*Math.sin(-ind.getChromosome().get(3) - 0.25) +
                    894.8 - ind.getChromosome().get(0)) - epsilon;
            g[3] = Math.abs(1000.0*Math.sin(ind.getChromosome().get(2) - 0.25) + 1000.0*Math.sin(ind.getChromosome().get(2) - ind.getChromosome().get(3) - 0.25) +
                    894.8 - ind.getChromosome().get(1)) - epsilon;
            g[4] = Math.abs(1000.0*Math.sin(ind.getChromosome().get(3) - 0.25) + 1000.0*Math.sin(ind.getChromosome().get(3) - ind.getChromosome().get(2) - 0.25) +
                    1294.8) - epsilon;
            for(int i = 0; i < ind.getNumRest(); i++)
                ind.getRestrictions().set(i, g[i]);
        }
    }

    @Override
    public void calculateSumOfRestrictions() {
        super.getPenaltyFunction().calculateSumOfRestrictions();
    }
    
}
