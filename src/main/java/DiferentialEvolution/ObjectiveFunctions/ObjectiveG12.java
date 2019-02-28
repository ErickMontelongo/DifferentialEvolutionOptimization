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
public class ObjectiveG12 extends ObjectiveFunction{

    public ObjectiveG12(ArrayList<Individual> population) {
        super(population);
    }

    @Override
    public void calculateObjFunction() {
        double res = 0.0;
        for(Individual ind: super.getPopulation()){
            res = 100.0 - Math.pow(ind.getChromosome().get(0) - 5.0 , 2.0) - Math.pow(ind.getChromosome().get(1) - 5.0, 2.0)
                    - Math.pow(ind.getChromosome().get(2) - 5.0, 2.0);
            ind.setObjValue(res/100.0);
            ind.setFitness(res/100.0);
        }
    }
    
}
