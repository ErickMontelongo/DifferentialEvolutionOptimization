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
public class ObjectiveG13 extends ObjectiveFunction{

    public ObjectiveG13(ArrayList<Individual> population) {
        super(population);
    }

    @Override
    public void calculateObjFunction() {
        double res = 1.0;
        for(Individual ind: super.getPopulation()){
            for(Double resValue: ind.getChromosome())
                res *= resValue;
            ind.setObjValue(Math.exp(res));
            ind.setFitness(-Math.exp(res));
            res = 1.0;
        }
    }
    
}
