package com.softper.ts.Resources.Outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class BlockedOutput {
    private String user;
    private String blocked;
    private Date Since;

    public BlockedOutput(String user, String blocked, Date since) {
        this.user = user;
        this.blocked = blocked;
        Since = since;
    }
}
