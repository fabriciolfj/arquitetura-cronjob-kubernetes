package com.github.fabriciolfj.transacaoservice.interfaceadapter.gateway;

import com.github.fabriciolfj.transacaoservice.business.transaction.GetTransaction;
import com.github.fabriciolfj.transacaoservice.business.transaction.RegisterTransaction;
import com.github.fabriciolfj.transacaoservice.domain.Transaction;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.TransactionNotFoundException;
import com.github.fabriciolfj.transacaoservice.domain.exceptions.domain.InfrastructureException;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository.TransactionRepository;
import com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository.mapper.TransactionEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static com.github.fabriciolfj.transacaoservice.interfaceadapter.providers.repository.mapper.TransactionEntityMapper.toEntity;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransactionGateway implements RegisterTransaction, GetTransaction {

    private final TransactionRepository transactionRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(final Transaction transaction) {
        try{
            transactionRepository.save(toEntity(transaction));
        } catch (Exception ex) {
            log.error("Failed to save transaction, details: {}", ex.getMessage());
            throw new InfrastructureException();
        }
    }

    @Override
    public Transaction find(final String uuid) {
        return transactionRepository.findByUuid(uuid)
                .map(TransactionEntityMapper::toDomain)
                .orElseThrow(() -> new TransactionNotFoundException());
    }
}
