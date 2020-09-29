package com.softper.ts.Resources.Inputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RelationInput {
    private int userFrom;
    private int userTo;

    public RelationInput(int userFrom, int userTo) {
        this.userFrom = userFrom;
        this.userTo = userTo;
    }
}
