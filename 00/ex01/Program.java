import java.util.Scanner;

public class Program
{

    public static int isPrimCount(int number)
    {
        int numberCheker = 2;
        int i = 1;
        int count = 1;
    
        while (numberCheker * numberCheker <= number)
            numberCheker++;
        
        while (++i  <= numberCheker - 1)
        {
            if (number % i  == 0)
                return -count;
            count++;
        }
        return count;
    }

    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt())
        {
            int number = sc.nextInt();
            if (number <= 1)
                System.out.print("IllegalArgument");
            else
            {
                int result = isPrimCount(number);
                if (result > 0)
                    System.out.println("true " + result);
                else
                    System.out.println("false " + (-result));
            }
        }
        else
            System.out.print("IllegalArgument");
        sc.close();
    }
}
