package com.softper.ts.ServicesImp;

import com.softper.ts.Model.Plan;
import com.softper.ts.Model.Subscription;
import com.softper.ts.Model.User;
import com.softper.ts.Repositories.IPlanRepository;
import com.softper.ts.Repositories.ISubscriptionRepository;
import com.softper.ts.Repositories.IUserRepository;
import com.softper.ts.Resources.Comunications.ServiceResponse;
import com.softper.ts.Resources.Comunications.SubscriptionResponse;
import com.softper.ts.Resources.Outputs.SubscriptionOutput;
import com.softper.ts.Services.ISubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService implements ISubscriptionService {

    @Override
    public SubscriptionResponse findSubscriptionById(int subscriptionId) {
        return null;
    }

    @Override
    public SubscriptionResponse suscribe(int userId, int planId) {
        return null;
    }

    @Override
    public SubscriptionResponse findSubscriptionsByUserId(int userId) {
        return null;
    }

    @Override
    public SubscriptionResponse getAllSubscriptions() {
        return null;
    }

    @Override
    public Subscription save(Subscription subscription) throws Exception {
        return null;
    }

    @Override
    public void deleteById(Integer id) throws Exception {

    }

    @Override
    public Optional<Subscription> findById(Integer id) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Subscription> findAll() throws Exception {
        return null;
    }
}
