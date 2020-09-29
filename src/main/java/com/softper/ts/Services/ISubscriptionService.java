package com.softper.ts.Services;

import com.softper.ts.Model.Subscription;
import com.softper.ts.Resources.Comunications.SubscriptionResponse;
import com.softper.ts.Resources.Outputs.SubscriptionOutput;
import java.util.List;

public interface ISubscriptionService extends ICrudService<Subscription> {
    SubscriptionResponse findSubscriptionById(int subscriptionId);
    SubscriptionResponse suscribe(int userId, int planId);
    SubscriptionResponse findSubscriptionsByUserId(int userId);
    SubscriptionResponse getAllSubscriptions();
    SubscriptionResponse cancelSubscription(int subscriptionId);
}
