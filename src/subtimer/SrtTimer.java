package subtimer;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class SrtTimer {
    
    private File file;
    ArrayList<SRT> content;
    
    public static void start(){
        SrtTimer timer = new SrtTimer();
        timer.load();
    }
    
    public void load(){
        System.out.println("Enter the file name! (with extension)");
        file = new File(userInput.nextLine());
        if (file.exists() && !file.isDirectory()){
            try{
                Scanner sc = new Scanner(file);
                while(sc.hasNextLine()){
                    int id = Integer.parseInt(sc.nextLine());
                    String duration= sc.nextLine();
                    SRT temp = new SRT(id, duration);
                    String row;
                    do{
                        row=sc.nextLine();
                        temp.addRow(row);
                    }while (!row.equals(""));
                    content.add(temp);
                }
            }catch (Exception e){
                System.out.println("Error occured while handling the file!");
            }
        }
        
    }
    
}