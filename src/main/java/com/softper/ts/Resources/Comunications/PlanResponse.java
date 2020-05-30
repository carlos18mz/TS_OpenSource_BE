package com.softper.ts.Resources.Comunications;
import com.softper.ts.Resources.Outputs.PlanOutput;

import java.util.List;
public class PlanResponse extends BaseResponse<PlanOutput>{
    public PlanResponse(List<PlanOutput> planOutputList) {super(planOutputList);}
    public PlanResponse(PlanOutput planOutput) {super(planOutput);}
    public PlanResponse(String message) { super(message);}
}
