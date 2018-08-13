package srt;

import java.util.ArrayList;
import java.time.LocalTime;

public class SRT {

    private final int id;
    private LocalTime startTime;
    private LocalTime endTime;
    private final ArrayList<String> rows = new ArrayList();

    protected SRT(int _id, String _duration) {
        id = _id;
        setStartTime(_duration.split(" --> ")[0]);
        setEndTime(_duration.split(" --> ")[1]);
    }

    private void setStartTime(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        int sec = Integer.parseInt((time.split(":")[2]).split(",")[0]);
        int nanSec = Integer.parseInt((time.split(":")[2]).split(",")[1]);
        startTime = LocalTime.of(hour, min, sec, nanSec);
    }

    private void setEndTime(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        int sec = Integer.parseInt((time.split(":")[2]).split(",")[0]);
        int nanSec = Integer.parseInt((time.split(":")[2]).split(",")[1]);
        endTime = LocalTime.of(hour, min, sec, nanSec);
    }

    protected void addRow(String _row) {
        rows.add(_row);
    }

    protected void modifyTime(String modTime, String direction) {

        long hour = Long.parseLong(modTime.split(":")[0]);
        long min = Long.parseLong(modTime.split(":")[1]);
        long sec = Long.parseLong(modTime.split(":")[2]);
        long nanSec = Long.parseLong(modTime.split(":")[3]);

        switch (direction) {
            case "+":
                startTime = startTime.plusHours(hour);
                startTime = startTime.plusMinutes(min);
                startTime = startTime.plusSeconds(sec);
                startTime = startTime.plusNanos(nanSec);
                endTime = endTime.plusHours(hour);
                endTime = endTime.plusMinutes(min);
                endTime = endTime.plusSeconds(sec);
                endTime = endTime.plusNanos(nanSec);
                break;
            case "-":
                startTime = startTime.plusHours(hour);
                startTime = startTime.plusMinutes(min);
                startTime = startTime.plusSeconds(sec);
                startTime = startTime.plusNanos(nanSec);
                endTime = endTime.plusHours(hour);
                endTime = endTime.plusMinutes(min);
                endTime = endTime.plusSeconds(sec);
                endTime = endTime.plusNanos(nanSec);
                break;
            default:
                break;
        }
    }

    protected int getId() {
        return id;
    }

    protected String getTime() {
        String time = startTime.getHour() + ":" + startTime.getMinute() + ":" + startTime.getSecond() + "," + startTime.getNano()
                + " --> " + endTime.getHour() + ":" + endTime.getMinute() + ":" + endTime.getSecond() + "," + endTime.getNano();
        return time;
    }

    protected ArrayList<String> getRows() {
        return rows;
    }

}
