package meetingscheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    
        Particpants menna = new Particpants(1, "menna", "menna@example.com");
        Particpants kurdi = new Particpants(2, "kurdi", "kurdi@example.com");
        Particpants Ahmed = new Particpants(3, "Ahmed", "Ahmed@example.com");

        List<Particpants> participants = new ArrayList<>();
        participants.add(menna);
        participants.add(kurdi);
        participants.add(Ahmed);

       
        Interval kurdibusy = new Interval(LocalDateTime.of(2025, 7, 21, 10, 0), LocalDateTime.of(2025, 7, 21, 11, 0));
        kurdi.addMeeting(kurdibusy);

      
        MeetingRoom room101 = new MeetingRoom(101, "Room 101", 10);
        MeetingRoom room102 = new MeetingRoom(102, "Room 102", 5);

        List<MeetingRoom> rooms = new ArrayList<>();
        rooms.add(room101);
        rooms.add(room102);

       
        LocalDateTime startRange = LocalDateTime.of(2025, 7, 21, 9, 0);
        LocalDateTime endRange = LocalDateTime.of(2025, 7, 21, 17, 0);

       
        int durationMinutes = 60;

   
        Particpants organizer = menna;

    
        Scheduler scheduler = new Scheduler();
        Meeting meeting = scheduler.findBestMeetingSlot(
                "MTI",
                "meeting ",
                participants,
                rooms,
                startRange,
                endRange,
                durationMinutes,
                organizer
        );

      if (meeting != null) {
            System.out.println("Meeting Details:");
            System.out.println(meeting);
        } else {
            System.out.println("No available slot found for the meeting.");
        }
    }
}
