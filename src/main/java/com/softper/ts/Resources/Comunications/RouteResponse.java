package com.softper.ts.Resources.Comunications;

import com.softper.ts.Resources.Outputs.RouteOutput;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RouteResponse extends BaseResponse<RouteOutput> {
    public RouteResponse(RouteOutput routeOutput)
    {
        super(routeOutput);
    }
    public RouteResponse(List<RouteOutput> routeOutputList)
    {
        super(routeOutputList);
    }
    public RouteResponse(String menssage){
        super(menssage);
    }
}
