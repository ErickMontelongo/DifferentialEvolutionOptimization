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
 * @author Punkid PC
 */
public abstract class FunctionSuite {
    private ArrayList<Individual> pop;
    private ObjectiveFunction objFunction;
    private RestrictionFunctions restFunction;
    private ArrayList<Double> upBounds;
    private ArrayList<Double> dwnBounds;
    private int numVar;
    private int numRest;

    public FunctionSuite(ArrayList<Individual> ind) {
        pop = ind;
    }

    public ObjectiveFunction getObjFunction() {
        return objFunction;
    }

    public void setObjFunction(ObjectiveFunction objFunction) {
        this.objFunction = objFunction;
    }

    public RestrictionFunctions getRestFunction() {
        return restFunction;
    }

    public void setRestFunction(RestrictionFunctions restFunction) {
        this.restFunction = restFunction;
    }

    public ArrayList<Double> getUpBounds() {
        return upBounds;
    }

    public void setUpBounds(ArrayList<Double> upBounds) {
        this.upBounds = upBounds;
    }

    public ArrayList<Double> getDwnBounds() {
        return dwnBounds;
    }

    public void setDwnBounds(ArrayList<Double> dwnBounds) {
        this.dwnBounds = dwnBounds;
    }

    public ArrayList<Individual> getPop() {
        return pop;
    }

    public void setPop(ArrayList<Individual> pop) {
        this.pop = pop;
    }

    public int getNumVar() {
        return numVar;
    }

    public void setNumVar(int numVar) {
        this.numVar = numVar;
    }

    public int getNumRest() {
        return numRest;
    }

    public void setNumRest(int numRest) {
        this.numRest = numRest;
    }
    
    
    
    
    
    public abstract void calculateObjValue();
    public abstract void calculateSumOfRest();
}
