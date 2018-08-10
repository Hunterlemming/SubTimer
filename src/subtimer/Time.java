package subtimer;

public class Time {
    private int hour, min, sec, milSec;
    
    public Time(String time){
        hour=Integer.parseInt(time.split(":")[0]);
        min=Integer.parseInt(time.split(":")[1]);
        sec=Integer.parseInt((time.split(":")[2]).split(",")[0]);
        milSec=Integer.parseInt((time.split(":")[2]).split(",")[1]);
    }
    
    public int getHour() {
        return hour;
    }
    
    public void setHour(int hour) {
        this.hour = hour;
    }
    
    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
    
    public int getSec() {
        return sec;
    }
    
    public void setSec(int sec) {
        this.sec = sec;
    }
    
    public int getMilSec() {
        return milSec;
    }
    
    public void setMilSec(int milSec) {
        this.milSec = milSec;
    }
    
}
