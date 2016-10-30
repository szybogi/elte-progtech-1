import bank.Bank;
import bank.BankAccount;
import bank.NormalAccount;
import bank.SavingsAccount;
import exceptions.NoCoverException;

import java.util.ArrayList;

public class Main {
    private static Bank bank = new Bank(new ArrayList<>());

    public static void main(String[]args) throws NoCoverException {
        BankAccount normalAccount01 = new NormalAccount("12345678-87654321", -40000);
        BankAccount normalAccount02 = new NormalAccount("12654328-87610321", -50000);
        BankAccount normalAccount03 = new NormalAccount("87654321-87654321", -6000);
        BankAccount normalAccount04 = new NormalAccount("88765432-98765431", -100000);
        BankAccount savingsAccount01 = new SavingsAccount("98765432-98765432", 1.1);
        BankAccount savingsAccount02 = new SavingsAccount("98766789-43211234", 1.01);
        BankAccount savingsAccount03 = new SavingsAccount("65656565-82828282", 1.2);
        BankAccount savingsAccount04 = new SavingsAccount("11111111-22222222", 1.1);


        bank.addNewBankAccount(normalAccount01);
        bank.addNewBankAccount(normalAccount02);
        bank.addNewBankAccount(normalAccount03);
        bank.addNewBankAccount(normalAccount04);
        bank.addNewBankAccount(savingsAccount01);
        bank.addNewBankAccount(savingsAccount02);
        bank.addNewBankAccount(savingsAccount03);
        bank.addNewBankAccount(savingsAccount04);

        bank.deposit(normalAccount01, 10000);
        bank.deposit(normalAccount01, 20000);
        bank.deposit(normalAccount02, 100000);
        bank.deposit(normalAccount03, 10000);
        bank.deposit(normalAccount04, 1000);
        bank.withdraw(savingsAccount01, 500);
        bank.deposit(savingsAccount02, 1000);
        bank.deposit(savingsAccount02, 2000);
        bank.deposit(savingsAccount03, 40000);
        bank.deposit(savingsAccount04, 10000);


        Bank.showTopFive(bank);


    }
}
