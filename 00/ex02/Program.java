import java.util.Scanner;

public class Program
{
    public static int calcSum(int number)
    {
        int res = 0;

        while (number > 0) {
            res += number % 10;
            number = number / 10;    
        }
        return res;
    }

    public static boolean isPrim(int number)
    {
        int numberCheker = 2;
        int i = 1;

        while (numberCheker * numberCheker <= number)
            numberCheker++;
        while (++i  <= numberCheker - 1)
        {
            if (number % i  == 0)
                return false;
        }
        
        return true;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int number  = 0;
        int sumOfDigit = 0;
        int count = 0;
    
        while (true)
        {
            number = sc.nextInt();
            if (number == 42)
                break ;
            sumOfDigit = calcSum(number);
            if ((number > 2) && isPrim(sumOfDigit))
                count++;
        }
        System.out.println("Count of coffee-request :" + count);
        sc.close();
    }
}