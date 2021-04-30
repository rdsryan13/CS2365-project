package application;
import java.util.Scanner;

public class LogOut
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter '0' to log out:");
        int num = input.nextInt();
        if(num == 0)
        {
            System.out.println("Logged out");
        }
        else
        {
            while(num != 0)
            {
                System.out.println("Enter '0' to log out:");
                num = input.nextInt();
            }
            System.out.println("Logged out");
        }
    }
}
