package com.softper.ts.Resources.Comunications;
import com.softper.ts.Resources.Outputs.PriceOutput;

import java.util.List;
public class PriceResponse extends BaseResponse<PriceOutput>{
    public PriceResponse(List<PriceOutput> priceOutputList) {super(priceOutputList);}
    public PriceResponse(PriceOutput priceOutput) {super(priceOutput);}
    public PriceResponse(String message){super(message);}
}
