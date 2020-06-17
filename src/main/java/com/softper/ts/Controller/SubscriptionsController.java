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

    @GetMapping
    public ResponseEntity<SubscriptionResponse> findAllSubscriptions()
    {
        SubscriptionResponse result = subscriptionService.getAllSubscriptions();

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<SubscriptionResponse> findSubscriptionsByUserId(@PathVariable(value = "userId")int userId)
    {
        SubscriptionResponse result = subscriptionService.findSubscriptionsByUserId(userId);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/plans/{planId}")
    public ResponseEntity<SubscriptionResponse> suscribeDriver(@PathVariable(value = "userId")int userId, @PathVariable(value = "planId")int planId)
    {
        SubscriptionResponse result = subscriptionService.suscribe(userId, planId);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PutMapping("{subscriptionId}")
    public ResponseEntity<SubscriptionResponse> cancelSubscription(@PathVariable(value = "subscriptionId")int subscriptionId)
    {
        SubscriptionResponse result = subscriptionService.cancelSubscription(subscriptionId);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}