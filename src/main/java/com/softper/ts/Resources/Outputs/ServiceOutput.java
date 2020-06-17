package com.softper.ts.Resources.Outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ServiceOutput {
    private String firstName;
    private String lastName;
    private Date startedTime;
    private Date finishTime;
    private String serviceState;

    public ServiceOutput(String firstName, String lastName, Date startedTime, Date finishTime, String serviceState) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startedTime = startedTime;
        this.finishTime = finishTime;
        this.serviceState = serviceState;
    }
}
