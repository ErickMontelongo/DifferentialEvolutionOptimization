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
public class RestrictionG1 extends RestrictionFunctions {

    public RestrictionG1(ArrayList<Individual> population, PenaltyFunction penaltyFunction) {
        super(population, penaltyFunction);
    }

    @Override
    public void calculateRestrictions() {
        double g1 = 0.0;
        double g2 = 0.0;
        double g3 = 0.0;
        double g4 = 0.0;
        double g5 = 0.0;
        double g6 = 0.0;
        double g7 = 0.0;
        double g8 = 0.0;
        double g9 = 0.0;
        for(Individual ind: super.getPopulation()){
            g1 = 2.0*ind.getChromosome().get(0) + 2.0*ind.getChromosome().get(1) +
                        ind.getChromosome().get(9) + ind.getChromosome().get(10) - 10.0;
            g2 = 2.0*ind.getChromosome().get(0) + 2.0*ind.getChromosome().get(2) +
                        ind.getChromosome().get(9) + ind.getChromosome().get(11) - 10.0;
            g3 = 2.0*ind.getChromosome().get(1) + 2.0*ind.getChromosome().get(2) +
                        ind.getChromosome().get(10) + ind.getChromosome().get(11) - 10.0;
            g4 = -8.0*ind.getChromosome().get(0) + ind.getChromosome().get(9);
            g5 = -8.0*ind.getChromosome().get(1) + ind.getChromosome().get(10);
            g6 = -8.0*ind.getChromosome().get(2) + ind.getChromosome().get(11);
            g7 = -2.0*ind.getChromosome().get(3) - ind.getChromosome().get(4) +
                        ind.getChromosome().get(9);
            g8 = -2.0*ind.getChromosome().get(5) - ind.getChromosome().get(6) +
                        ind.getChromosome().get(10);
            g9 = -2.0*ind.getChromosome().get(7) - ind.getChromosome().get(8) +
                        ind.getChromosome().get(11);
            ind.getRestrictions().set(0, g1);
            ind.getRestrictions().set(1, g2);
            ind.getRestrictions().set(2, g3);
            ind.getRestrictions().set(3, g4);
            ind.getRestrictions().set(4, g5);
            ind.getRestrictions().set(5, g6);
            ind.getRestrictions().set(6, g7);
            ind.getRestrictions().set(7, g8);
            ind.getRestrictions().set(8, g9);
        }
    }

    @Override
    public void calculateSumOfRestrictions() {
        super.getPenaltyFunction().calculateSumOfRestrictions();
    }
    
}
