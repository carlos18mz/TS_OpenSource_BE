package com.softper.ts.Resources.Comunications;
import com.softper.ts.Resources.Outputs.SubscriptionOutput;

import java.util.List;
public class SubscriptionResponse extends BaseResponse<SubscriptionOutput>{
    public SubscriptionResponse(List<SubscriptionOutput> subscriptionOutputList) {super(subscriptionOutputList);}
    public SubscriptionResponse(SubscriptionOutput subscriptionOutput) {super(subscriptionOutput);}
    public SubscriptionResponse(String message) {super(message);}
}
