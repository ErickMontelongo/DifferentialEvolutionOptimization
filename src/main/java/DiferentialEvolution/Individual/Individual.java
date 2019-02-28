/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiferentialEvolution.Individual;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author erick
 */
public class Individual {
    private ArrayList<Double> chromosome;
    private int numVar;
    private ArrayList<Double> restrictions;
    private int numRest;
    private double objValue;
    private double fitness;
    private double sumOfRestrictions;
    private boolean isFact;
    
    public Individual(int var, int rest){
        chromosome = new ArrayList<>(var);
        numVar = var;
        restrictions = new ArrayList<>(rest);
        numRest = rest;
        objValue = 0.0;
        fitness = 0.0;
        sumOfRestrictions = 0.0;
    }
    
    public Individual(Individual ind){
        chromosome = ind.getChromosome();
        numVar = ind.getNumVar();
        restrictions = ind.getRestrictions();
        numRest = ind.numRest;
        objValue = ind.objValue;
        fitness = ind.fitness;
        sumOfRestrictions = ind.sumOfRestrictions;
    }

    public ArrayList<Double> getChromosome() {
        return chromosome;
    }

    public void setChromosome(ArrayList<Double> chromosome) {
        this.chromosome = chromosome;
    }

    public int getNumVar() {
        return numVar;
    }

    public void setNumVar(int numVar) {
        this.numVar = numVar;
    }

    public ArrayList<Double> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(ArrayList<Double> restrictions) {
        this.restrictions = restrictions;
    }

    public int getNumRest() {
        return numRest;
    }

    public void setNumRest(int numRest) {
        this.numRest = numRest;
    }

    public double getObjValue() {
        return objValue;
    }

    public void setObjValue(double objValue) {
        this.objValue = objValue;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getSumOfRestrictions() {
        return sumOfRestrictions;
    }

    public void setSumOfRestrictions(double sumOfRestrictions) {
        this.sumOfRestrictions = sumOfRestrictions;
    }

    public boolean isIsFact() {
        return isFact;
    }

    public void setIsFact(boolean isFact) {
        this.isFact = isFact;
    }
    
    public void CopyIndividual(Individual ind){
        Collections.copy(chromosome, ind.getChromosome());
        Collections.copy(restrictions, ind.getRestrictions());
        objValue = ind.getObjValue();
        fitness = ind.getFitness();
        sumOfRestrictions = ind.getSumOfRestrictions();
        isFact = ind.isIsFact();
        
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Vector: ").append(chromosome.toString()).append("\n");
        for(int i = 0; i < numRest; i++){
            sb.append("Restriction ").append(i+1).append(": ").append(restrictions.get(i)).append("\n");
        }
        if(isFact)
            sb.append("FEASIBLE SOLUTION").append("\n");
        else
            sb.append("UNFEASIBLE SOLUTION").append("\n");
        sb.append("Value of f(x): ").append(objValue);
        return sb.toString();
    }
    

    
    
    
    
}
