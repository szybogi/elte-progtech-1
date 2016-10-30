package bank;

import exceptions.NoCoverException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BankAccount {
    protected final String accountNumber;
    protected double balance;
    protected List<String> history = new ArrayList<>();
    private Date date;

    public BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    public double getBalance(){
        return balance;
    }

    public void withdraw(double withdraw) throws NoCoverException {
        if(balance < withdraw) {
            throw new NoCoverException(this,balance);
        }
        date = new Date();
        String da = String.valueOf(date);
        String w = String.valueOf(withdraw);
        history.add("WITHDRAW " + w + " " + da);
        balance -= withdraw;
    }


    public  void deposit(double deposit){
        date = new Date();
        String da = String.valueOf(date);
        String d = String.valueOf(deposit);
        history.add("DEPOSIT " + d + " " + da);
        balance += deposit;
    }

    public void modifyBalance(String action, double amount) throws NoCoverException {
        switch (action) {
            case "WITHDRAW": withdraw(amount);
                break;
            case "DEPOSIT": deposit(amount);
                break;
            default:
                break;
        }
    }

    public String show(){
        String b = String.valueOf(balance);
        return "BankAccountId: " + accountNumber + ", Balance: " + b;
    }

}
