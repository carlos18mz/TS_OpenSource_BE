package com.softper.ts.Controller;

import com.softper.ts.Resources.Comunications.SubscriptionResponse;
import com.softper.ts.Resources.Outputs.SubscriptionOutput;
import com.softper.ts.ServicesImp.SubscriptionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionsController {
    @Autowired
    private SubscriptionService subscriptionService;



}