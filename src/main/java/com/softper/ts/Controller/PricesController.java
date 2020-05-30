package com.softper.ts.Controller;

import com.softper.ts.Resources.Comunications.PriceResponse;
import com.softper.ts.Resources.Outputs.PriceOutput;
import com.softper.ts.ServicesImp.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PricesController {
    @Autowired
    PriceService priceService;

}
