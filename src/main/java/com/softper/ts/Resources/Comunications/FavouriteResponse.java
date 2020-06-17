package com.softper.ts.Resources.Comunications;
import com.softper.ts.Resources.Outputs.FavouriteOutput;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FavouriteResponse extends BaseResponse<FavouriteOutput>{
    public FavouriteResponse(List<FavouriteOutput> favouriteOutputList) {super(favouriteOutputList);}
    public FavouriteResponse(FavouriteOutput favouriteOutput) {super(favouriteOutput);}
    public FavouriteResponse(String message) {super(message);}
}
