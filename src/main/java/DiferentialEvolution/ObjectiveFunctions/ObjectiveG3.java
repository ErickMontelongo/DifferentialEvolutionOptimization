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
public class ObjectiveG3 extends ObjectiveFunction{

    public ObjectiveG3(ArrayList<Individual> population) {
        super(population);
    }

    @Override
    public void calculateObjFunction() {
        double mul = 1.0;
        for(Individual ind: super.getPopulation()){
            for(Double varValue: ind.getChromosome())
                mul *= varValue;
            double value = (Math.pow(Math.sqrt(ind.getNumVar()), ind.getNumVar())*mul);
            ind.setObjValue(value);
            ind.setFitness(value);
            mul = 1.0;
        }
    }
    
}
