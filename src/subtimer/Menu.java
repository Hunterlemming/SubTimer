package subtimer;

public class Menu {
    
    public static void showFormatOptions(){
        System.out.println("-------------------------------------");
        System.out.println("Choose an option from the ones below!");
        System.out.println("1. .srt");
    }
    
    public static void chooseFormat(int procedure){
        switch(procedure){
            case 1:
                SrtTimer.start();
                break;
            default:
                System.out.println("Number \"" + procedure + "\" does not refer to a procedure!");
                break;
        }
    }
    
}
