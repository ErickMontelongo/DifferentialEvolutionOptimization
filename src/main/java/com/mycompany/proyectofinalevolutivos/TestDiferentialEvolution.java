/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectofinalevolutivos;

/**
 *
 * @author Punkid PC
 */
public class TestDiferentialEvolution {
 
    public static void main(String[] args){
        DifferentialEvolution diferentialEvolution;
        //int constraintSel, int functionSel, int maxGen, int popSize, double cr, double wFactor, double compProb
        String feasibleSR = "Feasible solutions: ";
        String unfeasibleSR = "Unfeasible solutions: ";
        String feasibleSMES = "Feasible solutions: ";
        String unfeasibleSMES = "Unfeasible solutions: ";
        WriteResults resultsSR = new WriteResults("G13-SR.txt");
        WriteResults resultsSMES = new WriteResults("G13-SMES.txt");
        
        for(int i = 0; i < 30; i++){
            diferentialEvolution = new DifferentialEvolution(0,13,1750,100,0.1,0.65,0.45);
            diferentialEvolution.runAlgorithm();
            if(diferentialEvolution.getBest().isIsFact())
                feasibleSR+=diferentialEvolution.getBest().getObjValue()+", ";
            else
                unfeasibleSR+= diferentialEvolution.getBest().getObjValue()+", ";
            try{
            Thread.sleep(2000);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        for(int i = 0; i < 30; i++){
            diferentialEvolution = new DifferentialEvolution(1,13,1750,100,0.1,0.25,0.97);
            diferentialEvolution.runAlgorithm();
            if(diferentialEvolution.getBest().isIsFact())
                feasibleSMES+=diferentialEvolution.getBest().getObjValue()+", ";
            else
                unfeasibleSMES+= diferentialEvolution.getBest().getObjValue()+", ";
            try{
            Thread.sleep(2000);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        resultsSR.writeToFile(feasibleSR);
        resultsSR.writeToFile(unfeasibleSR);
        resultsSMES.writeToFile(feasibleSMES);
        resultsSMES.writeToFile(unfeasibleSMES);
        
        
//        diferentialEvolution = new DifferentialEvolution(1,1,1750,100,0.15,0.52,0.97);
//        diferentialEvolution.runAlgorithm();
    }
}
