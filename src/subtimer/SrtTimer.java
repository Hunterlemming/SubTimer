package subtimer;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class SrtTimer extends SRT{
    
    private File file;
    private ArrayList<SRT> content;
    
    public static void start(){
        SrtTimer timer = new SrtTimer();
        timer.load();
        timer.modify();
        
    }
    
    private void load(){
        System.out.println("-------------------------------------");
        System.out.println("Enter the file name! (with extension)");
        file = new File(userInput.nextLine());
        System.out.println("-------------------------------------");
        if (file.exists() && !file.isDirectory()){
            try{
                Scanner sc = new Scanner(file);
                while(sc.hasNextLine()){
                    int id = Integer.parseInt(sc.nextLine());
                    String duration= sc.nextLine();
                    SRT temp = new SRT();
                    temp.makeSRT(id, duration);
                    String row;
                    do{
                        row=sc.nextLine();
                        temp.addRow(row);
                    }while (!row.equals(""));
                    content.add(temp);
                }
            }catch (Exception e){
                System.out.println("-------------------------------------");
                System.out.println("Error occured while handling the file!");
                System.out.println("-------------------------------------");
            }
        } else {
            System.out.println("-------------------------------------");
            System.out.println("File not found.");
            System.out.println("-------------------------------------");
        }
        
    }
    
    private void modify(){
        System.out.println("-------------------------------------");
        System.out.println("From which ID should the program modify?");
        int startID = userInput.nextInt()-1;
        System.out.println("-------------------------------------");
        
        System.out.println("-------------------------------------");
        System.out.println("Which is the last ID the program to modify? (last: " + content.size() + ")");
        int endID = userInput.nextInt()-1;
        System.out.println("-------------------------------------");
        
        for (int i=startID; i<endID; i++) {
            content.get(i).modifyTime();
        }
    }
    
    private void save(){
        
    }
    
}