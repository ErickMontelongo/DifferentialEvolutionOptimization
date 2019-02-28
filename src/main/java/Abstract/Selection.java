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
public abstract class Selection {
    private ArrayList<Individual> oldPopulation;
    private ArrayList<Individual> newPopulation;
    private double prob;
    
    public Selection(ArrayList<Individual> old, ArrayList<Individual> newPop, double probability){
        oldPopulation = old;
        newPopulation = newPop;
        prob = probability;
    }

    public ArrayList<Individual> getOldPopulation() {
        return oldPopulation;
    }

    public void setOldPopulation(ArrayList<Individual> oldPopulation) {
        this.oldPopulation = oldPopulation;
    }

    public ArrayList<Individual> getNewPopulation() {
        return newPopulation;
    }

    public void setNewPopulation(ArrayList<Individual> newPopulation) {
        this.newPopulation = newPopulation;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    
    
    
    public abstract ArrayList<Individual> selectIndividuals();
}
