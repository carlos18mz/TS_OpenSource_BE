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

    @Autowired
    IPriceRepository priceRepository;

    @Override
    public Price save(Price price) {
        return priceRepository.save(price);
    }

    @Override
    public void deleteById(Integer id) {
        priceRepository.deleteById(id);
    }

    @Override
    public Optional<Price> findById(Integer id) {
        return priceRepository.findById(id);
    }

    @Override
    public List<Price> findAll() throws Exception {
        return priceRepository.findAll();
    }

    @Override
    public PriceResponse findAllPrices() {
        try
        {
            List<Price> prices = priceRepository.findAll();
            List<PriceOutput> priceResponsesList = new ArrayList<>();
            for (Price p:prices) {
                PriceOutput newPriceOutput = new PriceOutput();
                newPriceOutput.setTotalPrice(p.getTotalPrice());
                newPriceOutput.setTax(p.getTax());
                if(p.getPriceType()==1)
                    newPriceOutput.setPriceFrom("Subscription");
                if(p.getPriceType()==2)
                    newPriceOutput.setPriceFrom("Cargo");
                priceResponsesList.add(newPriceOutput);
            }
            return new PriceResponse(priceResponsesList);
        }
        catch (Exception e)
        {
            return new PriceResponse("An error ocurred while getting the price list : "+e.getMessage());

        }

    }

    @Override
    public PriceResponse findPriceById(int priceId) {
        try
        {
            Price getPrice = priceRepository.findById(priceId).get();
            PriceOutput newPriceOutput = new PriceOutput();
            newPriceOutput.setTotalPrice(getPrice.getTotalPrice());
            newPriceOutput.setTax(getPrice.getTax());
            if(getPrice.getPriceType()==1)
                newPriceOutput.setPriceFrom("Subscription");
            if(getPrice.getPriceType()==2)
                newPriceOutput.setPriceFrom("Cargo");

            return new PriceResponse(newPriceOutput);
        }
        catch (Exception e)
        {
            return new PriceResponse("An error ocurred while getting the price : "+e.getMessage());
        }

    }

    @Override
    public PriceResponse findPricesByPriceType(int priceType) {
        try
        {
            List<Price> prices = priceRepository.findPricesByType(priceType);
            List<PriceOutput> priceResponsesList = new ArrayList<>();
            for (Price p:prices) {
                PriceOutput newPriceOutput = new PriceOutput();
                newPriceOutput.setTotalPrice(p.getTotalPrice());
                newPriceOutput.setTax(p.getTax());
                if(p.getPriceType()==1)
                    newPriceOutput.setPriceFrom("Subscription");
                if(p.getPriceType()==2)
                    newPriceOutput.setPriceFrom("Cargo");
                priceResponsesList.add(newPriceOutput);
            }
            return new PriceResponse(priceResponsesList);
        }
        catch (Exception e)
        {
            return new PriceResponse("An error ocurred while getting the price list : "+e.getMessage());
        }

    }
}
