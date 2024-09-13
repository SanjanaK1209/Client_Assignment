package service;

<<<<<<< HEAD
import java.util.HashMap;
=======
>>>>>>> aeb808a8a5fb0aecd6bfc047de98b6c9437014c3
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.CustomerTransaction;
<<<<<<< HEAD
import model.RewardResponse;
import repository.TransactionRepository;
import util.RewardCalculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

=======
import repository.TransactionRepository;
import util.RewardCalculator;

>>>>>>> aeb808a8a5fb0aecd6bfc047de98b6c9437014c3
@Service
public class RewardService {
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private RewardCalculator rewardCalculator;

<<<<<<< HEAD
    private static final Logger logger = LoggerFactory.getLogger(RewardService.class);
    
=======
>>>>>>> aeb808a8a5fb0aecd6bfc047de98b6c9437014c3
    public Map<String, Integer> getRewardPointsForCustomer(Long customerId) {
        List<CustomerTransaction> transactions = transactionRepository.findByCustomerId(customerId);
        return rewardCalculator.calculateMonthlyRewardPoints(transactions);
    }

    public int getTotalRewardPoints(Long customerId) {
        List<CustomerTransaction> transactions = transactionRepository.findByCustomerId(customerId);
        return rewardCalculator.calculateTotalRewardPoints(transactions);
    }
<<<<<<< HEAD
    
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
=======
>>>>>>> aeb808a8a5fb0aecd6bfc047de98b6c9437014c3
}

