/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiferentialEvolution.PenaltyFunctions;

import Abstract.PenaltyFunction;
import DiferentialEvolution.Individual.Individual;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class QuadraticLossFunction extends PenaltyFunction {

    public QuadraticLossFunction(ArrayList<Individual> pop) {
        super(pop);
    }

    @Override
    public void calculateSumOfRestrictions() {
        double sum = 0.0;
        for(Individual ind: super.getPopulation()){
            for(Double restValue: ind.getRestrictions())
                    sum += Math.pow(Math.max(0.0, restValue), 2.0);  
            ind.setSumOfRestrictions(sum);
            if(sum <= 0.0)
                ind.setIsFact(true);
            else
                ind.setIsFact(false);
            sum = 0.0;
        }
    }
    
}
