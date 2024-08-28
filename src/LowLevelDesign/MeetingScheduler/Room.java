package LowLevelDesign.MeetingScheduler;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Room{
    int id;
    int capacity;
    boolean booked;
    List<Meeting> meetingList;

    public Room(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.meetingList = new ArrayList<>();
    }

    public boolean isBookedDuring(LocalTime startTime, LocalTime endTime) {
        for (Meeting meeting : meetingList) {
            if (meeting.isOverLapping(startTime, endTime)) {
                return true;
            }
        }
        return false;
    }
    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
