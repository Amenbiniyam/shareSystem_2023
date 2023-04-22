package com.act.sharemanagementApi.model;

import lombok.Data;

import java.time.LocalDate;
@Data
public class SubscriptionDTO {
    private Long shareholder_id;

    private int numberOf_Share;

   // private int shareId;

    private LocalDate subs_date;
}
