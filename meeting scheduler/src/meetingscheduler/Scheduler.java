package meetingscheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Scheduler {

    public Meeting findBestMeetingSlot(
            String meetingId,
            String title,
            List<Particpants> participants,
            List<MeetingRoom> rooms,
            LocalDateTime startRange,
            LocalDateTime endRange,
            int durationMinutes,
            Particpants organizer
    ) {
        Interval bestInterval = null;
        MeetingRoom bestRoom = null;
        List<Particpants> selectedParticipants = new ArrayList<>();
        int maxAvailableCount = -1;

        System.out.println("Trying to find the best time to schedule the meeting: '" + title + "'");

        for (LocalDateTime start = startRange;
             !start.plusMinutes(durationMinutes).isAfter(endRange);
             start = start.plusMinutes(30)) {

            Interval candidate = new Interval(start, start.plusMinutes(durationMinutes));
            List<Particpants> availableNow = new ArrayList<>();

            for (int i = 0; i < participants.size(); i++) {
                Particpants p = participants.get(i);
                if (p.isAvailable(candidate)) {
                    availableNow.add(p);
                }
            }

            for (int j = 0; j < rooms.size(); j++) {
                MeetingRoom room = rooms.get(j);
                if (room.isAvailable(candidate)) {
                    if (availableNow.size() > maxAvailableCount) {
                        bestInterval = candidate;
                        bestRoom = room;
                        selectedParticipants = availableNow;
                        maxAvailableCount = availableNow.size();
                    }
                    break;
                }
            }
        }

        if (bestInterval == null || bestRoom == null || selectedParticipants.isEmpty()) {
            System.out.println("Couldn't find a suitable time and room for the meeting.");
            return null;
        }

        bestRoom.bookRoom(bestInterval);
        organizer.addMeeting(bestInterval);
        Meeting meeting = new Meeting(meetingId, title, bestInterval, bestRoom, organizer);

        for (int k = 0; k < selectedParticipants.size(); k++) {
            meeting.addParticipant(selectedParticipants.get(k));
        }

        System.out.println("Meeting successfully scheduled!");
        System.out.println("Time: " + bestInterval.getStart() + " to " + bestInterval.getEnd());
        System.out.println("Room: " + bestRoom.getName());
        System.out.println("Participants confirmed: " + selectedParticipants.size());

        return meeting;
    }
}
