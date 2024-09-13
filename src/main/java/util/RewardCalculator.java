package util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import model.CustomerTransaction;

@Component
public class RewardCalculator {
    public Map<String, Integer> calculateMonthlyRewardPoints(List<CustomerTransaction> transactions) {
        return transactions.stream()
            .collect(Collectors.groupingBy(
                t -> t.getDate().getMonth().toString(),
                Collectors.summingInt(t -> calculateRewardPoints(t.getAmount()))
            ));
    }

    public int calculateRewardPoints(double amount) {
        int points = 0;
        if (amount > 100) {
            points += (amount - 100) * 2;
            points += 50;  // Points for the $50 to $100 range
        } else if (amount > 50) {
            points += (amount - 50) * 1;
        }
        return points;
    }

    public int calculateTotalRewardPoints(List<CustomerTransaction> transactions) {
        return transactions.stream().mapToInt(t -> calculateRewardPoints(t.getAmount())).sum();
    }
}

