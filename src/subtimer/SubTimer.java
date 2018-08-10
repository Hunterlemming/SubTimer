package subtimer;

public class SubTimer {
    
    public static void main(String[] args) {
        SubTimer ST = new SubTimer();
        Menu menu = new Menu();
        System.out.println("Please enter the file format!");
        menu.showFormatOptions();
        menu.execute(userInput.nextInt());
    }
}
