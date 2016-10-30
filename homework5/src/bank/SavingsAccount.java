package bank;

public class SavingsAccount extends BankAccount{
    private double interest;
    public SavingsAccount(String accountNumber, double interest) {
        super(accountNumber);
        this.interest = interest;
    }

    public void update() {
        balance *= interest;
    }




}
