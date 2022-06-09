package com.springboot.transactionmanagement.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Konto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kontoid;
    private String name;
    private int saldo;

}
