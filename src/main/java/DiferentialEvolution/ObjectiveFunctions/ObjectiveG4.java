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
public class ObjectiveG4 extends ObjectiveFunction{

    public ObjectiveG4(ArrayList<Individual> population) {
        super(population);
    }

    @Override
    public void calculateObjFunction() {
        for(Individual ind: super.getPopulation()){
           double value = 5.3578547*Math.pow(ind.getChromosome().get(2), 2.0) +
                            0.8356891*ind.getChromosome().get(0)*ind.getChromosome().get(4) +
                            37.293239*ind.getChromosome().get(0) - 40792.141;
           ind.setObjValue(value);
           ind.setFitness(-value);
        }
    }
    
}
