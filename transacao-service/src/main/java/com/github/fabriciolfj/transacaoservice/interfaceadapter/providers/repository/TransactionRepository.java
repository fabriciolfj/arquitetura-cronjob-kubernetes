package com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository;

import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    @Query("Select t From TransactionEntity t join fetch t.payments p where t.uuid = :param")
    Optional<TransactionEntity> findByUuid(@Param("param") final String uuid);
}
