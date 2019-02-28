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
public class RestrictionG7 extends RestrictionFunctions{

    public RestrictionG7(ArrayList<Individual> population, PenaltyFunction penaltyFunction) {
        super(population, penaltyFunction);
    }

    @Override
    public void calculateRestrictions() {
        double g[] = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        for(Individual ind: super.getPopulation()){
            g[0] = - 105.0 + 4.0*ind.getChromosome().get(0) + 5.0*ind.getChromosome().get(1)
                    - 3.0*ind.getChromosome().get(6) + 9.0*ind.getChromosome().get(7);
            g[1] = 10.0*ind.getChromosome().get(0) - 8.0*ind.getChromosome().get(1) 
                    - 17.0*ind.getChromosome().get(6) + 2.0*ind.getChromosome().get(7);
            g[2] = - 8.0*ind.getChromosome().get(0) + 2.0*ind.getChromosome().get(1)
                    + 5.0*ind.getChromosome().get(8) - 2.0*ind.getChromosome().get(9) - 12.0;
            g[3] = 3.0*Math.pow(ind.getChromosome().get(0) - 2.0, 2.0) + 4.0*Math.pow(ind.getChromosome().get(1) - 3.0, 2.0)
                    + 2.0*Math.pow(ind.getChromosome().get(2), 2.0) - 7.0*ind.getChromosome().get(3) - 120.0;
            g[4] = 5.0*Math.pow(ind.getChromosome().get(0), 2.0) + 8.0*ind.getChromosome().get(1)
                    + Math.pow(ind.getChromosome().get(2) - 6.0, 2.0) - 2.0*ind.getChromosome().get(3) - 40.0;
            g[5] = Math.pow(ind.getChromosome().get(0), 2.0) + 2.0*Math.pow(ind.getChromosome().get(1) - 2.0, 2.0)
                    - 2.0*ind.getChromosome().get(0)*ind.getChromosome().get(1) + 14.0*ind.getChromosome().get(4) - 6.0*ind.getChromosome().get(5);
            g[6] = 0.5*Math.pow(ind.getChromosome().get(0) - 8.0, 2.0) + 2.0*Math.pow(ind.getChromosome().get(1) - 4.0, 2.0)
                    + 3.0*Math.pow(ind.getChromosome().get(4), 2.0) - ind.getChromosome().get(5) - 30.0;
            g[7] = - 3.0*ind.getChromosome().get(0) + 6.0*ind.getChromosome().get(1)
                    + 12.0*Math.pow(ind.getChromosome().get(8) - 8.0, 2.0) - 7.0*ind.getChromosome().get(9);
            
            for(int i = 0; i < ind.getNumRest(); i++)
                ind.getRestrictions().set(i, g[i]);
        }
    }

    @Override
    public void calculateSumOfRestrictions() {
        super.getPenaltyFunction().calculateSumOfRestrictions();
    }
    
}
