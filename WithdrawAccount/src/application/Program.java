package application;

import model.entities.Account;
import model.exception.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println();
            System.out.println("Enter account data:");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, name, balance, withdrawLimit);

            System.out.printf("%nEnter amount for withdraw: ");
            double amount = sc.nextDouble();

            account.whitdraw(amount);
            System.out.printf("%nNew balance: $%.2f", account.getBalance());
        }
        catch (DomainException e){
            System.out.println("Withdraw error: "+e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}
