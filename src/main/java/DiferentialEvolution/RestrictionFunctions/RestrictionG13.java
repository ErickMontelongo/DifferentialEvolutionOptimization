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
public class RestrictionG13 extends RestrictionFunctions{

    public RestrictionG13(ArrayList<Individual> population, PenaltyFunction penaltyFunction) {
        super(population, penaltyFunction);
    }

    @Override
    public void calculateRestrictions() {
        double g[] = {0.0,0.0,0.0};
        double epsilon = 1.0*Math.pow(10.0, - 4.0);
        double sum = 0.0;
        for(Individual ind: super.getPopulation()){
            sum = 0.0;
            for(Double varValue: ind.getChromosome())
                sum += Math.pow(varValue, 2.0);
            g[0] = Math.abs(sum - 10.0) - epsilon;
            g[1] = Math.abs(ind.getChromosome().get(1)*ind.getChromosome().get(2) - 5.0*ind.getChromosome().get(3)*ind.getChromosome().get(4)) - epsilon;
            g[2] = Math.abs(Math.pow(ind.getChromosome().get(0), 3.0) + Math.pow(ind.getChromosome().get(1), 3.0) + 1.0) - epsilon;
            for(int i = 0; i < ind.getNumRest(); i++)
                ind.getRestrictions().set(i, g[i]);
            
        }
    }

    @Override
    public void calculateSumOfRestrictions() {
       super.getPenaltyFunction().calculateSumOfRestrictions();
    }
    
}
 