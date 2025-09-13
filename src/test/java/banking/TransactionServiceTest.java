package banking;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    private final TransactionService service = new TransactionService();

    private final List<Transaction> transactions = Arrays.asList(
            new Transaction(1, "ACC123", 6000, "DEBIT"),
            new Transaction(2, "ACC124", 3000, "DEBIT"),
            new Transaction(3, "ACC125", 8000, "CREDIT"),
            new Transaction(4, "ACC126", 1500, "CREDIT")
    );

    @Test
    void testHighValueDebits() {
        List<Transaction> result = service.getHighValueDebits(transactions);
        assertEquals(1, result.size());
        assertEquals("ACC123", result.get(0).getAccountNumber());
    }

    @Test
    void testTotalTransactionAmount() {
        double total = service.getTotalTransactionAmount(transactions);
        assertEquals(18500.0, total);
    }

    @Test
    void testFirstCreditTransaction() {
        Optional<Transaction> credit = service.getFirstCreditTransaction(transactions);
        assertTrue(credit.isPresent());
        assertEquals("ACC125", credit.get().getAccountNumber());
    }

    @Test
    void testNoCreditTransaction() {
        List<Transaction> onlyDebits = Arrays.asList(
                new Transaction(1, "ACC200", 7000, "DEBIT")
        );
        Optional<Transaction> credit = service.getFirstCreditTransaction(onlyDebits);
        assertTrue(credit.isEmpty());
    }

    @Test
    void testEmptyTransactionListThrows() {
        List<Transaction> emptyList = Collections.emptyList();
        assertThrows(RuntimeException.class, () -> service.getFirstCreditOrThrow(emptyList));
    }
}
