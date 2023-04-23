package com.act.sharemanagementApi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Entity(name = "tbl_payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_id",referencedColumnName = "id")
    private Subscription subscription;

    @Column(nullable = false)
    private double paid_amount;
    @Column(nullable = true)
    private double weighted;
    @Column(nullable = false)
    private LocalDate paid_date;
    @Column(nullable = false)
    private String status;
}
