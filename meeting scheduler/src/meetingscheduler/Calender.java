package meetingscheduler;
import java.util.ArrayList;
import java.util.List;

public class Calender {
	int Year ;
	int Month;
	int Day;
	int userid;
	 List<Interval> meetings;
	public  Calender(int Year,int Month,int Day,int userid){
		this.Year=Year;
		this.Month=  Month ;
		this.Day= Day ;
		this.userid=userid;
		this.meetings= new ArrayList<>();
	}
	public Calender() {
        this.Year = 0;
        this.Month = 0;
        this.Day = 0;
        this.userid = 0;
        this.meetings = new ArrayList<>();
    }

	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public List<Interval> getMeetings() {
		return meetings;
	}
	public void setMeetings(List<Interval> meetings) {
		this.meetings = meetings;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public int getMonth() {
		return Month;
	}
	public void setMonth(int month) {
		Month = month;
	} 	
	public int getDay() {
		return Day;
	}
	public void setDay(int day) {
		Day = day;
	}
   public boolean isFree(Interval Interval ){
	   for (int i = 0;i<meetings.size();i++){
		  Interval booked = meetings.get(i);
		  if (booked.overlaps(Interval)) {
			  return false;
		  }
	   }
	 
	   
	   return true ;
	   	
   }	
   
   public void addEvent(Interval Interval){
	   meetings.add(Interval);   
   }
   
   public void CancelEvent(Interval Interval){
	   meetings.remove(Interval);
   }
   public List<Interval> getMeetingsForDate(int year, int month, int day) {
	    List<Interval> result = new ArrayList<>();
	    if (this.Year == year && this.Month == month && this.Day == day) {
	        result.addAll(meetings);
	    }
	    return result;
	}

   @Override
   public String toString() {
       return "Calendar{" +"Year=" + Year +", Month=" + Month +", Day=" + Day +", userid=" + userid +", meetings=" + meetings +'}';
   }

}
