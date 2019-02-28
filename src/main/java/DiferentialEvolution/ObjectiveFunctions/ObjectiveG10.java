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
public class ObjectiveG10 extends ObjectiveFunction{

    public ObjectiveG10(ArrayList<Individual> population) {
        super(population);
    }

    @Override
    public void calculateObjFunction() {
        for(Individual ind: super.getPopulation()){
            double value = ind.getChromosome().get(0) + ind.getChromosome().get(1) + ind.getChromosome().get(2);
            ind.setObjValue(value);
            ind.setFitness(-value);
        }
    }
    
}
