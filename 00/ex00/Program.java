public  class Program
{
    public static void main(String[] args)
    {
        int nombre = 479598;
        int sum = 0;    

        while (nombre > 0)
        {
            sum += (nombre % 10);
            nombre /= 10 ;
        }
        System.out.println(sum);
    }
}