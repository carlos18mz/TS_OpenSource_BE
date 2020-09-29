package com.softper.ts.Resources.Outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class FavouriteOutput {
    private String user;
    private String favourited;
    private Date since;

    public FavouriteOutput(String user, String favourited, Date since) {
        this.user = user;
        this.favourited = favourited;
        this.since = since;
    }
}
