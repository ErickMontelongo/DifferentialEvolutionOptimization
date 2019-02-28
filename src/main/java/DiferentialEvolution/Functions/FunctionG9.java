/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DiferentialEvolution.Functions;

import Abstract.FunctionSuite;
import Abstract.ObjectiveFunction;
import Abstract.PenaltyFunction;
import Abstract.RestrictionFunctions;
import DiferentialEvolution.Individual.Individual;
import DiferentialEvolution.ObjectiveFunctions.ObjectiveG9;
import DiferentialEvolution.PenaltyFunctions.QuadraticLossFunction;
import DiferentialEvolution.RestrictionFunctions.RestrictionG9;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Punkid PC
 */
public class FunctionG9 extends FunctionSuite{

    public FunctionG9(ArrayList<Individual> ind) {
        super(ind);
        ObjectiveFunction objective = new ObjectiveG9(ind);
        PenaltyFunction penalty = new QuadraticLossFunction(ind);
        RestrictionFunctions restrictions = new RestrictionG9(ind,penalty);
        ArrayList<Double> dwnBounds = new ArrayList<>(Arrays.asList(-10.0,-10.0,-10.0,-10.0,-10.0,-10.0,-10.0));
        ArrayList<Double> upBounds = new ArrayList<>(Arrays.asList(10.0,10.0,10.0,10.0,10.0,10.0,10.0));
        super.setObjFunction(objective);
        super.setRestFunction(restrictions);
        super.setUpBounds(upBounds);
        super.setDwnBounds(dwnBounds);
        super.setNumVar(7);
        super.setNumRest(4);
    }

    @Override
    public void calculateObjValue() {
       super.getObjFunction().calculateObjFunction();
    }

    @Override
    public void calculateSumOfRest() {
        super.getRestFunction().calculateRestrictions();
        super.getRestFunction().calculateSumOfRestrictions();
    }
    
    
}
