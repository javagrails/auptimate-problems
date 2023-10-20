
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Interview {
  public static void main(String[] args){
    Interview interview = new Interview();
    List<InvestorInfo> result = interview.solution();
    System.out.println(result);
  }
  public List<InvestorInfo> solution() {
    List<Transaction> transactionsList = sampleTransactionData();

    /**
     * Finding each investor's total investment amount
     */
    Map<Integer, Double> totalInvestmentByInvestor = transactionsList.stream()
      .collect(Collectors.groupingBy(
        Transaction::getInvestorId,
        Collectors.summingDouble(Transaction::getTransactionAmount)
      ));

    /**
     * Finding each investor's unique number of syndicate
     */
    Map<Integer, Integer> uniqueSyndicateCountByInvestor = transactionsList.stream()
      .collect(Collectors.groupingBy(
        Transaction::getInvestorId,
        Collectors.mapping(Transaction::getSyndicateId, Collectors.toSet())
      )).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, it -> it.getValue().size()));

    /**
     * Final output
     * Select top 5 investors who have invested in the highest number of unique syndicates,
     * along with the total amount they have invested
     */
    List<InvestorInfo> investorInfos = totalInvestmentByInvestor.entrySet().stream()
      .map(entry -> new InvestorInfo(entry.getKey(), uniqueSyndicateCountByInvestor.getOrDefault(entry.getKey(), 0), entry.getValue()))
      .sorted(Comparator.comparingLong(InvestorInfo::getUniqueSyndicateCount).reversed())
      .limit(5)
      .toList();

    return investorInfos;
  }

  /**
   * Generating sample transaction data
   * @return transactions
   */
  private List<Transaction> sampleTransactionData() {
    List<Transaction> transactions = new ArrayList<>(50);

    transactions.add(new Transaction(1, 1, 10));
    transactions.add(new Transaction(1, 1, 10));
    transactions.add(new Transaction(1, 2, 20));
    transactions.add(new Transaction(1, 3, 30));

    transactions.add(new Transaction(2, 1, 10));
    transactions.add(new Transaction(2, 1, 10));
    transactions.add(new Transaction(2, 2, 20));
    transactions.add(new Transaction(2, 3, 30));
    transactions.add(new Transaction(2, 4, 40));

    transactions.add(new Transaction(3, 3, 30));
    transactions.add(new Transaction(3, 4, 40));
    transactions.add(new Transaction(3, 5, 50));
    transactions.add(new Transaction(3, 6, 60));
    transactions.add(new Transaction(3, 7, 70));
    transactions.add(new Transaction(3, 8, 80));

    transactions.add(new Transaction(4, 3, 30));
    transactions.add(new Transaction(4, 3, 30));
    transactions.add(new Transaction(4, 3, 30));
    transactions.add(new Transaction(4, 3, 30));
    transactions.add(new Transaction(4, 3, 30));
    transactions.add(new Transaction(4, 3, 30));

    transactions.add(new Transaction(6, 1, 10));
    transactions.add(new Transaction(6, 4, 40));
    transactions.add(new Transaction(6, 5, 50));
    transactions.add(new Transaction(6, 4, 40));
    transactions.add(new Transaction(6, 7, 70));
    transactions.add(new Transaction(6, 9, 90));
    transactions.add(new Transaction(6, 8, 80));

    transactions.add(new Transaction(11, 4, 40));
    transactions.add(new Transaction(11, 1, 10));
    transactions.add(new Transaction(11, 5, 50));
    transactions.add(new Transaction(11, 7, 70));
    transactions.add(new Transaction(11, 9, 90));
    transactions.add(new Transaction(11, 8, 80));

    transactions.add(new Transaction(9, 1, 10));
    transactions.add(new Transaction(9, 3, 30));
    transactions.add(new Transaction(9, 5, 50));
    transactions.add(new Transaction(9, 4, 40));
    transactions.add(new Transaction(9, 7, 70));
    transactions.add(new Transaction(9, 9, 90));
    transactions.add(new Transaction(9, 8, 80));
    transactions.add(new Transaction(9, 10, 100));

    return transactions;
  }
}

