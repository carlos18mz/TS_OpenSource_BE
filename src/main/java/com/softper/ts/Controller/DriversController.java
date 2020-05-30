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

}
