package bank;

public class NormalAccount extends BankAccount {
    private double overdraftLimit;
    public NormalAccount(String accountNumber, double overdraftLimit) {
        super(accountNumber);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit(){
        return overdraftLimit;
    }

}
