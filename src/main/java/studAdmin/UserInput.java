package studAdmin;

import java.util.Scanner;

public class UserInput {
    public static Scanner in = new Scanner(System.in);
    public static Scanner intIn = new Scanner(System.in);
    public static int intIn(){ return intIn.nextInt(); }
    public static String strIn() { return in.nextLine();}
}

