import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProgramTest {

    @Test
    public void Test_Deposit_ValidAmount() throws Exception {
        Program account = new Program(1000);
        account.Deposit(500);

        double actual = account.getBalance();
        double expected = 1500;

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void Test_Deposit_NegativeAmount() {
        Program account = new Program(1000);
        String actualMessage = "";

        try {
            account.Deposit(-200);
        } catch (Exception e) {
            actualMessage = e.getMessage();
        }

        String expectedMessage = "Deposit amount cannot be negative";
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void Test_Withdraw_ValidAmount() throws Exception {
        Program account = new Program(1000);
        account.Withdraw(300);

        double actual = account.getBalance();
        double expected = 700;

        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void Test_Withdraw_InsufficientFunds() {
        Program account = new Program(500);
        String actualMessage = "";

        try {
            account.Withdraw(800);
        } catch (Exception e) {
            actualMessage = e.getMessage();
        }

        String expectedMessage = "Insufficient funds.";
        assertEquals(expectedMessage, actualMessage);
    }
}
