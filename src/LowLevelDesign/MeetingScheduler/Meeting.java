package LowLevelDesign.MeetingScheduler;

import java.time.LocalTime;

public class Meeting{
    LocalTime start;
    LocalTime end;

    public Meeting(LocalTime startTime, LocalTime endTime) {
        this.start=startTime;
        this.end=endTime;
    }

    boolean isOverLapping(LocalTime start , LocalTime end){
        return !(this.end.isBefore(start) || this.start.isAfter(end));
    }
}
