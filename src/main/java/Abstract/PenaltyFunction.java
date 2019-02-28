/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Abstract;

import DiferentialEvolution.Individual.Individual;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public abstract class PenaltyFunction {
    
    private ArrayList<Individual> population;
    
    public PenaltyFunction(ArrayList<Individual> pop){
        population = pop;
    }

    public ArrayList<Individual> getPopulation() {
        return population;
    }

    public void setPopulation(ArrayList<Individual> population) {
        this.population = population;
    }
    
    
    
    public abstract void calculateSumOfRestrictions();
    
    
}
