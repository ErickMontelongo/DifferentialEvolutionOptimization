/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiferentialEvolution.Core;

import Abstract.Selection;
import DiferentialEvolution.Individual.Individual;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author erick
 */
public class StochasticRanking extends Selection {

    public StochasticRanking(ArrayList<Individual> old, ArrayList<Individual> newPop, double prob) {
        super(old, newPop, prob);
    }

    @Override
    public ArrayList<Individual> selectIndividuals() {
        ArrayList<Individual> aux = new ArrayList<>();
        int popSize = super.getOldPopulation().size();
        aux.addAll(super.getOldPopulation());
        aux.addAll(super.getNewPopulation());
        Collections.shuffle(aux);
        boolean swap = false;
        for(int i = 0; i < aux.size(); i++){
            swap = false;
            for(int j = 0; j < aux.size() - 1; j++){
                double u = Math.random();
                if((aux.get(j).isIsFact() && aux.get(j+1).isIsFact()) || u < super.getProb()){
                        if(aux.get(j).getFitness() < aux.get(j+1).getFitness()){
                            Collections.swap(aux, j, j+1);
                            swap = true;
                        }
                }
                else if(aux.get(j).getSumOfRestrictions() > aux.get(j+1).getSumOfRestrictions()){
                    Collections.swap(aux, j, j+1);
                    swap = true;
                }
            }
            if(!swap)
                break;
        }
        
        return new ArrayList(aux.subList(0, popSize));
    }
    
}
            
