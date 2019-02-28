/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectofinalevolutivos;

import Abstract.FunctionSuite;
import Abstract.Selection;
import DiferentialEvolution.Core.FunctionFactory;
import DiferentialEvolution.Core.SMESelection;
import DiferentialEvolution.Core.StochasticRanking;
import DiferentialEvolution.Functions.FunctionG1;
import DiferentialEvolution.Individual.Individual;
import DiferentialEvolution.Individual.SortByBestGlobal;
import DiferentialEvolution.Individual.SortByBestInfact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Punkid PC
 */
public class DifferentialEvolution {
    private ArrayList<Individual> oldPop;
    private ArrayList<Individual> newPop;
    FunctionSuite oldPopSuite;
    FunctionSuite newPopSuite;
    private int constraintSel;
    private int functionSel;
    private int maxGen;
    private int popSize;
    private double cr;
    private double wFactor;
    private double compProb;
    private Selection selection;
    private Random randomGenerator;
    private String strategy;
    private Individual best;

    public DifferentialEvolution(int constraintSel, int functionSel, int maxGen, int popSize, double cr, double wFactor, double compProb) {
        this.constraintSel = constraintSel;
        this.functionSel = functionSel;
        this.maxGen = maxGen;
        this.popSize = popSize;
        this.cr = cr;
        this.wFactor = wFactor;
        this.compProb = compProb;
        randomGenerator = new Random();
        oldPop = new ArrayList<>(popSize);
        newPop = new ArrayList<>(popSize);
        selectFunctionSuite();
        if(constraintSel == 1){
            selection = new SMESelection(oldPop, newPop, compProb);
            strategy = "Differential Evolution with SMES";
        }
        else{
            selection = new StochasticRanking(oldPop, newPop, compProb);
            strategy = "Differential Evolution with Stochastic Ranking";
        }
    }

    
    private void selectFunctionSuite(){
        FunctionFactory factory = new FunctionFactory();
        oldPopSuite = factory.getFunctionSuite(oldPop, functionSel);
        newPopSuite = factory.getFunctionSuite(newPop, functionSel);
        best = new Individual(oldPopSuite.getNumVar(), oldPopSuite.getNumRest());
    }
    
    private double randomInRange(double min, double max){
        double ret = min + (max - min) * randomGenerator.nextDouble();
        return  ret;
    }
    
    private int IntInRange(int max){
        int ret = randomGenerator.nextInt(max);
        return ret;
    }
    
    private void initializePopulation(){
        for(int i = 0; i < popSize; i++){
           oldPop.add(new Individual(oldPopSuite.getNumVar(), oldPopSuite.getNumRest()));
           newPop.add(new Individual(oldPopSuite.getNumVar(), oldPopSuite.getNumRest()));
           for(int j = 0; j < oldPopSuite.getNumVar(); j++){
            oldPop.get(i).getChromosome().add(randomInRange(oldPopSuite.getDwnBounds().get(j), oldPopSuite.getUpBounds().get(j)));
            newPop.get(i).getChromosome().add(0.0);
           }
           for(int j = 0; j < oldPopSuite.getNumRest(); j++){
                oldPop.get(i).getRestrictions().add(0.0);
                newPop.get(i).getRestrictions().add(0.0);
           }
        }

    }
    
    private ArrayList<Integer> selectIndexes(int thisIndex){
        ArrayList<Integer> aux = new ArrayList<>(3);
        for(int i = 0; i < 3; i++){
            int x = IntInRange(oldPop.size());
            while(aux.contains(x) || x == thisIndex)
                x = IntInRange(oldPop.size());
            aux.add(x);
        }
        return aux;
    }
    
    private void mutateIndividual(ArrayList<Individual> randomVectors, Individual target, Individual trial){
        double value = 0.0;
        for(int i = 0; i < target.getNumVar(); i++){
            value = randomVectors.get(0).getChromosome().get(i) + wFactor*(randomVectors.get(1).getChromosome().get(i) - randomVectors.get(2).getChromosome().get(i));
            if(value < oldPopSuite.getDwnBounds().get(i) || value > oldPopSuite.getUpBounds().get(i))
                value = randomInRange(oldPopSuite.getDwnBounds().get(i), oldPopSuite.getUpBounds().get(i));
            trial.getChromosome().set(i, value);
        }
    }
    
    private void crossover(Individual original, Individual mutated){
        int k = IntInRange(original.getNumVar());
        for(int j = 0; j < original.getNumVar(); j++){
            if((randomInRange(0.0,1.0) > cr) && (j != k))
                mutated.getChromosome().set(j, original.getChromosome().get(j));      
        }
    }
    
    public void runAlgorithm(){
        initializePopulation();
        oldPopSuite.calculateObjValue();
        oldPopSuite.calculateSumOfRest();
        refreshFact(oldPop);
        
        for(int t = 1; t < maxGen; t++){
            
            for(int i = 0; i < popSize; i++){
                ArrayList<Integer> indexOfVectors = selectIndexes(i);
                ArrayList<Individual> randomVectors = new ArrayList<>(3);
                randomVectors.add(oldPop.get(indexOfVectors.get(0)));
                randomVectors.add(oldPop.get(indexOfVectors.get(1)));
                randomVectors.add(oldPop.get(indexOfVectors.get(2)));
                mutateIndividual(randomVectors, oldPop.get(i), newPop.get(i));
                crossover(oldPop.get(i), newPop.get(i));
            }
            newPopSuite.calculateObjValue();
            newPopSuite.calculateSumOfRest();
            refreshFact(newPop);
            Collections.copy(oldPop, selection.selectIndividuals());
            oldPopSuite.calculateObjValue();
            oldPopSuite.calculateSumOfRest();
        }
        refreshFact(oldPop);
        System.out.println("Solution found by: "+strategy+"\n");
        best = Collections.max(oldPop, new SortByBestGlobal());
        System.out.println(best);
        
        
    }
    
    public void refreshFact(ArrayList<Individual> pop){
        for(Individual ind: pop){
            if(ind.getSumOfRestrictions() <= 0)
                ind.setIsFact(true);
        }
    }

    public Individual getBest() {
        return best;
    }



    
    
    
    
    
}
