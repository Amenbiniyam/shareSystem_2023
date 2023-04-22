package com.act.sharemanagementApi.repo;

import com.act.sharemanagementApi.model.Shareholder;
import com.act.sharemanagementApi.model.Subscription;
import com.act.sharemanagementApi.model.SubscriptionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    void deleteById(Long id);
    Optional<Subscription> findById (Long id);
}
