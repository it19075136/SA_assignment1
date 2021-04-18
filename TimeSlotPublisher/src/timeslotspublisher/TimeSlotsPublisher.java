package timeslotspublisher;

import java.util.ArrayList;

public interface TimeSlotsPublisher {

	public void RegisterTimeSlot(String id);
	public boolean IsTimeSlotVacant(String day,String from,String to);
	public ArrayList<String> ListAllTimeSlots(String id);
	public boolean ModifyTimeSlot(String id,int index);
	public boolean RemoveTimeSlot(String id,int index);
	
}
