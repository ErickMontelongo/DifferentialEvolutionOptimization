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
public class ObjectiveG1 extends ObjectiveFunction {
    
    public ObjectiveG1(ArrayList<Individual> population) {
        super(population);
    }

    @Override
    public void calculateObjFunction() {
       double sum1 = 0.0;
       double sum2 = 0.0;
       double sum3 = 0.0;
       for(Individual ind: super.getPopulation()){
           for(int i = 0; i < 4; i++)
               sum1 += ind.getChromosome().get(i);
           for(int i = 0; i < 4; i++)
               sum2 += Math.pow(ind.getChromosome().get(i), 2.0);
           for(int i = 4; i< 13; i++)
               sum3 += ind.getChromosome().get(i);
           double value = 5.0*sum1 -5.0*sum2 -sum3;
           
           ind.setObjValue(value);
           ind.setFitness(-value);
           sum1=0.0;
           sum2=0.0;
           sum3=0.0;
       }
    }
    
}
