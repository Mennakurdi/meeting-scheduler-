package meetingscheduler;
import java.util.ArrayList;
import java.util.List;


public class MeetingRoom {
	int roomid;
	String name;
	int capacity;
	 List<Interval> bookings;
	public  MeetingRoom(int roomid ,String name,int capacity) {
		this.roomid=roomid;
		this.name=name;
		this.capacity=capacity;
		this.bookings= new ArrayList<>();
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean isAvailable (Interval  Interval){
	   for (int i=0;i<bookings.size();i++){
		   Interval booked = bookings.get(i);
		   if(Interval.overlaps(booked))
			   return false;
	   }
	   return true;
	}
	public boolean bookRoom( Interval  Interval){
		if (isAvailable(Interval)){
			bookings.add(Interval);
			return true;
		}
		return false;
	}
	
	public void cancelBooking(Interval interval) {
        bookings.remove(interval);
    }

	public int getRoomid() {
		return roomid;
	}

	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	public List<Interval> getBookings() {
		return bookings;
	}

	public void setBookings(List<Interval> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "MeetingRoom [roomid=" + roomid + ", name=" + name
				+ ", capacity=" + capacity + ", bookings=" + bookings + "]";
	}

  

}
