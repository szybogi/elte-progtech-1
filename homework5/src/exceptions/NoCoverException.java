package exceptions;
import bank.BankAccount;

public class NoCoverException extends Exception {
    private final BankAccount bankAccount;
    private final double amount;

    public NoCoverException(BankAccount bankAccount, double amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public double getWithdraw() {
        return amount;
    }
}
