package com.rta.highestbid.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class Bid {

    private String id;

    private BigDecimal amount;

    private String vin;

}
