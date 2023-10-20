# Problem 2
- Alert System will be a decoupled part of more system or microservice

### Handle [maximumTransactionAmount]
- Before doing any transaction we will check the user's maximumTransactionAmount value from database and if it breaks the limit sends alert to fund manager
```code
public void userTransaction(def userId) {
  def user = User.findById(userId)
  if(transactionAmount > user.getMaximumTransactionAmount()) {
    // AlertSystem will be called
    AlertSystem.send('fundManager', 'User XYZ exceeds the Limit')
    return;
  }
  doSystemTransactionHere()
}
```

### Handle [suddenSpike]
- It can be achieved by RateLimiter along with LoadBalancer if we use cloud like AWS it will be some configuration on it
- Another way we can run a cron job in a time duration and calculate ratio of transactions within that time duration and if it 10X then send an alert to fund manager by Alert System
```code
@Cron(cron = 'suddenSpike', period = '0 0/5 * * * ?")
public void suddenSpike () {
  def numberOfTransactionsLastHour = countLastHoursTransactions()
  def numberOfTransactionsLast55Min = countLast55MinTransactions()
  if(numberOfTransactionsLast55Min > numberOfTransactionsLastHour * 10) {
    // AlertSystem will be called
    AlertSystem.send('fundManager', 'User XYZ suddenSpike happend')
    return;
}

```
### Notes
- Algorithm and data structures - We can use Kafka algorithm and behind it use Distributed Queue as data structure, kafka can process data almost real-time
- Scalability - When user grows we can deploy multiple instance of Alert System
- Data integrity - We can use PostgresSQL as it can ACID and commit rollback
- Fault tolerance - We can use Resilience4j with SpringBoot application as it covers Circuit Breaker, Rate Limiter, Retry or Bulkhead
- Fault tolerance - We can also use Load balancer for request in case of instance request load, replica for database (read/write) 


### Below a high level diagram of Alert System

![Resources](https://github.com/javagrails/auptimate-problems/blob/main/docs/real-time-alert-system.png)

