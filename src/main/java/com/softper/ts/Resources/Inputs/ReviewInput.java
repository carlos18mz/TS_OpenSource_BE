package com.softper.ts.Resources.Inputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReviewInput {
    private String commentary;
    private double calification;

    public ReviewInput(String commentary, double calification) {
        this.commentary = commentary;
        this.calification = calification;
    }
}
