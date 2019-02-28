/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiferentialEvolution.Core;

import Abstract.Selection;
import DiferentialEvolution.Individual.Individual;
import DiferentialEvolution.Individual.SortByBestInfact;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author erick
 */
public class SMESelection extends Selection{

    public SMESelection(ArrayList<Individual> old, ArrayList<Individual> newPop, double probability) {
        super(old, newPop, probability);
    }

    @Override
    public ArrayList<Individual> selectIndividuals() {
        ArrayList<Individual> oldPop = super.getOldPopulation();
        ArrayList<Individual> newPop = super.getNewPopulation();
        ArrayList<Individual> aux = new ArrayList<>();
        oldPop = sortIndividuals(oldPop);
        newPop = sortIndividuals(newPop);
        int p = 0;
        int c = 0;
        for(int i = 0; i < oldPop.size(); i++){
            if(Math.random() < super.getProb()){
                if(oldPop.get(p).isIsFact()){
                    if(newPop.get(c).isIsFact()){
                        if(oldPop.get(p).getFitness() > newPop.get(c).getFitness()){
                            aux.add(new Individual(oldPop.get(p)));
                            p++;
                        }
                        else{
                            aux.add(new Individual(newPop.get(c)));
                            c++;
                        }
                            
                    }
                    else{
                        aux.add(new Individual(oldPop.get(p)));
                        p++;
                    }
                }
                else{
                    if(!newPop.get(c).isIsFact()){
                        if(newPop.get(c).getSumOfRestrictions() < oldPop.get(p).getSumOfRestrictions()){
                            aux.add(new Individual(newPop.get(c)));
                            c++;
                        }
                        else{
                            aux.add(new Individual(oldPop.get(p)));
                            p++;
                        }
                    }
                    else{
                        aux.add(new Individual(newPop.get(c)));
                        c++;
                    }
                }
            }
            else if(Math.random() < 0.5){
                aux.add(new Individual(getBestInfeasible(oldPop)));
            }
            else
                aux.add(new Individual(getBestInfeasible(newPop)));
        }
        return aux;
    }
    
    private Individual getBestInfeasible(ArrayList<Individual> pop){
        Individual aux = pop.get(0);
        for(Individual ind: pop){
            if(!ind.isIsFact()){
                if(ind.getFitness() > aux.getFitness() && ind.getSumOfRestrictions() < aux.getSumOfRestrictions())
                    aux = ind;
            }
        }
        return aux;
    }
    
    private ArrayList<Individual> sortIndividuals(ArrayList<Individual> pop){
        ArrayList<Individual> sorted = new ArrayList(pop);
        boolean swap = true;
        while(swap){
            swap = false;
            for(int i = 0; i < sorted.size() - 1; i++){
                Individual ind1 = sorted.get(i);
                Individual ind2 = sorted.get(i+1);
                if(ind1.isIsFact()){
                    if(ind2.isIsFact()){
                        if(ind1.getFitness() < ind2.getFitness()){
                            Collections.swap(sorted, i, i+1);
                            swap = true;
                        }
                    }
                }
                else{
                    if(!ind2.isIsFact()){
                        if(ind1.getSumOfRestrictions() > ind2.getSumOfRestrictions()){
                            Collections.swap(sorted, i, i+1);
                            swap = true;
                        }
                    }
                    else{
                        Collections.swap(sorted, i, i+1);
                        swap = true;
                    }
                }
            }
        }
        return sorted;
    }
    
}
