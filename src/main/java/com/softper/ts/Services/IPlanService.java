package com.softper.ts.Services;

import com.softper.ts.Model.Plan;
import com.softper.ts.Resources.Comunications.PlanResponse;
import com.softper.ts.Resources.Inputs.PlanInput;
import com.softper.ts.Resources.Outputs.PlanOutput;
import java.util.List;

public interface IPlanService extends ICrudService<Plan>{

    PlanResponse findPlansByPrice(double priceValue);
    PlanResponse findPlansHigherThan(double priceValue);
    PlanResponse findPlansLessThan(double priceValue);
    PlanResponse getAllPlans();
    PlanResponse registerPlan(PlanInput planInput);
    PlanResponse findPlanById(int planId);
}
