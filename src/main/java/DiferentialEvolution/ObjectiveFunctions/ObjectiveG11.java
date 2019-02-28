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
public class ObjectiveG11 extends ObjectiveFunction{

    public ObjectiveG11(ArrayList<Individual> population) {
        super(population);
    }

    @Override
    public void calculateObjFunction() {
        for(Individual ind: super.getPopulation()){
            double value = Math.pow(ind.getChromosome().get(0), 2.0) + Math.pow(ind.getChromosome().get(1) - 1.0, 2.0);
            ind.setObjValue(value);
            ind.setFitness(-value);
        }
    }
    
}
