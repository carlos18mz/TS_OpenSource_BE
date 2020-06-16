package com.softper.ts.ServicesImp;

import com.softper.ts.Model.Route;
import com.softper.ts.Resources.Comunications.RouteResponse;
import com.softper.ts.Services.IRouteService;

import java.util.List;
import java.util.Optional;

public class RouteService implements IRouteService {
    @Override
    public RouteResponse getRouteInfo(int cargoId) {
        return null;
    }

    @Override
    public RouteResponse findAllRoutes() {
        return null;
    }

    @Override
    public RouteResponse findRouteById(int routeId) {
        return null;
    }

    @Override
    public Route save(Route route) throws Exception {
        return null;
    }

    @Override
    public void deleteById(Integer id) throws Exception {

    }

    @Override
    public Optional<Route> findById(Integer id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Route> findAll() throws Exception {
        return null;
    }
}
