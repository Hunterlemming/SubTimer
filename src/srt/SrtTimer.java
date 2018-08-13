package srt;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import subtimer.userInput;

public class SrtTimer {

    private File file;
    private final ArrayList<SRT> content = new ArrayList();

    public static void run() {
        SrtTimer timer = new SrtTimer();
        if (timer.load()) {
            timer.modify();
            //timer.save();
        }
    }

    private boolean load() {
        boolean successfulLoad = false;
        System.out.println("-------------------------------------");
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
                sc.close();
            }catch (Exception e){
                System.out.println("-------------------------------------");
                System.out.println("Error occured while loading the file!");
            }
        } else {
            System.out.println("-------------------------------------");
            System.out.println("File not found.");
        }
        return successfulLoad;
    }

    private void modify() {
        System.out.println("-------------------------------------");
        System.out.println("From which ID should the program modify?");
        int startID = userInput.nextInt() - 1;

        System.out.println("-------------------------------------");
        System.out.println("Which is the last ID the program to modify? (last: " + content.size() + ")");
        int endID = userInput.nextInt() - 1;

        for (int i = startID; i < endID; i++) {
            content.get(i).modifyTime();
        }
    }

    private void save() {
        try {
            PrintWriter writer = new PrintWriter(file.getName(), "UTF-8");
            for (int i = 0; i < content.size(); i++) {
                writer.println(content.get(i).getId());
                writer.println(content.get(i).getTime());
                for (int j = 0; j < content.get(i).getRows().size(); j++) {
                    writer.println(content.get(i).getRows().get(i));
                }
            }
            System.out.println("-------------------------------------");
            System.out.println("Your new .srt is ready!");
            writer.close();
        } catch (Exception e) {
            System.out.println("-------------------------------------");
            System.out.println("Error occured while saving the file!");
        }
    }

}
