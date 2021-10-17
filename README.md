# Arquitetura cronjob kubernetes
- Nessa arquitetura, faremos uso de alguns recursos mais avançados do kubernetes, e estaram envolvidos os seguintes serviços:
  - transação financeira 
    - receberá uma transação, seja: pagamento, transferencia etc
    - enviara a transação para avalição se há fraude
    - a transação terá status 
 - transação job
    - colocará em no topic fraude as transações pendentes 
  - fraudes service
    - analise das transações.  
