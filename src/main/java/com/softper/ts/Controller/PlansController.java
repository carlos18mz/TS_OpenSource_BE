package com.softper.ts.Controller;

import com.softper.ts.Resources.Comunications.PlanResponse;
import com.softper.ts.Resources.Inputs.PlanInput;
import com.softper.ts.Resources.Outputs.PlanOutput;
import com.softper.ts.ServicesImp.PlanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/plans")
public class PlansController {

    @Autowired
    private PlanService planService;

    @GetMapping
    public ResponseEntity<PlanResponse> findAllPlans()
    {
        PlanResponse result =  planService.getAllPlans();

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PlanResponse> addNewPlan(@Valid @RequestBody PlanInput planInput)
    {
        PlanResponse result = planService.registerPlan(planInput);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/{planId}")
    public ResponseEntity<PlanResponse> findPlanById(@PathVariable(value = "planId") int planId)
    {
        PlanResponse result = planService.findPlanById(planId);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/{priceValue}/more")
    public ResponseEntity<PlanResponse> findPlansHigherThan(@PathVariable(value = "priceValue")double priceValue)
    {
        PlanResponse result =  planService.findPlansHigherThan(priceValue);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/{priceValue}/less")
    public ResponseEntity<PlanResponse> findPlansLessThan(@PathVariable(value = "priceValue")double priceValue)
    {
        PlanResponse result = planService.findPlansLessThan(priceValue);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/{priceValue}")
    public ResponseEntity<PlanResponse> findByPrice(@PathVariable(value = "priceValue")double priceValue)
    {
        PlanResponse result = planService.findPlansByPrice(priceValue);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);

    }
}
