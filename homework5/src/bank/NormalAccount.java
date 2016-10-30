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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount bankAccount = (BankAccount) o;

        return accountNumber != null ? accountNumber.equals(bankAccount.accountNumber) : bankAccount.accountNumber == null;

    }
}
