package com.act.sharemanagementApi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "tbl_shareholders")
@Data
public class Shareholder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String ownershipType;

    @Column(nullable = true)
    private LocalDate dateOfBirth;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false, unique = false)
    private String address;

    @Column(nullable = false)
    private LocalDate createdDate = LocalDate.now();



//    @OneToMany(mappedBy = "shareholder_id", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Subscription> subscriptions;
//    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
//    @JoinColumn(name = "firstName")
//    private User user;
}

// EXAMPLE OF SETTER AND GETTER METHODS
//    public String getFirstName() {
//        return firstName.toUpperCase();
//    }
//    public void setFirstName(String firstName) {
//        //validation
//        this.firstName = firstName;
//    }
//    Account myAccount = new Account();
//FAIL myAccount.firstName = "Biniam";
//CORRECT myAccount.setFirstName("Biniam");

