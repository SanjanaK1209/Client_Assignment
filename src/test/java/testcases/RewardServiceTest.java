package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import main.RewardsProgramApplication;
import service.RewardService;

@SpringBootTest (classes= RewardsProgramApplication.class)
@AutoConfigureMockMvc
=======
import org.springframework.boot.test.context.SpringBootTest;

import service.RewardService;

@SpringBootTest
>>>>>>> aeb808a8a5fb0aecd6bfc047de98b6c9437014c3
public class RewardServiceTest {
    @Autowired
    private RewardService rewardService;

    @Test
    void testCalculateTotalRewards() {
        int totalPoints = rewardService.getTotalRewardPoints(1L);
        assertEquals(90, totalPoints);
    }
}

