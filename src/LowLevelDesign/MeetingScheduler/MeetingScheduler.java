package LowLevelDesign.MeetingScheduler;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MeetingScheduler {
    List<Room> roomList=new ArrayList<>();
    List<Employee> employeeList = new ArrayList<>();
    MeetingScheduler(List<Room> roomList, List<Employee> employeeList){
        this.employeeList=employeeList;
        this.roomList=roomList;
    }
    public void book(LocalTime startTime,LocalTime endTime,List<Room> roomList,List<Employee> employeeList,int capacity){
        for(Room room:roomList) {
            if (!room.isBookedDuring(startTime,endTime) && room.capacity>=capacity) {
                room.setBooked(true);
                room.meetingList.add(new Meeting(startTime,endTime));
                System.out.println("booked successfully for room :" + room.id);
                notifyEmployees(employeeList,room,startTime,endTime);
                return;
            }
        }
    }
    public void notifyEmployees(List<Employee> bookedEmployees, Room room, LocalTime startTime, LocalTime endTime){
        for(Employee employee:bookedEmployees){
            System.out.println("Hi "+ employee.getName()+
                    ", you are expected to be present in Room no:"+ room.id+
                    " for a meeting scheduled from "+ startTime.toString()+" to "+ endTime.toString());
        }
    }
}



