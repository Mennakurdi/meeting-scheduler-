package meetingscheduler;

import java.util.ArrayList;
import java.util.List;

public class Meeting {
	String meetingId;
	String title ;
	Interval interval;
	MeetingRoom  meetingRoom;
	Particpants organizer ;
	List<Particpants> participants;

	 public Meeting(String meetingId, String title, Interval interval, MeetingRoom meetingRoom, Particpants organizer) {
	        this.meetingId = meetingId;
	        this.title = title;
	        this.interval = interval;
	        this.meetingRoom = meetingRoom;
	        this.organizer = organizer;
	        this.participants = new ArrayList<>();
	    }

	
	public String getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	public Particpants getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Particpants organizer) {
		this.organizer = organizer;
	}

	public List<Particpants> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Particpants> participants) {
		this.participants = participants;
	}
	 public void addParticipant(Particpants Particpants ){
		 if (Particpants.isAvailable(interval)){
			 Particpants.addMeeting(interval);
			 participants.add(Particpants);
			  System.out.println("Notification sent to " + Particpants.getEmail());

		 }
	 }
	 public void removeParticipant(Particpants participant) {
		    if (participants.contains(participant)) {
		        participants.remove(participant);
		        participant.cancelMeeting(interval); 
		        System.out.println("Notification: " + participant.getEmail() + " has been removed from the meeting.");
		    }
		}
	 public void notifyParticipants(String message) {
		    for (Particpants p : participants) {
		        System.out.println("Notification to " + p.getEmail() + ": " + message);
		    }
		}


	@Override
	public String toString() {
		return "Meeting [meetingId=" + meetingId + ", title=" + title
				+ ", interval=" + interval + ", meetingRoom=" + meetingRoom
				+ ", organizer=" + organizer + ", participants=" + participants
				+ "]";
	}


}
