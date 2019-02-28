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
public class RestrictionG9 extends RestrictionFunctions{

    public RestrictionG9(ArrayList<Individual> population, PenaltyFunction penaltyFunction) {
        super(population, penaltyFunction);
    }

    @Override
    public void calculateRestrictions() {
        double g[] = {0.0,0.0,0.0,0.0};
        for(Individual ind: super.getPopulation()){
            g[0] = -127.0 + 2.0*Math.pow(ind.getChromosome().get(0), 2.0) + 3.0*Math.pow(ind.getChromosome().get(1), 4.0)
                    + ind.getChromosome().get(2) + 4.0*Math.pow(ind.getChromosome().get(3), 2.0) + 5.0*ind.getChromosome().get(4);
            g[1] = - 282.0 + 7.0*ind.getChromosome().get(0) + 3.0*ind.getChromosome().get(1) + 10.0*Math.pow(ind.getChromosome().get(2), 2.0)
                    + ind.getChromosome().get(3) - ind.getChromosome().get(4);
            g[2] = - 196.0 + 23.0*ind.getChromosome().get(0) + Math.pow(ind.getChromosome().get(1), 2.0) + 6.0*Math.pow(ind.getChromosome().get(5), 2.0)
                    - 8.0*ind.getChromosome().get(6);
            g[3] = 4.0*Math.pow(ind.getChromosome().get(0), 2.0) + Math.pow(ind.getChromosome().get(1), 2.0) - 3.0*ind.getChromosome().get(0)*ind.getChromosome().get(1)
                    + 2.0*Math.pow(ind.getChromosome().get(2), 2.0) + 5.0*ind.getChromosome().get(5) - 11.0*ind.getChromosome().get(6);
            for(int i = 0; i < ind.getNumRest(); i++)
                ind.getRestrictions().set(i, g[i]);
        }
    }

    @Override
    public void calculateSumOfRestrictions() {
        super.getPenaltyFunction().calculateSumOfRestrictions();
    }
    
}
