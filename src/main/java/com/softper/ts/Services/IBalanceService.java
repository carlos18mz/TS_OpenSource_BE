package com.softper.ts.Services;

import com.softper.ts.Model.Balance;
import com.softper.ts.Resources.Comunications.BalanceResponse;
import com.softper.ts.Resources.Comunications.CustomerResponse;

public interface IBalanceService extends ICrudService<Balance>{
    BalanceResponse findBalanceById(int userId);

    BalanceResponse findAllBalances();
}
