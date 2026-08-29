import java.util.Scanner;

public class Program 
{

    public static void shutDown(Scanner  sc)
    {
        sc.close();
        System.err.println("IllegalArgument");
        System.exit(-1);
    }


    public static void displayDiagram(int resultNote,int countWeek)
    {
        int i = -1;
        while (++i < countWeek)
        {
            System.out.print("Week "+ (i + 1) + " ");
            int note = resultNote % 10;
            resultNote /= 10; 
            for (int j = 0 ; j < note; j++)
                System.out.print("=");
            System.out.println(">");
        }
    }

    public static int processWeeklyNotes(Scanner  sc)
    {
        int     note = 0;       
        String  inputNote;
        int     minNote = 9;

        inputNote = sc.nextLine();
        if (inputNote.equals("42"))
            return -2;
        Scanner scNotes = new Scanner(inputNote);
        for (int i = 0 ; i < 5 ; i++) 
        {
            if (scNotes.hasNextInt())
            {
                note = scNotes.nextInt();
                if (note < 1 || note > 9)
                {
                    scNotes.close();
                    return -1;
                }
                else if (note < minNote)
                    minNote = note;
            }
            else
            {
                scNotes.close();
                return -1;
            }
        }
        if (scNotes.hasNext())
        {
            scNotes.close();
            return -1;
        }
        scNotes.close();
        return minNote;
    }
    

    public static int coefficient(int note, int NnmWeek)
    {
        for (int i = 1 ; i < NnmWeek; i++)
            note *= 10;
        return note;
    }

    public static void main(String args[])
    {
        Scanner  sc = new Scanner(System.in);
        String input;
        String line;
        int countWeek = 0;
        int resultNote = 0;
        int noteWeek = 0;

        do 
        {
            line = sc.nextLine();
            Scanner scLine = new Scanner(line);
            input = scLine.next();
            if (input.equals("Week"))
            {
                if (scLine.hasNextInt())
                {
                    int number_week  = scLine.nextInt();
                    if (++countWeek == number_week)
                    {
                        scLine.close();
                        noteWeek = processWeeklyNotes(sc);
                        if (noteWeek == -1)
                            shutDown(sc);
                        else if (noteWeek == -2)
                            break ;
                        else
                            resultNote += coefficient(noteWeek, countWeek);
                    }
                    else
                        shutDown(sc);
                }
                else
                    shutDown(sc);
            }
            else if (!input.equals("42"))
                shutDown(sc);
        }
        while((countWeek != 4) && !input.equals("42"));
        displayDiagram(resultNote, countWeek);
        sc.close();
    }

    
}

