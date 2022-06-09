package com.springboot.transactionmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class TranscationalModel {

    private int fromId;

    private int toId;
    private int amount;

}
