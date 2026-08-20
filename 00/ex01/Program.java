import java.util.Scanner;

public class Program
{
    public static int parseInteger(String strDigit)
    {
        long res = 0;
        int sign = 1;
        int i = -1;
        int lengthDigit = strDigit.length();

        while (++i < lengthDigit) {
            char c = strDigit.charAt(i);
            if (!(c == ' ' || c == '\t' || c == '\n'))
                break ;
        }   
        if ((i < lengthDigit) && (strDigit.charAt(i) == '-' || strDigit.charAt(i) == '+')) {
            if (strDigit.charAt(i) == '-')
                sign = -1;
            i++;
        }

        while (i < lengthDigit) {
            char c = strDigit.charAt(i); 
            if (c >= '0' && c <= '9')
            {
                if ((res * sign > Integer.MAX_VALUE) || (res * sign < Integer.MIN_VALUE))
                    return -2;
                res = res * 10 + c - '0';
            }
            else 
                break; 
            i++;
        }
        if (i < lengthDigit)
        {
            char c = strDigit.charAt(i);
            if (c != '\t' && c != ' ')
                return  -1;
        }
        return ((int)res * sign);
    }


    static int isPrimCount(int number)
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
        String number_in = sc.next();   
        int number = parseInteger(number_in);

        if (number <= 1)
            System.err.println("IllegalArgument");
        else
        {
            int result = isPrimCount(number);
            if (result > 0)
                System.out.println("true " + result);
            else
                System.out.println("false " + (-result));
        }
        sc.close();
    }
}
