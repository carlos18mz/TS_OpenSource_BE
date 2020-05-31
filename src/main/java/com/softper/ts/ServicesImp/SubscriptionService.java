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
import com.softper.ts.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService implements ISubscriptionService {
    @Autowired
    private ISubscriptionRepository subscriptionRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IPlanRepository planRepository;

    @Override
    public SubscriptionResponse findSubscriptionById(int subscriptionId) {
        try{
            Subscription getSubscription = subscriptionRepository.findById(subscriptionId).get();
            SubscriptionOutput newSubscriptionOutput = new SubscriptionOutput();
            newSubscriptionOutput.setFirstName(getSubscription.getUser().getPerson().getFirstName());
            newSubscriptionOutput.setLastName(getSubscription.getUser().getPerson().getLastName());
            newSubscriptionOutput.setEmail(getSubscription.getUser().getEmail());
            return new SubscriptionResponse(newSubscriptionOutput);
        }
        catch (Exception e)
        {
            return new SubscriptionResponse("An error ocurred while getting the subscription : "+e.getMessage());
        }

    }

    @Override
    public SubscriptionResponse suscribe(int userId, int planId) {
        try
        {
            Plan getPlan = planRepository.findById(planId)
                    .orElseThrow(()->new ResourceNotFoundException("Plan","id",planId));
            User getUser = userRepository.findById(userId)
                    .orElseThrow(()->new ResourceNotFoundException("User","id",userId));

            Subscription newSubscription = new Subscription();
            newSubscription.setPlan(getPlan);
            newSubscription.setUser(getUser);
            newSubscription.setStartTime(Calendar.getInstance().getTime());
            newSubscription.setFinishTime(Calendar.getInstance().getTime());

            newSubscription = subscriptionRepository.save(newSubscription);
            return new SubscriptionResponse(new SubscriptionOutput(newSubscription.getId(),
                    newSubscription.getUser().getPerson().getFirstName(),newSubscription.getUser().
                    getPerson().getLastName(),newSubscription.getUser().getEmail(),newSubscription.getPlan().
                    getName(),newSubscription.getPlan().getPrice().getTotalPrice()));

        }
        catch (Exception e)
        {
            return new SubscriptionResponse("An error ocurred while registering the subscription : "+e.getMessage());
        }

    }

    @Override
    public SubscriptionResponse findSubscriptionsByUserId(int userId) {
        try
        {
            List<Subscription> subscriptionList = subscriptionRepository.getSubscriptionsByUserId(userId);
            List<SubscriptionOutput> subscriptionOutputList = new ArrayList<>();
            for (Subscription s:subscriptionList) {
                SubscriptionOutput newSubscriptionOutput = new SubscriptionOutput();
                newSubscriptionOutput.setFirstName(s.getUser().getPerson().getFirstName());
                newSubscriptionOutput.setLastName(s.getUser().getPerson().getLastName());
                newSubscriptionOutput.setEmail(s.getUser().getEmail());
                subscriptionOutputList.add(newSubscriptionOutput);
            }
            return new SubscriptionResponse(subscriptionOutputList);
        }
        catch (Exception e)
        {
            return new SubscriptionResponse("An error ocurred while getting the subscription list : "+e.getMessage());

        }

    }

    @Override
    public SubscriptionResponse getAllSubscriptions() {
        try
        {
            List<Subscription> subscriptionList = subscriptionRepository.findAll();
            List<SubscriptionOutput> subscriptionOutputList = new ArrayList<>();
            for (Subscription s:subscriptionList) {
                SubscriptionOutput newSubscriptionOutput = new SubscriptionOutput();
                newSubscriptionOutput.setFirstName(s.getUser().getPerson().getFirstName());
                newSubscriptionOutput.setLastName(s.getUser().getPerson().getLastName());
                newSubscriptionOutput.setEmail(s.getUser().getEmail());
                subscriptionOutputList.add(newSubscriptionOutput);
            }
            return new SubscriptionResponse(subscriptionOutputList);
        }
        catch (Exception e)
        {
            return new SubscriptionResponse("An error ocurred while getting the subscription list : "+e.getMessage());
        }

    }

    @Override
    public Subscription save(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void deleteById(Integer id) {
        subscriptionRepository.deleteById(id);
    }

    @Override
    public Optional<Subscription> findById(Integer id) {
        return subscriptionRepository.findById(id);
    }

    @Override
    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }
}
