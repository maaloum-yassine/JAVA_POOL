// public class Program
// {
//     public static void main(String[] args)
//     {
//         System.out.println("Byte size in bits: " + Byte.SIZE);
//         System.out.println("Short size in bits: " + Short.SIZE);
//         System.out.println("Long size in bits: " + Long.SIZE);
//         System.out.println("Float size in bits: " + Float.SIZE);
//         System.out.println("Double size in bits: " + Double.SIZE);        
//         System.out.println("Integer size in bits: " + Integer.SIZE);
//         System.out.println("Character size in bits: " + Character.SIZE);
//         System.out.println("Boolean size in Java: JVM dependent, usually 1 byte");
//     }
// }


public class Program {
    public static void main(String [] args) {
        int number = 479598;
        int result = 0;
        while (number > 0)
        {
            result +=  (number % 10);
            number = number / 10;
        }
        System.out.println(result);
    }
}