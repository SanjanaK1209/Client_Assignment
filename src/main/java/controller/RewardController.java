package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.RewardService;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {
    @Autowired
    private RewardService rewardService;

    @GetMapping("/customer/{customerId}/monthly")
    public ResponseEntity<Map<String, Integer>> getMonthlyRewards(@PathVariable Long customerId) {
        return ResponseEntity.ok(rewardService.getRewardPointsForCustomer(customerId));
    }

    @GetMapping("/customer/{customerId}/total")
    public ResponseEntity<Integer> getTotalRewards(@PathVariable Long customerId) {
        return ResponseEntity.ok(rewardService.getTotalRewardPoints(customerId));
    }
}

