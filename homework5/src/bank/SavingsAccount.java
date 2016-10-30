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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount bankAccount = (BankAccount) o;

        return accountNumber != null ? accountNumber.equals(bankAccount.accountNumber) : bankAccount.accountNumber == null;

    }


}
