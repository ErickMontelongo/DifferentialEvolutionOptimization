/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiferentialEvolution.Core;

import Abstract.FunctionSuite;
import DiferentialEvolution.Functions.FunctionG1;
import DiferentialEvolution.Functions.FunctionG10;
import DiferentialEvolution.Functions.FunctionG11;
import DiferentialEvolution.Functions.FunctionG12;
import DiferentialEvolution.Functions.FunctionG13;
import DiferentialEvolution.Functions.FunctionG2;
import DiferentialEvolution.Functions.FunctionG3;
import DiferentialEvolution.Functions.FunctionG4;
import DiferentialEvolution.Functions.FunctionG5;
import DiferentialEvolution.Functions.FunctionG6;
import DiferentialEvolution.Functions.FunctionG7;
import DiferentialEvolution.Functions.FunctionG8;
import DiferentialEvolution.Functions.FunctionG9;
import DiferentialEvolution.Individual.Individual;
import java.util.ArrayList;

/**
 *
 * @author Punkid PC
 */
public class FunctionFactory {
    
    public FunctionSuite getFunctionSuite(ArrayList<Individual> pop,int sel){
        if(sel == 1)
            return new FunctionG1(pop);
        else if(sel == 2)
            return new FunctionG2(pop);
        else if(sel == 3)
            return new FunctionG3(pop);
        else if(sel == 4)
            return new FunctionG4(pop);
        else if(sel == 5)
            return new FunctionG5(pop);
        else if(sel == 6)
            return new FunctionG6(pop);
        else if(sel == 7)
            return new FunctionG7(pop);
        else if(sel == 8)
            return new FunctionG8(pop);
        else if(sel == 9)
            return new FunctionG9(pop);
        else if(sel == 10)
            return new FunctionG10(pop);
        else if(sel == 11)
            return new FunctionG11(pop);
        else if(sel == 12)
            return new FunctionG12(pop);
        else if(sel == 13)
            return new FunctionG13(pop);
        
        return null;
    }
}
