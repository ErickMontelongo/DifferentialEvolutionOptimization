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
import DiferentialEvolution.ObjectiveFunctions.ObjectiveG11;
import DiferentialEvolution.PenaltyFunctions.QuadraticLossFunction;
import DiferentialEvolution.RestrictionFunctions.RestrictionG11;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Punkid PC
 */
public class FunctionG11 extends FunctionSuite{

    public FunctionG11(ArrayList<Individual> ind) {
        super(ind);
        ObjectiveFunction objective = new ObjectiveG11(ind);
        PenaltyFunction penalty = new QuadraticLossFunction(ind);
        RestrictionFunctions restrictions = new RestrictionG11(ind,penalty);
        ArrayList<Double> dwnBounds = new ArrayList<>(Arrays.asList(-1.0,-1.0));
        ArrayList<Double> upBounds = new ArrayList<>(Arrays.asList(1.0,1.0));
        super.setObjFunction(objective);
        super.setRestFunction(restrictions);
        super.setUpBounds(upBounds);
        super.setDwnBounds(dwnBounds);
        super.setNumVar(2);
        super.setNumRest(1);
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
