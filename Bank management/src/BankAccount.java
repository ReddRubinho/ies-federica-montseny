import java.util.Objects;

public class BankAccount {
    private String accountNumber;
    private String balance;

    /*-----------------------------Constructors--------------------------------*/
    public BankAccount(String accountNumber, String balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public BankAccount(){}

    /*----------------------------Getters & Setters-------------------------------------*/
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    /*-------------------------------Other Methods-----------------------------------*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return accountNumber.equals(that.accountNumber) && balance.equals(that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, balance);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
