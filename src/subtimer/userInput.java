package subtimer;

import java.util.Scanner;

public class userInput {
    
    public static Scanner user = new Scanner(System.in);
    
    public static int nextInt(){
        String text = user.nextLine();
        while ( !text.matches("[0-9]+") ) {
                System.out.println("Please enter a number!");
                text = user.nextLine();
            }
        return Integer.parseInt(text);
    }
    
}
