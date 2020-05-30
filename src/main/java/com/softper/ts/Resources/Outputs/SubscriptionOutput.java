package com.softper.ts.Resources.Outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubscriptionOutput {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String plan;
    private double price;

    public SubscriptionOutput(int id, String firstName, String lastName, String email, String plan, double price) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.plan = plan;
        this.price = price;
    }


}
