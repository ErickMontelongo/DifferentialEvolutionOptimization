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
public class RestrictionG2 extends RestrictionFunctions {

    public RestrictionG2(ArrayList<Individual> population, PenaltyFunction penaltyFunction) {
        super(population, penaltyFunction);
    }

    @Override
    public void calculateRestrictions() {
        double g[] = {0.0, 0.0};
        double sum = 0.0;
        double mul = 1.0;
        for(Individual ind: super.getPopulation()){
            
            for(Double varValue: ind.getChromosome()){
                mul *= varValue;
                sum += varValue;
            }
            g[0] = 0.75 - mul;
            g[1] = sum - 7.5*ind.getNumVar();
            
            for(int i = 0; i < ind.getNumRest(); i++ ){
                ind.getRestrictions().set(i, g[i]);
                g[i] = 0.0;
            }
            sum = 0.0;
            mul = 1.0;

        }
    }

    @Override
    public void calculateSumOfRestrictions() {
        super.getPenaltyFunction().calculateSumOfRestrictions();
    }
    
}
