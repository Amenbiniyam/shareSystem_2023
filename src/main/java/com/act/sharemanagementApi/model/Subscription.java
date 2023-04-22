package com.act.sharemanagementApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "tbl_subscription")
@Data
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shareholder_id",referencedColumnName = "id")
    private Shareholder shareholder_id;

    @Column(nullable = false)
    private int numberOf_Share;




    @Column(nullable = false)
    private LocalDate subs_date;



}
