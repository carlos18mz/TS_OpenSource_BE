package com.softper.ts.Resources.Outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RelationOutput {
    private String userFrom;
    private String userTo;

    public RelationOutput(String userFrom, String userTo) {
        this.userFrom = userFrom;
        this.userTo = userTo;
    }
}
