package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository;

import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    Optional<TransactionEntity> findByUuid(final String uuid);
}
