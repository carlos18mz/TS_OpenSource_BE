package com.softper.ts.Controller;

import com.softper.ts.Resources.Comunications.DriverResponse;
import com.softper.ts.Resources.Outputs.DriverOutput;
import com.softper.ts.ServicesImp.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriversController {

    @Autowired
    private DriverService driverService;

    @GetMapping
    public ResponseEntity<DriverResponse> findAllDrivers()
    {
        DriverResponse result = driverService.getAllDrivers();

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{driverId}")
    public ResponseEntity<DriverResponse> findDriverById(@PathVariable(value = "driverId") int driverId)
    {
        DriverResponse result = driverService.findDriverById(driverId);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
