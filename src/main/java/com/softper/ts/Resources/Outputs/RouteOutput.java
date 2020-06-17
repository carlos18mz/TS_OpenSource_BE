package com.softper.ts.Resources.Outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RouteOutput {
    private String DepartureLocation;
    private String ArrivalLocation;
    private double Distance;
    private int EstimedTime;

    public RouteOutput(String departureLocation, String arrivalLocation, double distance, int estimedTime) {
        DepartureLocation = departureLocation;
        ArrivalLocation = arrivalLocation;
        Distance = distance;
        EstimedTime = estimedTime;
    }
}
