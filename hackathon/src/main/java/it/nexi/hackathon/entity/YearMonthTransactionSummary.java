package it.nexi.hackathon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YearMonthTransactionSummary {
    private Integer year;
    private Integer month;
    private BigDecimal totalAmount;
}