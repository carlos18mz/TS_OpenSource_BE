package com.softper.ts.Services;

import com.softper.ts.Model.Price;
import com.softper.ts.Resources.Comunications.PriceResponse;
import com.softper.ts.Resources.Outputs.PriceOutput;
import java.util.List;

public interface IPriceService extends ICrudService<Price> {
    PriceResponse findAllPrices();
    PriceResponse findPriceById(int priceId);
    PriceResponse findPricesByPriceType(int priceType);
}
