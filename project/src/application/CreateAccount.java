package application;
import java.util.ArrayList;
import java.util.Scanner;

class Customer 
{
    private String id;
    private String password;
    private String name;
    private String address;
    private String phone;
    private String creditCard;

    public Customer(String id, String password, String name, String address, String phone, String creditCard) 
    {
        id = this.id;
        password = this.password;
        name = this.name;
        address = this.address;
        phone = this.phone;
        creditCard = this.creditCard;
    }

    public String getId() 
    {
        return this.id;
    }
}

class Account 
{
    private Customer c;
    private String accountType;
    private int feePending;

    public Account(Customer c, int accountType) 
    {
        this.c = c;
        if (accountType == 1) 
        {
            this.accountType = "Regular";
            this.feePending = 0;
        } 
        else if (accountType == 2) 
        {
            this.accountType = "Premium";
            this.feePending = 40;
            System.out.println("Thank you for choosing premium. You will be charged $40 annualy for Premium Account access which will be taken out of your account on your first purchase of the year.");
        }
        System.out.println("Account created successfully!");
    }

    public Customer getCustomer() 
    {
        return c;
    }
}

class Main 
{
    public static void main(String[] args) 
    {
        ArrayList<Account> accountDB = new ArrayList<Account>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your ID: ");
        String id = input.nextLine();
        boolean flag = false;
        while(true)
        {
            flag = false;
            for(Account a: accountDB)
            {
                if(a.getCustomer().getId().equals(id))
                {
                    System.out.println("ID already exists, please enter a different ID: ");
                    id = input.nextLine();
                    flag = true;
                    break;
                }
            }
            if(!flag)
            {
                break;
            }
        }
        System.out.print("Enter your password: ");
        String password = input.nextLine();
        System.out.print("Enter your Name: ");
        String name = input.nextLine();
        System.out.print("Enter your Address: ");
        String address = input.nextLine();
        System.out.print("Enter your phone number: ");
        String phone = input.nextLine();
        System.out.print("Enter your Credit Card Number: ");
        String creditCard = input.nextLine();
        Customer c = new Customer(id, password, name, address, phone, creditCard);
        int accountType = -1;
        System.out.print("Choose your account type\nEnter 1 for Regular or 2 for Premium: ");
        accountType = input.nextInt();
        while(accountType != 1 && accountType != 2)
        {
            System.out.println("Invalid input! Enter again: ");
            accountType = input.nextInt();
        }
        accountDB.add(new Account(c, accountType));
    }
}