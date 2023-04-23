package com.act.sharemanagementApi.repo;

import com.act.sharemanagementApi.model.Payment;
import com.act.sharemanagementApi.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    void deleteById(Long id);
    Optional<Payment> findById (Long id);
}
