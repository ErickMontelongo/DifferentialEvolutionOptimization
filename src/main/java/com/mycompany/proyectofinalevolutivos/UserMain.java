/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectofinalevolutivos;

import java.util.Scanner;

/**
 *
 * @author Punkid PC
 */
public class UserMain {
    
    public static void main(String[] args){
        int funcNumber;
        int maxGen;
        int popSize;
        double cr;
        double wFactor;
        double compProb;
        int constSel;
        int flag = 1;
        Scanner sc = new Scanner(System.in);
        while(flag == 1){
            System.out.println("**************** Differential Evolution with SMES and SR *******************");
            System.out.print("Select the number of objective function [1 - 13]: ");
            funcNumber = sc.nextInt();
            System.out.print("Select the maximum number of generations: ");
            maxGen = sc.nextInt();
            System.out.print("Select the population size: ");
            popSize = sc.nextInt();
            System.out.print("Select the crossover rate [0.0 - 1.0]: ");
            cr = sc.nextDouble();
            System.out.print("Select the F factor: ");
            wFactor = sc.nextDouble();
            System.out.print("Constraint handling technique: \n");
            System.out.print("\t 0. Stochastic Ranking\n");
            System.out.print("\t 1. Simple Multimembered Evolutionary Strategy\n");
            System.out.print("Select: ");
            constSel = sc.nextInt();
            System.out.print("Comparison probability [0.0 - 1.0]: ");
            compProb = sc.nextDouble();
            System.out.print("\n\n");
            //int constraintSel, int functionSel, int maxGen, int popSize, double cr, double wFactor, double compProb
            DifferentialEvolution df = new DifferentialEvolution(constSel, funcNumber, maxGen, popSize, cr, wFactor, compProb);
            df.runAlgorithm();
            System.out.print("\n¿Continue usage? (1 = yes, 0 = no): ");
            flag = sc.nextInt();
            System.out.print("\n\n");          
        }


        
    }
}
