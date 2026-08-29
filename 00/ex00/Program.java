public  class Program
{
    public static void main(String[] args)
    {
        int nombre = 479598;
        int sum = (nombre % 10) + ((nombre / 10) % 10) + ((nombre / 100) % 10) + ((nombre / 1000) % 10) + ((nombre / 10000) % 10) + ((nombre / 100000) % 10);
        System.out.println(sum);
    }
}