package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import service.RewardService;

@SpringBootTest
public class RewardServiceTest {
    @Autowired
    private RewardService rewardService;

    @Test
    void testCalculateTotalRewards() {
        int totalPoints = rewardService.getTotalRewardPoints(1L);
        assertEquals(90, totalPoints);
    }
}

