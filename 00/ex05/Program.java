import java.util.Scanner;

public class Program 
{

    private static final String[] days = {"MO", "TU", "WE", "TH", "FR", "SA", "SU"};
        private static void displayClasses(String[] classes)
    {
        
        int day = 1;
        int continueDay;
        int count = 0;
        for ( ; day <= 30; day++)
        {
            int  i = 0;
            while (i < classes.length && classes[i] != null )
            {
                Scanner scannerDay = new Scanner(classes[i]);
                String time = scannerDay.next();
                String dayS = scannerDay.next();
                int dayOfWeek = (1 + (day - 1)) % 7;
                String currentDay = days[dayOfWeek];
                scannerDay.close();
                if (currentDay.equals(dayS))
                { 
                    System.out.print("\t" + time+":00 " + currentDay + " " +  day + "|" );
                    count++;
                    break ;
                }
                i++;
            }
        }
        System.out.println();
        
    }        


    private static void  displayStudents(String[] programForAll, String[] names, String[] classes)
    {   
        int day;
        int j = 0;
        int n = 0;
        boolean checkIsP = false;
        while (names[j] != null && j < names.length)
        {
            System.out.print(names[j]);
            for (day = 1 ; day <= 30; day++)
            {
                int  x = 0;
                while (classes[x] != null && x < classes.length)
                {
                    Scanner scannerDay = new Scanner(classes[x]);
                    String time = scannerDay.next();
                    String dayS = scannerDay.next();
                    int dayOfWeek = (1 + (day - 1)) % 7;
                    String currentDay = days[dayOfWeek];
                    if (currentDay.equals(dayS))
                    { 
                        int  i = 0;
                        while (programForAll[i] != null && i < programForAll.length)
                        {
                            Scanner scannerProgram = new Scanner(programForAll[i]);
                            String  nameP = scannerProgram.next();
                            String  secanceP = scannerProgram.next();
                            int     dayP = scannerProgram.nextInt();
                            String currentDayP = days[(1 + (dayP - 1)) % 7];
                            String  presenceP = scannerProgram.next();
                            // System.out.println("presenceP " +  presenceP);
                            scannerProgram.close();
                            if (names[j].equals(nameP) && dayP == day  && secanceP.equals(time))
                            {
                                checkIsP = true;
                                if (presenceP.equals("HERE"))
                                    System.out.print("\t        1|");
                                else
                                    System.out.print("\t       -1|");
                                break ;
                            }
                            i++;
                        }
                        if (!checkIsP  )
                            System.out.print("\t         |");
                        else
                            checkIsP = false;
                        break ;
                    }
                    x++;
                }
            }
            System.out.println();
            j++;
        }
    }

    private static byte fillNames(Scanner sc, String[] names)
    {
        String input;
        int count = 0;
        
        while ((!((input = sc.nextLine()).equals("."))) && count != 9)
        {   
            if (input.length() == 0 || input.length() > 10)
                return 1;
            else
            {
                Scanner scInput = new Scanner(input);
                scInput.next();
                if (scInput.hasNext())
                    {
                        scInput.close();
                        return 2;
                    }
                    scInput.close();
                    names[count++] = input;
            }
        }
        if (count == 0)
            return 3;
        return 4;
    }   


  private static boolean checkDuplicatedClasses(String[] classes, String input)
    {
        int i = 0;

        while(classes[i] != null && i < classes.length)
        {
            if (classes[i].equals(input))
                return false;
            i++;
        }
        return true;
    }
    

    private static boolean checkTime(int time)
    {
        if (time < 1 || time > 6)
            return false;
        return  true;
    }

    private static boolean checkDay(String[] classes, String input ,String day, int[] count)
    {
        boolean checkDay = false;

        for (String strday : days)
        {
            if (strday.equals(day))
            {
                checkDay = true;
                if (checkDuplicatedClasses(classes, input))
                {
                    classes[count[0]++] = input;
                    break ;
                }
                else
                {
                    System.out.println("Your input is already duplicated -______>> "+ input + " [^_^]!");
                    count[0]--;
                }    
            }
        }
        return checkDay;
    }

    private static byte checkDateSceance(Scanner sc, String[] classes)
    {
        String input;
        int  time;
        String day;
        int []count = {0};
        while ((!((input = sc.nextLine()).equals("."))) && count[0] != 9)
        {   
            Scanner scInput = new Scanner(input);
                if (scInput.hasNextInt())
                    time = scInput.nextInt();  
                else
                {
                    scInput.close();
                    return 1;
                }
                if (scInput.hasNext())
                    day = scInput.next();
                else
                {
                    scInput.close();
                    return 2;
                }
                if (scInput.hasNext())
                    return 3;
                scInput.close();
                if (!checkTime(time))
                    return 4;
                if (!checkDay(classes, input, day, count))
                    return 5;
        }
        return 6;
    }
        

   
    private static String[] classOrder(String[] classes)    
    {
        String[] orderClasses = new String[10];
        int count = 0;

        // Order by day
        for (int j = 0; j < days.length; j++)
        {
            for (int i = 0; i < classes.length && classes[i] != null; i++)
            {
                Scanner sc = new Scanner(classes[i]);
                String time = sc.next();
                String day = sc.next();
                sc.close();

                if (days[j].equals(day))
                    orderClasses[count++] = classes[i];
            }
        }

        // Order by time
        for (int i = 0; i < count - 1; i++)
        {
            for (int j = 0; j < count - 1 - i; j++)
            {
                Scanner sc1 = new Scanner(orderClasses[j]);
                Scanner sc2 = new Scanner(orderClasses[j + 1]);

                int time1 = sc1.nextInt();
                int time2 = sc2.nextInt();

                sc1.close();
                sc2.close();

                if (time1 > time2)
                {
                    String temp = orderClasses[j];
                    orderClasses[j] = orderClasses[j + 1];
                    orderClasses[j + 1] = temp;
                }
            }
        }
        return orderClasses;
    }

      

    private static boolean checkName(String[] names, String name)
    {
        int i = -1;
        while (++i < names.length && names[i] != null)
        {
            if (names[i].equals(name))
                return true;
        } 
        return false;
    }


    private static boolean checkDate(String day, String hour)
    {
        String date = day + " " + hour;
        Scanner foramt = new Scanner(date);
        
        if (foramt.hasNextInt())
        {
            int numberHour = foramt.nextInt();
            if (!(numberHour >= 1 && numberHour <= 6))
            {
                foramt.close();
                return false;
            }
            if (foramt.hasNextInt())
            {
                int numberDay = foramt.nextInt();
                if (!(numberDay >= 1 && numberDay <= 30))
                {
                    foramt.close();
                    return false;
                }
            }
            else
            {
                foramt.close();
                return false;
            }
        }        
        else
        {
            foramt.close();
            return false;
        }
        foramt.close();
        return true;
    }


    private static boolean checkPresence(String presence)
    {
        if (presence.equals("NOT_HERE") || presence.equals("HERE"))
            return true;
        return false;
    }

    private static String retournDay(int daySceance)
    {
        int dayOfWeek = (1 + (daySceance - 1)) % 7;
        return(days[dayOfWeek]);

    }

    private static boolean checkSceance(String[] classes, String day, String hour)
    {
        int i = 0;

        String date = day + " " + hour;
        Scanner foramt = new Scanner(date);
        String numberHour = foramt.next();
        int numberDay = foramt.nextInt();
        foramt.close();

        String dayOfSeance = retournDay(numberDay);
        String inputSceance = numberHour + " " + dayOfSeance;
        while (classes[i] != null  && i < classes.length )
        {
           if (inputSceance.equals(classes[i]))
            {
                foramt.close();
                return true;
            }
            i++;
        }
        foramt.close();
        return false;
    }




        private static boolean findProgram(String[] programForAll, String input)
    {

        Scanner scInput = new Scanner(input);

        String name = scInput.next();
        String day = scInput.next();
        String time = scInput.next();

        for (int i = 0; i < programForAll.length; i++)
        {
            if (programForAll[i] == null)
            {
                scInput.close();
                return true;
            }

            Scanner scProgram = new Scanner(programForAll[i]);

            String pName = scProgram.next();
            String pDay = scProgram.next();
            String pTime = scProgram.next();

            if (name.equals(pName)
                    && day.equals(pDay)
                    && time.equals(pTime)) {

                scProgram.close();
                scInput.close();
                return false;
            }
            scProgram.close();
        }
            scInput.close();
        return true;
    }

    
    private static byte checkInLine (String[] names, String[] classes, String input)
    {
        String  name;
        String  day;
        String  hour;
        String  presence;
        byte    res = 0;

        Scanner line = new Scanner(input);
        if (!line.hasNext())
            res = 1;
        name = line.next();
        if (!line.hasNext())
            res = 1;
        day = line.next();
        if (!line.hasNext())
            res = 1;
        hour = line.next();
        if (!line.hasNext())
            res = 1;
        presence = line.next();
        if (line.hasNext())
            res = 1;
        if (!checkName(names, name))
            res = 2;
        if (!checkDate(day, hour))
            res = 3;
        if (!checkPresence(presence))
            res = 4;
        if (!checkSceance(classes, day, hour))
            res = 5;

        line.close();
        if (res == 0)
            return 6;
        return res;
    }

    private static byte presenceStudent(Scanner sc, String[] names, String[] classes)
    {
        String[] programForAll = new String[168];
        String  input;
        byte    check;
        int     i = 0;
        
        while (!(input = sc.nextLine()).equals(".") && i != 167)
        {
            Scanner line = new Scanner(input);
            check = checkInLine(names, classes,  input);

            if (check != 6)
                return check;

            boolean checkIt  = findProgram(programForAll, input);
            if (checkIt)
              programForAll[i++] = input;
            else 
                System.out.println("Your input is already duplicated -______>> "+ input + " [^_^]!");
            line.close();
        }
        displayClasses(classes);
        displayStudents(programForAll, names, classes);
        return 6;
    }


    public static void main(String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        String[] names = new String[10];
        String[] classes = new String[10];
        
        byte StepOne = fillNames(sc, names);
        
        if (StepOne == 1)
            System.err.println("Maximum length of a stu-dent’s name is 10 (no spaces) [^_^]!");
        else if (StepOne == 2)
            System.err.println("The student's name must not contain spaces. [^_^]!");
        else if (StepOne == 3)
            System.out.println("See You [^_^]!");
        else
        {
            byte stepTwo = checkDateSceance(sc, classes);
            if (stepTwo == 1)
                System.err.println("Error -> Enter the time (1 pm to 6 pm) and the day (MO, TU, WE, TH, FR, SA, SU). [^_^]!");
            else if (stepTwo == 2)
                System.err.println("Error -> Enter a valid day (MO, TU, WE, TH, FR, SA, SU). [^_^]!");
            else if (stepTwo == 3)
                System.err.println("Error -> Enter only the day and the time. [^_^]!");
            else if (stepTwo == 4)
                System.err.println("Error -> Enter a valid time (1 pm to 6 pm). [^_^]!");
            else if (stepTwo == 5)
                System.err.println("Error -> Enter the day in the format MO, TU, WE, TH, FR, SA, SU. [^_^]!");
            else
            {
                classes =  classOrder(classes);
                byte stepThree = presenceStudent(sc, names, classes);
                if (stepThree == 1)
                    System.err.println("Error -> Enter the valid input for student 'Name' 'Seance' 'day' 'HERE, NOT_HERE.'  [^_^]!");    
                else if (stepThree == 2)
                    System.err.println("Error -> Enter a valid Name. [^_^]!");    
                else if (stepThree == 3)
                    System.err.println("Error -> Enter a valid Date . [^_^]!");    
                else if (stepThree == 4)
                    System.err.println("Error -> Enter a valid info for student 'HERE or NOT_HERE.  [^_^]!");    
                else if (stepThree == 5)
                    System.err.println("Error -> Enter a valid Sceance . [^_^]!");  
            }
        }
    }
}