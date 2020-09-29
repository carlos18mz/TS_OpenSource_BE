package com.softper.ts.Resources.Inputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubscriptionInput {
    private int userId;
    private int planId;

    public SubscriptionInput(int userId, int planId) {
        this.userId = userId;
        this.planId = planId;
    }
}
