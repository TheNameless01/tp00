import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void depositShouldIncreaseBalance() {
        BankAccount account = new BankAccount(100.0, 0.05);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void depositShouldThrowExceptionForNegativeAmount() {
        BankAccount account = new BankAccount(100.0, 0.05);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50.0));
    }

    @Test
    void withdrawShouldDecreaseBalance() {
        BankAccount account = new BankAccount(100.0, 0.05);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance());
    }

    @Test
    void withdrawShouldThrowExceptionForNegativeAmount() {
        BankAccount account = new BankAccount(100.0, 0.05);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50.0));
    }

    @Test
    void withdrawShouldThrowExceptionForInsufficientBalance() {
        BankAccount account = new BankAccount(100.0, 0.05);
        assertThrows(IllegalStateException.class, () -> account.withdraw(150.0));
    }

    @Test
    void transferShouldTransferAmountBetweenAccounts() {
        BankAccount account1 = new BankAccount(100.0, 0.05);
        BankAccount account2 = new BankAccount(50.0, 0.05);
        account1.transfer(30.0, account2);
        assertEquals(70.0, account1.getBalance());
        assertEquals(80.0, account2.getBalance());
    }

    @Test
    void transferShouldThrowExceptionForNegativeAmount() {
        BankAccount account1 = new BankAccount(100.0, 0.05);
        BankAccount account2 = new BankAccount(50.0, 0.05);
        assertThrows(IllegalArgumentException.class, () -> account1.transfer(-30.0, account2));
    }

    @Test
    void transferShouldThrowExceptionForNullOtherAccount() {
        BankAccount account1 = new BankAccount(100.0, 0.05);
        assertThrows(NullPointerException.class, () -> account1.transfer(30.0, null));
    }

    @Test
    void addInterestShouldIncreaseBalanceWithInterest() {
        BankAccount account = new BankAccount(100.0, 0.05);
        account.addInterest();
        assertEquals(105.0, account.getBalance());
    }
}