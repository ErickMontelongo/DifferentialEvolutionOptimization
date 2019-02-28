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
public class RestrictionG8 extends RestrictionFunctions{

    public RestrictionG8(ArrayList<Individual> population, PenaltyFunction penaltyFunction) {
        super(population, penaltyFunction);
    }

    @Override
    public void calculateRestrictions() {
        double g[] = {0.0,0.0};
        for(Individual ind: super.getPopulation()){
            g[0] = Math.pow(ind.getChromosome().get(0), 2.0) - ind.getChromosome().get(1) + 1.0;
            g[1] = 1.0 - ind.getChromosome().get(0) + Math.pow(ind.getChromosome().get(1) - 4.0, 2.0);
            for(int i = 0; i < ind.getNumRest(); i++)
                ind.getRestrictions().set(i, g[i]);
        }
    }

    @Override
    public void calculateSumOfRestrictions() {
        super.getPenaltyFunction().calculateSumOfRestrictions();
    }
    
}
