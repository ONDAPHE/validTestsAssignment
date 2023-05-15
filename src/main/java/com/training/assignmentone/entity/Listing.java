package com.training.assignmentone.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "listing")
public class Listing {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String idListing;

    @Column(name = "vehicule")
    private String vehicule;

    @Column(name = "price")
    private Double price;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private EtatListing state;

    @ManyToOne
    @JoinColumn(name = "dealer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Dealer dealer;
}
