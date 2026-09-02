import java.util.Scanner;

public class Program 
{


    public static void dispalyFrequencyAnalysis(int[] repAlphabet , char[] arrangingAlpha, int length)
    {
        int[] heights = new int[length];
        
        for (int  i = 0; i < length ; i++) {
            heights[i] = (repAlphabet[i] * 10) / repAlphabet[0];
        }
        
       for (int level = 10; level >= 0; level--)
        {
            for (int i = 0; i < length; i++) {
                if (heights[i] == level )
                    System.out.print(repAlphabet[i] + "\t");
                else if (heights[i] >= level)
                    System.out.print("# \t");
                else 
                    System.out.print("  \t");
            }
            System.out.println();
        }
        for (char c : arrangingAlpha) {
                System.out.print(c + "  \t");
        }
    }

    public static int returnIndex(int repUniCode, int[] repAlphabet, char[] arrangingAlpha)
    {
        int index;
        for (index = 0; index < repAlphabet.length; index++)
        {
            if (repUniCode >= repAlphabet[index])
            {
                for (int j = repAlphabet.length - 1; j > index; j--)
                {
                    repAlphabet[j] = repAlphabet[j - 1];
                    arrangingAlpha[j] = arrangingAlpha[j - 1];
                }
                break;
            }
        }
        return index;
    }

    public static void handlArrays (int [] unicodeChar)
    {
        int correctIndex;
        char [] arrangingAlpha = new char[10];
        int [] repAlphabet = new int[10];
        int length = 0;

        for (int i = 0; i < unicodeChar.length; i++)
        {
            if (unicodeChar[i] > 0)
            {
                correctIndex = returnIndex(unicodeChar[i], repAlphabet, arrangingAlpha);
                if (correctIndex < repAlphabet.length)
                {
                    repAlphabet[correctIndex] = unicodeChar[i];
                    arrangingAlpha[correctIndex] = (char)i;
                }
            }
        }

        for(int i = 0 ; i < 10 ; i++)
        {
            if (repAlphabet[i] != 0)
                length++;
        }
        dispalyFrequencyAnalysis(repAlphabet, arrangingAlpha, length);
    }



    public static void main (String args[])
    {
        String input;
           
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        // input ="das;kdjalsdhd djaskldjalsjkdieq osdjas diqweiwke opauq9eqw1231290312738127jb,d k;dl *d/as*/dasdas4d65";
        // input = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDWEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOO42";
        char [] inputCharArray = input.toCharArray();
        int [] unicodeChar =  new int [65536];
        
        if (input.length() > 0)
        {
            for (int i = 0; i < inputCharArray.length; i++)
            {
                // if (unicodeChar[i] != 999)
                    unicodeChar[inputCharArray[i]]++;    
            }
        }
        handlArrays(unicodeChar);
        sc.close();
    }
}