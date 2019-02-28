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
public class ObjectiveG7 extends ObjectiveFunction{

    public ObjectiveG7(ArrayList<Individual> population) {
        super(population);
    }

    @Override
    public void calculateObjFunction() {
        double res = 0.0;
        for(Individual ind: super.getPopulation()){
            res = Math.pow(ind.getChromosome().get(0), 2.0) + Math.pow(ind.getChromosome().get(1), 2.0) + ind.getChromosome().get(0)*ind.getChromosome().get(1)
                    -14.0*ind.getChromosome().get(0) - 16.0*ind.getChromosome().get(1) + Math.pow(ind.getChromosome().get(2) - 10.0, 2.0)
                    + 4.0*Math.pow(ind.getChromosome().get(3) - 5.0, 2.0) + Math.pow(ind.getChromosome().get(4) - 3.0, 2.0) + 2.0*Math.pow(ind.getChromosome().get(5) - 1.0, 2.0)
                    + 5.0*Math.pow(ind.getChromosome().get(6), 2.0) + 7.0*Math.pow(ind.getChromosome().get(7) - 11.0, 2.0) + 2.0*Math.pow(ind.getChromosome().get(8) - 10.0, 2.0)
                    + Math.pow(ind.getChromosome().get(9) - 7.0, 2.0) + 45.0;
            ind.setObjValue(res);
            ind.setFitness(-res);
        }
    }
    
}
