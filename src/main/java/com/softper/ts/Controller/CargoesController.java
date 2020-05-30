package com.softper.ts.Controller;

import com.softper.ts.Resources.Comunications.CargoResponse;
import com.softper.ts.Resources.Inputs.CargoInput;
import com.softper.ts.Resources.Outputs.CargoOutput;
import com.softper.ts.Services.ICargoService;
import com.softper.ts.Services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/cargoes")
public class CargoesController {

    @Autowired
    private ICargoService cargoService;

}
