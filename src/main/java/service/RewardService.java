package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import controller.CustomerController;
import model.CustomerTransaction;
import model.RewardResponse;
import repository.TransactionRepository;
import util.RewardCalculator;

@Service
public class RewardService {
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private RewardCalculator rewardCalculator;
    
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public Map<String, Integer> getRewardPointsForCustomer(Long customerId) {
        List<CustomerTransaction> transactions = transactionRepository.findByCustomerId(customerId);
        return rewardCalculator.calculateMonthlyRewardPoints(transactions);
    }

    public int getTotalRewardPoints(Long customerId) {
        List<CustomerTransaction> transactions = transactionRepository.findByCustomerId(customerId);
        return rewardCalculator.calculateTotalRewardPoints(transactions);
    }
    
    public Map<Long, RewardResponse> calculateRewardsForMultipleCustomers(List<Long> customerIds) {
        Map<Long, RewardResponse> rewardsMap = new HashMap<>();

        for (Long customerId : customerIds) {
            List<CustomerTransaction> transactions = transactionRepository.findByCustomerId(customerId);

            int totalPoints = rewardCalculator.calculateTotalRewardPoints(transactions);
            Map<String, Integer> monthlyPoints = rewardCalculator.calculateMonthlyRewardPoints(transactions);

            RewardResponse rewardResponse = new RewardResponse();
            rewardResponse.setTotalPoints(totalPoints);
            rewardResponse.setMonthlyPoints(monthlyPoints);

            rewardsMap.put(customerId, rewardResponse);
            
            logger.info("Calculated rewards for customer ID: {} - Total Points: {}, Monthly Points: {}", 
                    customerId, totalPoints, monthlyPoints);
        }

        return rewardsMap;
    }
}

