package com.softper.ts.Services;

import com.softper.ts.Model.Route;
import com.softper.ts.Resources.Comunications.RouteResponse;

public interface IRouteService extends ICrudService<Route> {
    RouteResponse getRouteInfo(int cargoId);
    RouteResponse findAllRoutes();
    RouteResponse findRouteById(int routeId);
}
