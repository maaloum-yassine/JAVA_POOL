import java.util.Scanner;

public class Program
{
    public static int atoi(String arg)
    {
        long res = 0;
        int sign = 1;
        int i = -1;
        int length_arg = arg.length();

        while (++i < length_arg) {
            char c = arg.charAt(i);
            if (!(c == ' ' || c == '\t' || c == '\n'))
                break ;
        }   
        if ((i < length_arg) && (arg.charAt(i) == '-' || arg.charAt(i) == '+')) {
            if (arg.charAt(i) == '-')
                sign = -1;
            i++;
        }

        while (i < length_arg) {
            char c = arg.charAt(i); 
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
        if (i < length_arg)
        {
            char c = arg.charAt(i);
            if (c != '\t' && c != ' ')
                return  -1;
        }
        return ((int)res * sign);
    }

    static int CheckPrime(int number)
    {
        int numberCheker = number;

        while (--numberCheker > 1)
        {
            if (number % numberCheker == 0)
                return numberCheker;
        }
        return -1;
    }

    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);
        String number_in = sc.next();
            
        int number = atoi(number_in);
        if (number <= 1)
            System.err.println("IllegalArgument");
        else
        {
            int result = CheckPrime(number);
            if (result != -1)
                System.out.println("true " + number);
            else
                System.out.println("false " + number);
        }
        sc.close();
    }
}
