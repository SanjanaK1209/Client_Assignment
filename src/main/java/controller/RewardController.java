package controller;

<<<<<<< HEAD
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
=======
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> aeb808a8a5fb0aecd6bfc047de98b6c9437014c3
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.RewardResponse;
=======
import org.springframework.web.bind.annotation.RestController;

>>>>>>> aeb808a8a5fb0aecd6bfc047de98b6c9437014c3
import service.RewardService;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {
    @Autowired
    private RewardService rewardService;

<<<<<<< HEAD
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    
=======
>>>>>>> aeb808a8a5fb0aecd6bfc047de98b6c9437014c3
    @GetMapping("/customer/{customerId}/monthly")
    public ResponseEntity<Map<String, Integer>> getMonthlyRewards(@PathVariable Long customerId) {
        return ResponseEntity.ok(rewardService.getRewardPointsForCustomer(customerId));
    }

    @GetMapping("/customer/{customerId}/total")
    public ResponseEntity<Integer> getTotalRewards(@PathVariable Long customerId) {
        return ResponseEntity.ok(rewardService.getTotalRewardPoints(customerId));
    }
<<<<<<< HEAD
    
    @GetMapping("/rewards/batch")
    public ResponseEntity<Map<Long, RewardResponse>> getRewardPointsForCustomers(@RequestParam List<Long> customerIds) {
    	logger.info("Received request for calculating rewards for multiple customers: {}", customerIds);
        Map<Long, RewardResponse> rewardsMap = rewardService.calculateRewardsForMultipleCustomers(customerIds);
        logger.info("Rewards calculated for customers: {}", rewardsMap.keySet());
        return new ResponseEntity<>(rewardsMap, HttpStatus.OK);
    }
=======
>>>>>>> aeb808a8a5fb0aecd6bfc047de98b6c9437014c3
}

