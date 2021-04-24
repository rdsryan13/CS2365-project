import java.util.Scanner;

public class LogOn
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter id: ");
        int id = input.nextInt();
        System.out.println("Enter password: ");
        String password = input.nextLine();
        if ( id != 0 && password != "Null")
        {
            System.out.println("Welcome!");
        }
    }  
}