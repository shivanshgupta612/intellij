package LowLevelDesign.MeetingScheduler;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create rooms
        Room room1 = new Room(1, 10);
        Room room2 = new Room(2, 5);
        List<Room> roomList = new ArrayList<>();
        roomList.add(room1);
        roomList.add(room2);

        // Create employees
        Employee employee1 = new Employee(101, "Alice", "Manager");
        Employee employee2 = new Employee(102, "Bob", "Developer");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);

        // Create MeetingScheduler instance
        MeetingScheduler meetingScheduler = new MeetingScheduler(roomList, employeeList);

        // Define meeting time
        LocalTime startTime = LocalTime.of(10, 0);  // 10:00 AM
        LocalTime endTime = LocalTime.of(11, 0);    // 11:00 AM

        // Book a meeting
        meetingScheduler.book(startTime, endTime, roomList, employeeList, 5);
    }
}
