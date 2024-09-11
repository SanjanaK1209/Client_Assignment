package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.RewardPoints;

@Repository
public interface RewardPointsRepository extends JpaRepository<RewardPoints, Long> {
}

