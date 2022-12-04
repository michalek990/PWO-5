import org.example.Zadanie_1.Transaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {
    @Test
    void groupedAssertions() {
        Transaction transaction = new Transaction();
        assertAll("Transaction quota",
                () -> assertEquals(1000, transaction.getPaid()),
                () -> assertEquals(1000, transaction.getEarned())
        );
    }

    @Test
    @DisplayName("User name or surname is Paweł")
    void testUserNameAndSurname() {
        Transaction transaction = new Transaction();
        assertAll("User name and surname",
                () -> assertEquals("Paweł", transaction.getName()),
                () -> assertEquals("Paweł", transaction.getSurname())
        );
    }

    @Test
    void timeoutExceeded() {
        Transaction transaction = new Transaction();
        String result = assertTimeout(ofSeconds(6), () -> {
            return transaction.longOperation();
        });
    }

    @Test
    void timeoutExceededWithPreemptively() {
        Transaction transaction = new Transaction();
        String result = assertTimeoutPreemptively(ofSeconds(6), () -> {
            return transaction.longOperation();
        });
    }
}
