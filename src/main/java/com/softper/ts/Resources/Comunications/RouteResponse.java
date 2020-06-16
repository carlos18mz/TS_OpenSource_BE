package com.softper.ts.Resources.Comunications;

import com.softper.ts.Resources.Outputs.RouteOutput;

import java.util.List;

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
