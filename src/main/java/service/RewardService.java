package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.CustomerTransaction;
import repository.TransactionRepository;
import util.RewardCalculator;

@Service
public class RewardService {
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private RewardCalculator rewardCalculator;

    public Map<String, Integer> getRewardPointsForCustomer(Long customerId) {
        List<CustomerTransaction> transactions = transactionRepository.findByCustomerId(customerId);
        return rewardCalculator.calculateMonthlyRewardPoints(transactions);
    }

    public int getTotalRewardPoints(Long customerId) {
        List<CustomerTransaction> transactions = transactionRepository.findByCustomerId(customerId);
        return rewardCalculator.calculateTotalRewardPoints(transactions);
    }
}

