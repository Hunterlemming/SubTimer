package subtimer;

import java.util.ArrayList;
import java.time.LocalTime;

public class SRT {
    
    private int id;
    private LocalTime startTime;
    private LocalTime endTime;
    private ArrayList<String> rows;
    
    public void makeSRT(int _id, String _duration){
        id=_id;
        setStartTime(_duration.split(" --> ")[0]);
        setEndTime(_duration.split(" --> ")[1]);
    }
    
    private void setStartTime(String time){
        int hour=Integer.parseInt(time.split(":")[0]);
        int min=Integer.parseInt(time.split(":")[1]);
        int sec=Integer.parseInt((time.split(":")[2]).split(",")[0]);
        int nanSec=Integer.parseInt((time.split(":")[2]).split(",")[1]);
        startTime=LocalTime.of(hour, min, sec, nanSec);
    }
    
    private void setEndTime(String time){
        int hour=Integer.parseInt(time.split(":")[0]);
        int min=Integer.parseInt(time.split(":")[1]);
        int sec=Integer.parseInt((time.split(":")[2]).split(",")[0]);
        int nanSec=Integer.parseInt((time.split(":")[2]).split(",")[1]);
        endTime=LocalTime.of(hour, min, sec, nanSec);
    }
    
    public void addRow(String _row){
        getRows().add(_row);
    }
    
    protected void modifyTime(){
        System.out.println("-------------------------------------");
        System.out.println("How much do you wish to modify the existing time by? (hh:mm:ss:nn)");
        String modTime=userInput.nextLine();
        System.out.println("-------------------------------------");
        
        int hour=Integer.parseInt(modTime.split(":")[0]);
        int min=Integer.parseInt(modTime.split(":")[1]);
        int sec=Integer.parseInt(modTime.split(":")[2]);
        int nanSec=Integer.parseInt(modTime.split(":")[3]); 
        
        System.out.println("-------------------------------------");
        System.out.println("Would you like to add or substract this amount? (+/-)");
        switch(userInput.nextLine()){
            case "+":
                startTime.plusHours(hour);
                startTime.plusMinutes(min);
                startTime.plusSeconds(sec);
                startTime.plusNanos(nanSec);
                endTime.plusHours(hour);
                endTime.plusMinutes(min);
                endTime.plusSeconds(sec);
                endTime.plusNanos(nanSec);
                break;
            case "-":
                startTime.minusHours(hour);
                startTime.minusMinutes(min);
                startTime.minusSeconds(sec);
                startTime.minusNanos(nanSec);
                endTime.minusHours(hour);
                endTime.minusMinutes(min);
                endTime.minusSeconds(sec);
                endTime.minusNanos(nanSec);
                break;
            default:
                break;
        }
        System.out.println("-------------------------------------");
        
    }
    
    public int getId() {
        return id;
    }
    
    public LocalTime getStartTime() {
        return startTime;
    }
    
    public LocalTime getEndTime() {
        return endTime;
    }
    
    public ArrayList<String> getRows() {
        return rows;
    }
    
}
