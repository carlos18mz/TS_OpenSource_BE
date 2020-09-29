package com.softper.ts.Controller;

import com.softper.ts.Resources.Comunications.BalanceResponse;
import com.softper.ts.Resources.Comunications.PriceResponse;
import com.softper.ts.Services.IBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/balances")
public class BalanceController {

    @Autowired
    private IBalanceService balanceService;

    @GetMapping()
    public ResponseEntity<BalanceResponse> findAllBalances()
    {
        BalanceResponse result = balanceService.findAllBalances();

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/{balanceId}")
    public ResponseEntity<BalanceResponse> findBalanceById(@PathVariable(value = "balanceId")int balanceId)
    {
        BalanceResponse result =  balanceService.findBalanceById(balanceId);

        if(!result.success)
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}