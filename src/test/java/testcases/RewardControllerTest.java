package testcases;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import controller.RewardController;
import service.RewardService;

@WebMvcTest(RewardController.class)
public class RewardControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RewardService rewardService;

    @Test
    void testGetMonthlyRewards() throws Exception {
        when(rewardService.getRewardPointsForCustomer(1L)).thenReturn(Map.of("AUGUST", 90));

        mockMvc.perform(get("/api/rewards/customer/1/monthly"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.AUGUST").value(90));
    }
}

