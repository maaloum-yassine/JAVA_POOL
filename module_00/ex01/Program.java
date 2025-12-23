import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.close();

        if (n <= 1)
        {
            System.err.println("IllegalArgument");
            System.exit(-1);
            // return;
        }

        int count = 0;
        boolean isPrime = true;
        double sqrtN = Math.sqrt(n);
        
        if (sqrtN != (int)sqrtN)
            sqrtN = (int)sqrtN + 1;
        for (int i = 2; i <= sqrtN; i++)
        {
            count++;
            if (n % i == 0)
            {
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime + " " + count);
    }
}
