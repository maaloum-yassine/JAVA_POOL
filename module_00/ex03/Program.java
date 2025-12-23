import java.util.Scanner;


public class Program
{
    public static final String FINISH = "42";
    public static final String WEEK = "Week ";
    
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String input;
        int count =  1;
        int result = 0;


        while (true)
        {
            input = sc.nextLine();
            if (input.equals("42") || count == 18)
            {
                count --;   
                break ;
            }
            if (!input.equals(WEEK + (count)))
                System.exit(putIllegalArgument());
            result = result *  10 + checkMinNote();
            count ++;
        }
        creatGraph(result , count);
    }

    public static int putIllegalArgument()
    {
        System.out.println("IllegalArgument");
        return (-1);
    }

    public static int checkMinNote ()
    {
        Scanner sc = new Scanner(System.in);

        int min_note = 0;
        for (int i = 0 ; i < 5 ; i++)
        {
            int note = sc.nextInt();
            if (note < 1 || note > 9 && (note != 42))
            {
                System.out.println("The note must be between 1 and 9");
                i--;
            }
            else
            {
                if (i == 0)
                    min_note = note;
                else if (note < min_note)
                    min_note = note;
            }
        }
        return (min_note);
    }

    public static int claclResult(int note)
    {
        return note * 10; 
    }


    
    public static void creatGraph(int result , int count)
    {
        int div;
        int  i;

        i = 0;
        div = calcDiv(count);
        while (count  > 0)
        {
            count --;
            while (div > 0)
            {
                int digit = result / div;
                dispaly(++digit, ++i);
                result = result % div;
                div /=10;
            }   
        }
    }



    public static void dispaly(int digit, int numWeek)
    {
        System.out.print("Week "+ numWeek + " ");
        while(--digit > 0)
            System.out.print("=");
        System.out.println(">");
    }



    public static int calcDiv(int count)
    {
        int div;
    
        div = 1;
        for (int i = 1; i < count; i++)
            div *= 10;
        return div;
    }
}

