package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "value", nullable = false)
    private BigDecimal value;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "type", nullable = false)
    private String type;
    @JoinColumn(name = "transaction_id", nullable = false)
    @ManyToOne
    private TransactionEntity transaction;
}
