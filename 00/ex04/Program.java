import java.util.Scanner;

public class Program 
{


    public static void dispalyFrequencyAnalysis(int[] arrangingAlpha, char[] repAlphabet)
    {
        // for (int j = 10 ; j >= Res; j++)
        // {
        //     System.out.print();
        // }
        
        for (int  i = -1; i < 10 ; i++)
        {
            int Res =  (arrangingAlpha[i] * 10) / arrangingAlpha[i];
            if (Res == )
        }
    }

    public static  int returnIndex(int repUniCode, int[] repAlphabet, char [] arrangingAlpha)
    {
        int index = 0;
        for (index = 0; index < repAlphabet.length; index++)
        {
            if (repAlphabet[index] <= repUniCode)
            {
                for (int j = index; j < repAlphabet.length; j++)
                {
                    if (repAlphabet[index] > repAlphabet[j])
                    {
                        int tmp = repAlphabet[j];
                        repAlphabet[j] = repAlphabet[index];
                        repAlphabet[index] =  tmp;

                        char tmpChar = arrangingAlpha[j];
                        arrangingAlpha[j] = arrangingAlpha[index];
                        arrangingAlpha[index] =  tmpChar;
                    }
                }
                break ;
            }
        }
        return index;
    }

    public static void handlArrays (int [] unicodeChar)
    {
            int correctIndex;
        char [] arrangingAlpha = new char[10];
        int [] repAlphabet = new int[10];


        for (int i = 0; i < unicodeChar.length; i++)
        {
                if (unicodeChar[i] > 0)
            {
                correctIndex = returnIndex(unicodeChar[i], repAlphabet, arrangingAlpha);
                repAlphabet[correctIndex] = unicodeChar[i];
                arrangingAlpha[correctIndex] = (char)i;
            }
        }
        dispalyFrequencyAnalysis(repAlphabet, arrangingAlpha);

        // for (char c : arrangingAlpha) {
            
        //     System.out.println( "Array Char -------------<<<<>>>> " + c);
        // }
    
        // for (int x : repAlphabet) {
            
        //     System.out.println( "repAlphabet  -------------<<<<>>>> " + x);
        // }
        
    }



    public static void main (String args[])
    {
        String input;
           
        Scanner sc = new Scanner(System.in);
        input = "abbbcccccddddd11112222333555111      dddiiooo999999665555www";
        char [] inputCharArray = input.toCharArray();
        int [] unicodeChar =  new int [65536];
        
        if (input.length() > 0)
        {
            for (int i = 0; i < inputCharArray.length; i++)
            {
                if (unicodeChar[i] != 999)
                    unicodeChar[inputCharArray[i]]++;    
            }
        }
        handlArrays(unicodeChar);
        sc.close();
    }
}