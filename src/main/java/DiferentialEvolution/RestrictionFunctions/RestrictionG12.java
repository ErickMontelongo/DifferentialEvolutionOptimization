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
public class RestrictionG12 extends RestrictionFunctions{

    public RestrictionG12(ArrayList<Individual> population, PenaltyFunction penaltyFunction) {
        super(population, penaltyFunction);
    }

    @Override
    public void calculateRestrictions() {
        int p = 1;
        int q = 1;
        int r = 1;
        double sum = 0.0;
        double aux = 0.0;
        boolean enter = false;
        for(Individual ind: super.getPopulation()){
            
            while((p <= 9)&&!(enter)){
                q = 1;
                while((q <= 9) && !(enter)){
                    r = 1;
                    while((r <= 9)&&!(enter)){
                        aux = Math.pow(ind.getChromosome().get(0) - p, 2.0) + Math.pow(ind.getChromosome().get(1) - q, 2.0) 
                                + Math.pow(ind.getChromosome().get(2) - r, 2.0) - 0.0625;
                        if(aux <= 0.0)
                            enter = true;
                        else
                            sum += aux;
                        r++;
                    }
                    q++;
                }
                p++;
            }
            if(enter)
                ind.getRestrictions().set(0, 0.0);
            else
                ind.getRestrictions().set(0, sum);
            p = 1;
            sum = 0.0;
        }
    }

    @Override
    public void calculateSumOfRestrictions() {
        super.getPenaltyFunction().calculateSumOfRestrictions();
    }
    
}
