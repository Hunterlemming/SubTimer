package subtimer;

import java.util.Scanner;

public class userInput {
    
    private static final Scanner user = new Scanner(System.in);
    
    public static int nextInt(){
        String text = user.nextLine();
        while ( !text.matches("[0-9]+") ) {
                System.out.println("Please enter a valid number!");
                text = user.nextLine();
            }
        return Integer.parseInt(text);
    }
    
    public static String nextLine(){
        return user.nextLine();
    }
    
}
