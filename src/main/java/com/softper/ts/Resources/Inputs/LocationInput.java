package com.softper.ts.Resources.Inputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationInput {
    private double departureLatitude;
    private double departureLongitude;
    private double departureAltitude;
    private double arrivalLatitude;
    private double arrivalLongitude;
    private double arrivalAltitude;
    private double range;
}
