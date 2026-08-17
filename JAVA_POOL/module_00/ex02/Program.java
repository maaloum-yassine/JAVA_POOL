import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
            
    int number;
    int somme ;
    boolean isPrime ;
    int count;
 
    count = 0;
    Scanner scanner = new Scanner(System.in);
    while (true)
    {
        number = scanner.nextInt();
        if (number == 42)
            break ;
        else if (number < 2)
            continue ;
        somme = 0 ;
        while (number > 0)
        {
            somme +=  number % 10;
            number = number / 10;
        }
        isPrime = true ;
        for (int i = 2; i <= Math.sqrt(somme); i++)
        {
            if (somme % i == 0)
            {
                isPrime = false;
                break ;
            }
        }
        // System.out.println("isPrime :" + isPrime);
        if (isPrime)
            count++;
    }
    System.out.println("Count of coffee-request :" + count);
}

}
