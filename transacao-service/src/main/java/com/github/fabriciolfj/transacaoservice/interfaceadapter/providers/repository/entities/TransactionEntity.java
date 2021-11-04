package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "describe_transaction", nullable = true)
    private String describe;
    @Column(name = "value", nullable = true)
    private BigDecimal value;
    @Column(name = "type", nullable = true)
    private String type;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "uuid", unique = true, nullable = false)
    private String uuid;
    @Column(name = "payment_status", nullable = false)
    private String paymentStatus;
    @Column(name = "date_transaction", nullable = false)
    private String date;
}
