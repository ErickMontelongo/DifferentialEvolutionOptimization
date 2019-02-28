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
 * @author Punkid PC
 */
public class ObjectiveG5 extends ObjectiveFunction{

    public ObjectiveG5(ArrayList<Individual> population) {
        super(population);
    }

    @Override
    public void calculateObjFunction() {
        
        for(Individual ind: super.getPopulation()){
            double value = 3.0*ind.getChromosome().get(0) + 0.000001*Math.pow(ind.getChromosome().get(0), 3.0) +
                            2.0*ind.getChromosome().get(1) + ((0.000002)/(3.0))*Math.pow(ind.getChromosome().get(1), 3.0);
            ind.setObjValue(value);
            ind.setFitness(-value);
        }
    }
    
}
