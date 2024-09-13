package util;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import model.CustomerTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class RewardCalculator {

    private static final Logger logger = LoggerFactory.getLogger(RewardCalculator.class);

    // Calculate monthly reward points
    public Map<String, Integer> calculateMonthlyRewardPoints(List<CustomerTransaction> transactions) {
        logger.info("Calculating monthly reward points");

        Map<String, Integer> monthlyRewards = new HashMap<>();

        for (CustomerTransaction transaction : transactions) {
            String month = transaction.getDate().getMonth().toString();
            int points = calculateRewardPoints(transaction.getAmount());

            if (monthlyRewards.containsKey(month)) {
                int newPoints = monthlyRewards.get(month) + points;
                monthlyRewards.put(month, newPoints);
                logger.debug("Updated {} month with {} points, new total: {}", month, points, newPoints);
            } else {
                monthlyRewards.put(month, points);
                logger.debug("Added {} month with {} points", month, points);
            }
        }

        logger.info("Monthly reward points calculation completed");
        return monthlyRewards;
    }

    // Calculate reward points for a given amount
    public int calculateRewardPoints(double amount) {
        logger.debug("Calculating reward points for amount: {}", amount);

        int points = 0;

        if (amount > 100) {
            points += (amount - 100) * 2;
            points += 50;  // Points for the $50 to $100 range
            logger.debug("Amount greater than 100, points: {}", points);
        } else if (amount > 50) {
            points += (amount - 50) * 1;
            logger.debug("Amount greater than 50 but less than or equal to 100, points: {}", points);
        } else {
            logger.debug("Amount less than or equal to 50, no additional points");
        }

        return points;
    }
    
 // Calculate total reward points
    public int calculateTotalRewardPoints(List<CustomerTransaction> transactions) {
        logger.info("Calculating total reward points");

        int totalPoints = 0;

        for (CustomerTransaction transaction : transactions) {
            int points = calculateRewardPoints(transaction.getAmount());
            totalPoints += points;
            logger.debug("Added {} points from transaction, new total: {}", points, totalPoints);
        }

        logger.info("Total reward points calculation completed, total points: {}", totalPoints);
        return totalPoints;
    }
}

   

=======
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

>>>>>>> aeb808a8a5fb0aecd6bfc047de98b6c9437014c3
