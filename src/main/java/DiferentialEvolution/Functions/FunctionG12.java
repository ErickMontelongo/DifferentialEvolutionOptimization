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
import DiferentialEvolution.ObjectiveFunctions.ObjectiveG12;
import DiferentialEvolution.PenaltyFunctions.QuadraticLossFunction;
import DiferentialEvolution.RestrictionFunctions.RestrictionG12;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Punkid PC
 */
public class FunctionG12 extends FunctionSuite{

    public FunctionG12(ArrayList<Individual> ind) {
        super(ind);
        ObjectiveFunction objective = new ObjectiveG12(ind);
        PenaltyFunction penalty = new QuadraticLossFunction(ind);
        RestrictionFunctions restrictions = new RestrictionG12(ind,penalty);
        ArrayList<Double> dwnBounds = new ArrayList<>(Arrays.asList(0.0,0.0,0.0));
        ArrayList<Double> upBounds = new ArrayList<>(Arrays.asList(10.0,10.0,10.0));
        super.setObjFunction(objective);
        super.setRestFunction(restrictions);
        super.setUpBounds(upBounds);
        super.setDwnBounds(dwnBounds);
        super.setNumVar(3);
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
