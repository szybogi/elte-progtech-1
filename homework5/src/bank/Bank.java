package bank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {
    private List<BankAccount> bankAccounts = new ArrayList<>();


    public Bank(List<BankAccount> bankAccounts){
        this.bankAccounts = bankAccounts;
    }

    public void addNewBankAccount(BankAccount bankAccount) {
        if(!bankAccounts.contains(bankAccount)) {
            bankAccounts.add(bankAccount);
        }
    }

    public void update(){
        for(int i = 0; i < bankAccounts.size();i++){
            if(bankAccounts.get(i) instanceof NormalAccount && bankAccounts.get(i).getBalance() < 0) {
                bankAccounts.get(i).show();
            }
            if(bankAccounts.get(i) instanceof SavingsAccount) {
                ((SavingsAccount) bankAccounts.get(i)).update();
            }

        }
    }

    public static List<BankAccount> orderByModify(List<BankAccount> accounts) {
        return accounts.stream().sorted((a, b) -> {
            if(a.getHistory().size() < b.getHistory().size()) return 1;
            else if(a.getHistory().size() > b.getHistory().size()) return  -1;
            else return 0;
        }).collect(Collectors.toList());
    }

    public static List<BankAccount> orderByBalance(List<BankAccount> accounts) {
        int n = 5;
        List<BankAccount> topFive = orderByModify(accounts).subList(0, n);
        return accounts.stream().sorted((a, b) -> {
            if(a.getBalance() < b.getBalance()) return 1;
            else if(a.getBalance() > b.getBalance()) return  -1;
            else return 0;
        }).collect(Collectors.toList());

    }

    public static void showTopFive(){
        List<BankAccount> accounts = new ArrayList<>();
        orderByBalance(accounts).forEach(BankAccount:: show);
    }





}
