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
public class RestrictionG10 extends RestrictionFunctions{

    public RestrictionG10(ArrayList<Individual> population, PenaltyFunction penaltyFunction) {
        super(population, penaltyFunction);
    }

    @Override
    public void calculateRestrictions() {
        double g[] = {0.0,0.0,0.0,0.0,0.0,0.0};
        for(Individual ind: super.getPopulation()){
            g[0] = - 1.0 + 0.0025*(ind.getChromosome().get(3) + ind.getChromosome().get(5));
            g[1] = - 1.0 + 0.0025*(ind.getChromosome().get(4) + ind.getChromosome().get(6) - ind.getChromosome().get(3));
            g[2] = - 1.0 +0.01*(ind.getChromosome().get(7) - ind.getChromosome().get(4));
            g[3] = - (ind.getChromosome().get(0)*ind.getChromosome().get(5)) + 833.33252*ind.getChromosome().get(3)
                    + 100.0*ind.getChromosome().get(0) - 83333.333;
            g[4] = - (ind.getChromosome().get(1)*ind.getChromosome().get(6)) + 1250.0*ind.getChromosome().get(4)
                    + (ind.getChromosome().get(1)*ind.getChromosome().get(3)) - 1250.0*ind.getChromosome().get(3);
            g[5] = - (ind.getChromosome().get(2)*ind.getChromosome().get(7)) + 1250000.0 
                    + (ind.getChromosome().get(2)*ind.getChromosome().get(4)) - 2500.0*ind.getChromosome().get(4);
            
            for(int i = 0; i < ind.getNumRest(); i++)
                ind.getRestrictions().set(i, g[i]);
                
        }
    }

    @Override
    public void calculateSumOfRestrictions() {
        super.getPenaltyFunction().calculateSumOfRestrictions();
    }
    
    
}
