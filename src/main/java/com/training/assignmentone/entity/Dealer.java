package com.training.assignmentone.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dealer")
@Builder
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDealer;

    @Column(name = "name")
    private String name;

    @Column(name = "limit_p")
    private int limit_p;
}
