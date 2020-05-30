package com.softper.ts.Resources.Comunications;
import com.softper.ts.Resources.Outputs.FavouriteOutput;

import java.util.List;
public class FavouriteResponse extends BaseResponse<FavouriteOutput>{
    public FavouriteResponse(List<FavouriteOutput> favouriteOutputList) {super(favouriteOutputList);}
    public FavouriteResponse(FavouriteOutput favouriteOutput) {super(favouriteOutput);}
    public FavouriteResponse(String message) {super(message);}
}
