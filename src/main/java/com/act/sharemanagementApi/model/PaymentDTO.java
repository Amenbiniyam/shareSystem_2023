package com.act.sharemanagementApi.model;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PaymentDTO {
    private Long subscription_id;

    private double paid_amount;
    private double weighted;

    // private int shareId;

    private LocalDate paid_date;
    private String status;
}
