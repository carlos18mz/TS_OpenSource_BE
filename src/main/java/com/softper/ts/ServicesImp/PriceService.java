package com.softper.ts.ServicesImp;

import com.softper.ts.Resources.Comunications.PlanResponse;
import com.softper.ts.Resources.Comunications.PriceResponse;
import com.softper.ts.Resources.Outputs.PriceOutput;
import com.softper.ts.Services.IPriceService;
import com.softper.ts.Model.Price;
import com.softper.ts.Repositories.IPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService implements IPriceService {

    @Override
    public PriceResponse findAllPrices() {
        return null;
    }

    @Override
    public PriceResponse findPriceById(int priceId) {
        return null;
    }

    @Override
    public PriceResponse findPricesByPriceType(int priceType) {
        return null;
    }

    @Override
    public Price save(Price price) throws Exception {
        return null;
    }

    @Override
    public void deleteById(Integer id) throws Exception {

    }

    @Override
    public Optional<Price> findById(Integer id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Price> findAll() throws Exception {
        return null;
    }
}
