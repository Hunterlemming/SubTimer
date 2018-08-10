package subtimer;

public class SubTimer {
    
    public static void main(String[] args) {
        SubTimer ST = new SubTimer();
        System.out.println("Please enter the file format!");
        Menu.showFormatOptions();
        Menu.chooseFormat(userInput.nextInt());
    }
}
