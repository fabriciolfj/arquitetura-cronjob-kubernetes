package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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
    @Column(name = "describe_transaction", nullable = false)
    private String describe;
    @Column(name = "value", nullable = false)
    private BigDecimal value;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "uuid", unique = true, nullable = false)
    private String uuid;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "transaction")
    private List<PaymentEntity> payments;
    @Column(name = "date_transaction", nullable = false)
    private String date;
}
