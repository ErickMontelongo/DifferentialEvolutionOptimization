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
public class ObjectiveG8 extends ObjectiveFunction{

    public ObjectiveG8(ArrayList<Individual> population) {
        super(population);
    }

    @Override
    public void calculateObjFunction() {
        double res = 0.0;
        for(Individual ind: super.getPopulation()){
            double up = ((Math.pow(Math.sin(2.0*Math.PI*ind.getChromosome().get(0)), 3.0))*Math.sin(2.0*Math.PI*ind.getChromosome().get(1)));
            double down = ((Math.pow(ind.getChromosome().get(0), 3.0)*(ind.getChromosome().get(0) + ind.getChromosome().get(1))));
            ind.setObjValue(up/down);
            ind.setFitness((up/down));
        }
    }
    
}
