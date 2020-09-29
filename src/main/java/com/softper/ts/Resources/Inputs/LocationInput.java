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

    public LocationInput(double departureLatitude, double departureLongitude, double departureAltitude, double arrivalLatitude, double arrivalLongitude, double arrivalAltitude, double range) {
        this.departureLatitude = departureLatitude;
        this.departureLongitude = departureLongitude;
        this.departureAltitude = departureAltitude;
        this.arrivalLatitude = arrivalLatitude;
        this.arrivalLongitude = arrivalLongitude;
        this.arrivalAltitude = arrivalAltitude;
        this.range = range;
    }
}
