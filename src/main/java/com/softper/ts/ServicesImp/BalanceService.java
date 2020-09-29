package com.softper.ts.ServicesImp;

import com.softper.ts.Model.Balance;
import com.softper.ts.Model.Customer;
import com.softper.ts.Model.User;
import com.softper.ts.Repositories.IBalanceRepository;
import com.softper.ts.Repositories.ICustomerRepository;
import com.softper.ts.Repositories.IUserRepository;
import com.softper.ts.Resources.Comunications.BalanceResponse;
import com.softper.ts.Resources.Comunications.CustomerResponse;
import com.softper.ts.Resources.Outputs.BalanceOutput;
import com.softper.ts.Services.IBalanceService;
import com.softper.ts.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BalanceService implements IBalanceService {
    @Autowired
    private IBalanceRepository balanceRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public BalanceResponse findBalanceById(int balanceId) {
        try {
            User getUser = userRepository.findUserByBalanceId(balanceId)
                    .orElseThrow(()-> new ResourceNotFoundException("user","id",balanceId));

            Balance getBalance = getUser.getBalance();

            return new BalanceResponse(new BalanceOutput(getUser.getPerson().getFirstName()+" "+getUser.getPerson().getLastName(),getUser.getEmail(),getUser.getPerson().getCustomer().getCredits(),getBalance.getAddedMoney(),getBalance.getSpentMoney()));
        }
        catch(Exception e)
        {
            return new BalanceResponse("An error ocurred while getting balance: "+e.getMessage());
        }
    }

    @Override
    public BalanceResponse findAllBalances() {
        try
        {
            List<Balance> balanceList = balanceRepository.findAll();
            List<BalanceOutput> balanceOutputList = new ArrayList<>();
            for (Balance b:balanceList) {
                User getUser = userRepository.findUserByBalanceId(b.getId())
                        .orElseThrow(()-> new ResourceNotFoundException("user","id",b.getId()));
                balanceOutputList.add(new BalanceOutput(getUser.getPerson().getFirstName()+" "+getUser.getPerson().getLastName(),getUser.getEmail(),getUser.getPerson().getCustomer().getCredits(),b.getAddedMoney(),b.getSpentMoney()));
            }
            return new BalanceResponse(balanceOutputList);
        }
        catch (Exception e)
        {
            return new BalanceResponse("An error ocurred while getting balance list: "+e.getMessage());
        }
    }

    @Override
    public Balance save(Balance balance) throws Exception {
        return balanceRepository.save(balance);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        balanceRepository.deleteById(id);
    }

    @Override
    public Optional<Balance> findById(Integer id) throws Exception {
        return balanceRepository.findById(id);
    }

    @Override
    public List<Balance> findAll() throws Exception {
        return balanceRepository.findAll();
    }
}
