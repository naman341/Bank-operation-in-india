class RBI {
    int MIN_BALANCE = 0;
    int MAX_WITHDRAWAL_LIMIT = 0;

    double getInterestRate() {
        // virtual function to get the interest rate
        return 0.0;
    }

    boolean isSavingsAccount() {
        // virtual function to check if the account is a savings account
        return false;
    }
}

class Account {
    String accNo;
    double balance;

    Account(String accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    double withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            return amount;
        } else {
            System.out.println("Insufficient balance");
            return 0.0;
        }
    }

    double checkBalance() {
        return this.balance;
    }
}

class Customer {
    String name, address, phoneNo;
    Account account;

    Customer(String name, String address, String phoneNo, Account account) {
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.account = account;
    }

    void deposit(double amount) {
        this.account.deposit(amount);
    }

    double withdraw(double amount) {
        return this.account.withdraw(amount);
    }

    double checkBalance() {
        return this.account.checkBalance();
    }
}

class SBI extends RBI {
    int MIN_BALANCE = 1000;
    int MAX_WITHDRAWAL_LIMIT = 50000;

    double getInterestRate() {
        return 4.5;
    }

    boolean isSavingsAccount() {
        return true;
    }
}

class ICICI extends RBI {
    int MIN_BALANCE = 5000;
    int MAX_WITHDRAWAL_LIMIT = 75000;

    double getInterestRate() {
        return 5.0;
    }

    boolean isSavingsAccount() {
        return true;
    }
}

class PNB extends RBI {
    int MIN_BALANCE = 2000;
    int MAX_WITHDRAWAL_LIMIT = 100000;

    double getInterestRate() {
        return 4.0;
    }

    boolean isSavingsAccount() {
        return true;
    }
}

public class BankDemo {
    public static void main(String[] args) {
        // create an SBI account for a customer
        Account sbiAccount = new Account("SBI-12345", 5000);
        Customer sbiCustomer = new Customer("John Doe", "Bangalore", "9876543210", sbiAccount);

        // check balance and interest rate
        System.out.println(sbiCustomer.checkBalance());
        System.out.println(new SBI().getInterestRate());

        // withdraw some amount
        sbiCustomer.withdraw(2000);
        System.out.println(sbiCustomer.checkBalance());

        // create an ICICI account for a customer
        Account iciciAccount = new Account("ICICI-12345", 10000);
        Customer iciciCustomer = new Customer("Jane Doe", "Mumbai", "9876543210", iciciAccount);

        // check balance and interest rate
        System.out.println(iciciCustomer.checkBalance());
        System.out.println(new ICICI().getInterestRate());
    }
}
