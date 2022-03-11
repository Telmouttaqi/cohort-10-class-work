public class BankAccount implements MoneyStorage{

    private double balance;
    private String accountNumber;

    public BankAccount(double startingBalance, String accountNumber) {
        this.balance = -startingBalance;
        this.accountNumber = accountNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getDescription() {
        return String.format("Mortgage #%s", accountNumber);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }
        balance = Math.min(0.0, balance + amount);
        return true;
    }

    @Override
    public double withdraw(double amount) {
        // bank account
        if(amount < -25)
        {
        return amount;
        }
        return 0;
    }
}


