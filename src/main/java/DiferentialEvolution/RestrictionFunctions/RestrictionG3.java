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
public class RestrictionG3 extends RestrictionFunctions{

    public RestrictionG3(ArrayList<Individual> population, PenaltyFunction penaltyFunction) {
        super(population, penaltyFunction);
    }

    @Override
    public void calculateRestrictions() {
        double epsilon = 1.0*Math.pow(10.0, - 4.0);
        double sum = 0.0;
        for(Individual ind: super.getPopulation()){
            for(Double varValues: ind.getChromosome())
                sum += Math.pow(varValues, 2.0);
            ind.getRestrictions().set(0, Math.abs(sum - 1.0) - epsilon);
            sum = 0.0;
        }
    }

    @Override
    public void calculateSumOfRestrictions() {
        super.getPenaltyFunction().calculateSumOfRestrictions();
    }
    
}
