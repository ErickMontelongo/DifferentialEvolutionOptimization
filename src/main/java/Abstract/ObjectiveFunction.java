package Abstract;

import DiferentialEvolution.Individual.Individual;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erick
 */
public abstract class ObjectiveFunction {
    
    private ArrayList<Individual> population;

    public ObjectiveFunction(ArrayList<Individual> population) {
        this.population = population;
    }

    public ArrayList<Individual> getPopulation() {
        return population;
    }
    
    public abstract void calculateObjFunction();
    
}
