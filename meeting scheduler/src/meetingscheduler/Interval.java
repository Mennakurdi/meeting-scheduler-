package meetingscheduler;
import java.time.LocalDateTime;
  
public class Interval {
	LocalDateTime Start;
	LocalDateTime End;
	public  Interval(LocalDateTime Start,LocalDateTime End){
		this.Start=Start;
		this.End=End;
	}
	public LocalDateTime getStart() {
		return Start;
	}
	public void setStart(LocalDateTime start) {
		Start = start;
	}
	public LocalDateTime getEnd() {
		return End;
	}
	public void setEnd(LocalDateTime end) {
		End = end;
	}
	
	public boolean overlaps(Interval other) {
	    if (!(this.End.isBefore(other.Start) || this.Start.isAfter(other.End))) {
	        return true;  
	        } else {
	        return false; 
	    }
	}
	public boolean InRange (LocalDateTime time){
		 return (!time.isBefore(Start) && !time.isAfter(End));
		
	}
 
	@Override
    public String toString() {
        return "Interval{" + "start=" + Start + ", end=" + End + '}';
    }
}
