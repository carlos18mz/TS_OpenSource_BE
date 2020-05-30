package com.softper.ts.ServicesImp;

import com.softper.ts.Model.Plan;
import com.softper.ts.Model.Price;
import com.softper.ts.Repositories.IPlanRepository;
import com.softper.ts.Repositories.IPriceRepository;
import com.softper.ts.Resources.Comunications.PersonResponse;
import com.softper.ts.Resources.Comunications.PlanResponse;
import com.softper.ts.Resources.Inputs.PlanInput;
import com.softper.ts.Resources.Outputs.PlanOutput;
import com.softper.ts.Services.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanService implements IPlanService {

    @Override
    public PlanResponse findPlansByPrice(double priceValue) {
        return null;
    }

    @Override
    public PlanResponse findPlansHigherThan(double priceValue) {
        return null;
    }

    @Override
    public PlanResponse findPlansLessThan(double priceValue) {
        return null;
    }

    @Override
    public PlanResponse getAllPlans() {
        return null;
    }

    @Override
    public PlanResponse registerPlan(PlanInput planInput) {
        return null;
    }

    @Override
    public PlanResponse findPlanById(int planId) {
        return null;
    }
}
