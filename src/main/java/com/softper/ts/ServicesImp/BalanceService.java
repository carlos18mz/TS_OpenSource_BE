package com.softper.ts.ServicesImp;

import com.softper.ts.Model.Balance;
import com.softper.ts.Resources.Comunications.BalanceResponse;
import com.softper.ts.Services.IBalanceService;

import java.util.List;
import java.util.Optional;

public class BalanceService implements IBalanceService {
    @Override
    public BalanceResponse findBalanceById(int userId) {
        return null;
    }

    @Override
    public BalanceResponse findAllBalances() {
        return null;
    }

    @Override
    public Balance save(Balance balance) throws Exception {
        return null;
    }

    @Override
    public void deleteById(Integer id) throws Exception {

    }

    @Override
    public Optional<Balance> findById(Integer id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Balance> findAll() throws Exception {
        return null;
    }
}
