package banking;

import java.util.*;

public class TransactionService {
    public List<Transaction> getHighValueDebits(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> "DEBIT".equalsIgnoreCase(t.getType()) && t.getAmount() > 5000)
                .toList();
    }

    public double getTotalTransactionAmount(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getAmount)
                .reduce(0.0, Double::sum);
    }

    public Optional<Transaction> getFirstCreditTransaction(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> "CREDIT".equalsIgnoreCase(t.getType()))
                .findFirst();
    }

    public Transaction getFirstCreditOrThrow(List<Transaction> transactions) {
        return getFirstCreditTransaction(transactions)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }
}
