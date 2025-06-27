import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Bank Account class
class Account {
    private int balance = 1000;
    private final Lock lock = new ReentrantLock();

    // Synchronized deposit
    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " is depositing ₹" + amount + "...");
        balance += amount;
        System.out.println("Deposit successful!\nCurrent Balance: ₹" + balance);
    }

    // Lock-based withdraw
    public void withdraw(int amount) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is attempting to withdraw ₹" + amount + "...");
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawal successful!\nCurrent Balance: ₹" + balance);
            } else {
                System.out.println("Insufficient balance.\nWithdrawal failed!");
            }
        } finally {
            lock.unlock();
        }
    }

    // Getter for balance
    public int getBalance() {
        return balance;
    }
}

// Deposit Thread class
class DepositThread extends Thread {
    private final Account account;
    private final int amount;

    DepositThread(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @SuppressWarnings("override")
    public void run() {
        account.deposit(amount);
    }
}

// Withdraw Thread class
class WithdrawThread extends Thread {
    private final Account account;
    private final int amount;

    WithdrawThread(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @SuppressWarnings("override")
    public void run() {
        account.withdraw(amount);
    }
}

// Main Application
public class BankApp {
    static Scanner sc = new Scanner(System.in);
    static Account account = new Account();

    public static void main(String[] args) {
        String option;
        char choice;

        System.out.println("\n---- Bank Management System ----");

        do {
            System.out.println("\n\nApplication Menu:");
            System.out.println("1. Deposit Amount");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice: ");

            choice = sc.nextLine().charAt(0);

            switch (choice) {
                case '1' -> depositMoney();
                case '2' -> withdrawMoney();
                case '3' -> showBalance();
                case '4' -> {
                    exitApp();
                    return;
                }
                default -> System.out.println("Error: Invalid choice!\nNote: Please enter 1-4.");
            }

            System.out.print("\nDo you want to continue using the application? (Y/N): ");
            option = sc.nextLine().trim().toLowerCase();

        } while (option.equals("y"));

        exitApp();
    }

    static void exitApp() {
        System.out.println("\nThank you for banking with us!\nExiting the application...");
        sc.close();
    }

    @SuppressWarnings("UseSpecificCatch")
    static void depositMoney() {
        try {
            System.out.print("\nEnter amount to deposit: ");
            int amount = Integer.parseInt(sc.nextLine());

            Thread t1 = new DepositThread(account, amount);
            t1.setName("DepositorThread");
            t1.start();
            t1.join();
        } catch (Exception e) {
            System.out.println("Error: Invalid input!\nNote: Amount must be a valid number.");
        }
    }

    @SuppressWarnings("UseSpecificCatch")
    static void withdrawMoney() {
        try {
            System.out.print("\nEnter amount to withdraw: ");
            int amount = Integer.parseInt(sc.nextLine());

            Thread t2 = new WithdrawThread(account, amount);
            t2.setName("WithdrawerThread");
            t2.start();
            t2.join();
        } catch (Exception e) {
            System.out.println("Error: Invalid input!\nNote: Amount must be a valid number.");
        }
    }

    static void showBalance() {
        System.out.println("\nCurrent Account Balance: ₹" + account.getBalance());
    }
}
