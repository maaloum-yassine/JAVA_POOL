import java.util.Scanner;

public class Program 
{
    private static final String[] days = {"MO", "TU", "WE", "TH", "FR", "SA", "SU"};

    private static boolean fillNames(Scanner sc, String[] names)
    {
        String input;
        
        for (int i = 0; i < 10 ; i++)
        {
            input = sc.nextLine();
            if (input.equals("."))
                return true;
            if (input.length() == 0 || input.length() > 10)
                return false;
            else
            {
                Scanner scInput = new Scanner(input);
                scInput.next();
                if (scInput.hasNext())
                    {
                        scInput.close();
                        return false;
                    }
                    scInput.close();
                    names[i] = input;
                }
            }     
            return true;
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
    
    private static boolean checkDateSceance(Scanner sc, String[] classes)
    {
        String input;
        String  time;
        String day;
        
        for (int i = 0; i < 10; i++)
        {
            input = sc.nextLine();
            if (input.equals("."))
                return true;
            if (input.length() != 4)
                return false;

            Scanner scInput = new Scanner(input);

            time = scInput.next();
            if (scInput.hasNext())
                day = scInput.next();
            else
            {
                scInput.close();
                return false;
            }
            scInput.close();
            if (time.length() != 1)
                return false;
            else if (time.charAt(0) < '1' || time.charAt(0) > '6')
                return false;

            boolean checkDay = false;
            for (String strday : days)
            {
                if (strday.equals(day))
                {
                    checkDay = true;
                    if (checkDuplicatedClasses(classes, input))
                    {
                        classes[i] = input;
                        break ;
                    }
                    else
                    {
                        System.out.println("Your input is already duplicated -______>> "+ input + " [^_^]!");
                        i--;
                    }    
                }
            }
            if (!checkDay)
                return false;
        }
        return true;
    }
        

   
    private static String[] classOrder(String classes[])
    {
        String []  orderClasses = new String[10];
        int count = 0; 
        for (int j = 0 ; j < days.length; j++)
        {
            int i = 0;
            while (i <  classes.length && classes[i] != null )
            {
                Scanner scanner = new Scanner(classes[i]);
                String time = scanner.next();
                String day = scanner.next();
                if (days[j].equals(day))
                {
                    orderClasses[count++] = classes[i];
                }
                i++;
            }
        }
        for (int i = 0; i < count - 1; i++)
        {
            for (int j = 0; j < count - 1 - i; j++)
            {
                Scanner sc1 = new Scanner(orderClasses[j]);
                Scanner sc2 = new Scanner(orderClasses[j + 1]);
                String time1 = sc1.next();
                String time2 = sc2.next();                                           
                String day1 = sc1.next();
                String day2 = sc2.next();
                
                if (day1.equals(day2))
                {
                    if (time1.charAt(0) > time2.charAt(0))
                    {
                        String temp = orderClasses[j];
                        orderClasses[j] = orderClasses[j + 1];
                        orderClasses[j + 1] = temp;
                    }
                }
            }
        }
        // for (int i = 0 ; i < orderClasses.length ; i++)
        // {
        //      System.out.println("=============?>>>>" + orderClasses[i]);
        // }
        return orderClasses;
    }

      

    private static boolean checkName(String[] names, String name)
    {
        int i = 0;
        while (names[i] != null &&  i < names.length )
        {
            if (names[i].equals(name))
                return true;
            i++;
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
        while (classes[i] != null && i < classes.length)
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

    private static int findProgram(String[] programForAll, String input) {

    Scanner scInput = new Scanner(input);

    String name = scInput.next();
    String day = scInput.next();
    String time = scInput.next();

    for (int i = 0; i < programForAll.length; i++) {

        if (programForAll[i] == null) {
            scInput.close();
            return -1;
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
            return i;
        }

        scProgram.close();
    }
        scInput.close();
        return -1;
    }
    

    private static void displayProgram(String[] programForAll, String[] names, String[] classes)
    {
        
        int day = 1;
        int continueDay;
        int count = 0;
        for ( ; day <= 30; day++)
        {
            int  i = 0;
            while (classes[i] != null && i < classes.length)
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
            
    private static boolean presenceStudent(Scanner sc, String[] names, String[] classes) {
        String[] programForAll = new String[168];
        String  name;
        String  day;
        String  hour;
        String  presence;
        String  input;
        int i = 0;

        while (!(input = sc.nextLine()).equals(".")) {
            Scanner line = new Scanner(input);
            if (!line.hasNext())
            {
                System.out.println("line");
                return false;
            }
            name = line.next();
            if (!line.hasNext())
            {
                System.out.println("name");
                return false;
            }
            day = line.next();
            if (!line.hasNext())
            {
                System.out.println("day");
                return false;
            }
            hour = line.next();
            if (!line.hasNext())
            {
                System.out.println("hour");
                return false;
            }
            presence = line.next();
            if (line.hasNext())
            {
                System.out.println("presence");
                return false;
            }
            if (!checkName(names, name))
            {
                System.out.println("checkName");
                return false;
            }
            if (!checkDate(day, hour))
            {
                System.out.println("checkDate");
                return false;
            }
            if (!checkPresence(presence))
            {
                System.out.println("checkPresence");
                return false;
            }
            if (!checkSceance(classes, day, hour))
            {
                System.out.println("checkSceance");
                return false;
            }
            int index  = findProgram(programForAll, input);
            if (index == -1)
              programForAll[i++] = input;
            else 
                programForAll[index] = input;
            line.close();
        }
        displayProgram(programForAll, names, classes);
        return true;
    }
        public static void main(String[] args)
        {
            
            Scanner sc = new Scanner(System.in);
            String[] names = new String[10];
            String[] classes = new String[10];
            
            
            if (fillNames(sc, names) && names[0] != null)
                {
                    if (checkDateSceance(sc, classes) && classes[0] != null)
                        {

                           classes =  classOrder(classes);
                           if (presenceStudent(sc, names, classes))
                            {
                                // System.out.println("Goood");
                            }
                            else
                                System.out.println("false");
                        }
                        else
                            System.err.print("Day of week between 1 pm and 6 pm");
                    }
                    else
                        System.err.print("Maximum length of a student’s name is 10 (no empty - no spaces) ");
                    
                    
                    
                    
                    
            }
        }
    

        // String[] days = {"MO", "TU", "WE", "TH", "FR", "SA", "SU"};

        // int firstDayOfWeek = 1; // 1er septembre = mardi
        // int daysInMonth = 30;

        // for (int day = 1; day <= daysInMonth; day++) {
        
        //     int dayOfWeek = (firstDayOfWeek + (day - 1)) % 7;
        
        //     String currentDay = days[dayOfWeek];
        
        //     System.out.println(day + " septembre = " + currentDay);
        // }
        //     for (int i = 0; i < numbers.length - 1; i++)
            // {
                //     for (int j = 0; j < numbers.length - 1 - i; j++)
                    //     {
                        //         if (numbers[j] > numbers[j + 1])
            //         {
            //             int temp = numbers[j];
            //             numbers[j] = numbers[j + 1];
            //             numbers[j + 1] = temp;
            //         }
            //     }
            // }
            
            
            //    displayProgram(names, classOrder(classes));
