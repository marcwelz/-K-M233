package com.springboot.transactionmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class TranscationalModel {

    private int fromId;

    private int toId;
    private int amount;

}
