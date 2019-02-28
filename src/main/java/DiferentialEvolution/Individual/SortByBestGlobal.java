/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiferentialEvolution.Individual;

import java.util.Comparator;

/**
 *
 * @author Punkid PC
 */
public class SortByBestGlobal implements Comparator<Individual> {

    @Override
    public int compare(Individual o1, Individual o2) {
       if(o1.isIsFact()){
           if(o2.isIsFact()){
               if(o1.getFitness() > o2.getFitness())
                   return 1;
               else if(o1.getFitness() == o2.getFitness())
                   return 0;
               else
                   return -1;
           }
           else
               return 1;
       }
       else{
           if(!o2.isIsFact()){
               if(o1.getSumOfRestrictions() < o2.getSumOfRestrictions())
                   return 1;
               else if(o1.getSumOfRestrictions() == o2.getSumOfRestrictions())
                   return 0;
               else 
                   return -1;
           }
           else
               return -1;
       }
    }
    
}
