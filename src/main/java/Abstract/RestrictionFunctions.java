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
public abstract class RestrictionFunctions {
    private ArrayList<Individual> population;
    private PenaltyFunction penaltyFunction;

    public RestrictionFunctions(ArrayList<Individual> population, PenaltyFunction penaltyFunction) {
        this.population = population;
        this.penaltyFunction = penaltyFunction;
    }

    public ArrayList<Individual> getPopulation() {
        return population;
    }

    public PenaltyFunction getPenaltyFunction() {
        return penaltyFunction;
    }
    
    public abstract void calculateRestrictions();
    
    public abstract void calculateSumOfRestrictions();
    
}
