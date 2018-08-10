package subtimer;

import java.util.ArrayList;

public class SRT {
    
    private final int id;
    private final Time startTime;
    private final Time endTime;
    private ArrayList<String> rows;
    
    public SRT(int _id, String _duration){
        id=_id;
        startTime=new Time(_duration.split(" --> ")[0]);
        endTime=new Time(_duration.split(" --> ")[1]);
    }
    
    public void addRow(String _row){
        getRows().add(_row);
    }
    
    public int getId() {
        return id;
    }
    
    public Time getStartTime() {
        return startTime;
    }
    
    public Time getEndTime() {
        return endTime;
    }
    
    public ArrayList<String> getRows() {
        return rows;
    }
    
}
