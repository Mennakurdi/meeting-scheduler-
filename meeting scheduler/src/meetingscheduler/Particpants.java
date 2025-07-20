package meetingscheduler;

public class Particpants {
    private int id;
    private String name;
    private String email;
    private Calender calendar; 

   
    public Particpants(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.calendar = new Calender(); 
    }


   
    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Calender getCalendar() {
		return calendar;
	}



	public void setCalendar(Calender calendar) {
		this.calendar = calendar;
	}



	public boolean isAvailable(Interval interval) {
        return calendar.isFree(interval);
    }

  
    public void addMeeting(Interval interval) {
        calendar.addEvent(interval);
    }

    
    public void cancelMeeting(Interval interval) {
        calendar.CancelEvent(interval);
    }

    @Override
    public String toString() {
        return "Participant{" + "id=" + id +", name='" + name + '\'' + ", email='" + email + '\'' + ", calendar=" + calendar +
                '}';
    }
}
