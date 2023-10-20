
public class InvestorInfo {
  private int investorId;
  private int uniqueSyndicateCount;
  private double totalInvestmentAmount;

  public InvestorInfo(int investorId, int uniqueSyndicateCount, double totalInvestmentAmount) {
    this.investorId = investorId;
    this.uniqueSyndicateCount = uniqueSyndicateCount;
    this.totalInvestmentAmount = totalInvestmentAmount;
  }

  public int getInvestorId() {
    return investorId;
  }

  public int getUniqueSyndicateCount() {
    return uniqueSyndicateCount;
  }

  public double getTotalInvestmentAmount() {
    return totalInvestmentAmount;
  }

  @Override
  public String toString() {
    return "InvestorInfo{" +
      "investorId=" + investorId +
      ", uniqueSyndicateCount=" + uniqueSyndicateCount +
      ", totalInvestmentAmount=" + totalInvestmentAmount +
      '}';
  }
}
