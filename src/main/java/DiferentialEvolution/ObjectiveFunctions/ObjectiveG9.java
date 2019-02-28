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
public class ObjectiveG9 extends ObjectiveFunction{

    public ObjectiveG9(ArrayList<Individual> population) {
        super(population);
    }

    @Override
    public void calculateObjFunction() {
        double res = 0.0;
        for(Individual ind: super.getPopulation()){
            res = Math.pow(ind.getChromosome().get(0) - 10.0, 2.0) + 5.0*Math.pow(ind.getChromosome().get(1) - 12.0, 2.0)
                    + Math.pow(ind.getChromosome().get(2), 4.0) + 3.0*Math.pow(ind.getChromosome().get(3) - 11.0, 2.0)
                    + 10.0*Math.pow(ind.getChromosome().get(4), 6.0) + 7.0*Math.pow(ind.getChromosome().get(5), 2.0)
                    + Math.pow(ind.getChromosome().get(6), 4.0) - 4.0*ind.getChromosome().get(5)*ind.getChromosome().get(6)
                    - 10.0*ind.getChromosome().get(5) - 8.0*ind.getChromosome().get(6);
            ind.setObjValue(res);
            ind.setFitness(-res);
        }
    }
    
}
