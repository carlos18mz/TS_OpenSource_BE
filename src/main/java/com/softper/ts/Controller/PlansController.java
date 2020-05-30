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

}
