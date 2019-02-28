/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiferentialEvolution.ObjectiveFunctions;

import Abstract.ObjectiveFunction;
import DiferentialEvolution.Individual.Individual;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class ObjectiveG2 extends ObjectiveFunction{

    public ObjectiveG2(ArrayList<Individual> population) {
        super(population);
    }

    @Override
    public void calculateObjFunction() {
        double sum1 = 0.0;
        double mul = 1.0;
        double sum2 = 0.0;
        for(Individual ind: super.getPopulation()){
            for(int i = 0; i < ind.getNumVar(); i++)
                sum1 += Math.pow(Math.cos(ind.getChromosome().get(i)), 4.0);
            for(int i = 0; i < ind.getNumVar(); i++)
                mul *= Math.pow(Math.cos(ind.getChromosome().get(i)), 2.0);
            for(int i = 1; i <= ind.getNumVar(); i++)
                sum2 += i*Math.pow(ind.getChromosome().get(i-1), 2.0);
            double value = Math.abs((sum1 - 2.0*mul)/Math.sqrt(sum2));
            ind.setObjValue(value);
            ind.setFitness(value);
            sum1 = 0.0;
            mul = 1.0;
            sum2 = 0.0;
        }
    }
    
}
