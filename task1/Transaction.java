
public class Transaction {
  private int investorId;
  private int syndicateId;
  private double transactionAmount;

  public Transaction(int investorId, int syndicateId, double transactionAmount) {
    this.investorId = investorId;
    this.syndicateId = syndicateId;
    this.transactionAmount = transactionAmount;
  }

  public int getInvestorId() {
    return investorId;
  }

  public void setInvestorId(int investorId) {
    this.investorId = investorId;
  }

  public int getSyndicateId() {
    return syndicateId;
  }

  public void setSyndicateId(int syndicateId) {
    this.syndicateId = syndicateId;
  }

  public double getTransactionAmount() {
    return transactionAmount;
  }

  public void setTransactionAmount(double transactionAmount) {
    this.transactionAmount = transactionAmount;
  }

  @Override
  public String toString() {
    return "Transaction{" +
      "investorId=" + investorId +
      ", syndicateId=" + syndicateId +
      ", transactionAmount=" + transactionAmount +
      '}';
  }
}
