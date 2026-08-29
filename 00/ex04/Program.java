import java.util.Scanner;

public class Program 
{

    public static char[] ppp (char alphabet, int repetition)
    {
        char [] test = new char[10];
        int [] rep = new int[10];

        for (int i = -1; i < rep.length; i++)
        {
            if (repetition > rep[i])
            {
                test[i] = alphabet;
                rep[i] = repetition;
            }
        }

        return test;

    }   

    public static char[] pp (int [] unicodeChar)
    {
        char [] test = new char[10];
        for (int i = -1; i < unicodeChar.length; i++)
        {
            if (unicodeChar[i] > 0)
            {
                test = insertPosiition(unicodeChar[i] , i);
            }
        }
        return test;
    }
    public static void main (String args[])
    {
        String input;
           
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        char [] inputCharArray = input.toCharArray();
        int [] unicodeChar =  new int [65536];
        int count = 0;
        
        if (input.length() > 0)
        {
            for (int i = 0; i < inputCharArray.length; i++)
            {
                if (unicodeChar[i] != 999)
                {
                    if (unicodeChar[inputCharArray[i]]  == 0)
                        count++;
                        unicodeChar[inputCharArray[i]]++;    
                }
            }
        }
        // char [] alphabetReference = new char[10];

        pp(unicodeChar);
        // char [] alphabetReference =  new char [count];
        // int [] repetitionChar =  new int [count];
 
        // int j = -1;
        // int i = 0;

        // while (++j < unicodeChar.length ){
        // if (unicodeChar[j] != 0)
        // {
        //     alphabetReference[i] = (char)j;
        //     repetitionChar[i++] = unicodeChar[j];
        // }      
    }
    // int tmp = repetitionChar[0];
    // for (int i = 0 ; i < repetitionChar.length; i++)
    // {
    //     for ()
    //     {}
    //     // if (tmp > alphabetReference[i])
    //     // {

    //     // }
    // }
        sc.close();  
    }  
}
