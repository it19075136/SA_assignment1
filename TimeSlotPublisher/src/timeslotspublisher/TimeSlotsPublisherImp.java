package timeslotspublisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TimeSlotsPublisherImp implements TimeSlotsPublisher {

	Scanner sc = new Scanner(System.in);
	static HashMap<String, ArrayList<String>> timeSlots = new HashMap<String, ArrayList<String>>(); // to store timeslots in an arraylist against the doctor id as the key 
	String day,from,to;
	static ArrayList<String> dateTime = new ArrayList<String>();
	
	@Override
	public void RegisterTimeSlot(String id) {
		System.out.println("Do you want to add a timeslot(y/n)?");
		String check = sc.next();
		while(check.equalsIgnoreCase("y")) {
		System.out.print("Enter the day of the week:");
		day = sc.next(); // set day
		System.out.print("Time from:(HH:MM in 24h)");
		from = sc.next(); // set time from
		System.out.print("Time to:(HH:MM in 24h)");
		to = sc.next(); // set time from		
		if(IsTimeSlotVacant(day, from, to)) { // checking if the timeslot is already taken
			dateTime.add(day+" - From "+from+" To "+to);
		}
		else
			System.out.println("Time slot is already added");
		System.out.println("Do you want to add a timeslot(y/n)?");
		check = sc.next();
		}
		timeSlots.put(id, dateTime);
	}
	
	@Override
	public boolean IsTimeSlotVacant(String day, String from, String to) {
		// validate dateTime array
		if(!dateTime.contains(day+" - From "+from+" To "+to))
			return true;
		else
			return false;
	}

	@Override
	public ArrayList<String> ListAllTimeSlots(String id) {
		return timeSlots.get(id);
	}

	@Override
	public boolean ModifyTimeSlot(String id,int index) {
		ArrayList<String> dates = timeSlots.get(id);
		if(dates.remove(index) != null) {
				System.out.print("Enter the day of the week:");
				day = sc.next(); // set day
				System.out.print("Time from:(HH:MM in 24h)");
				from = sc.next(); // set time from
				System.out.print("Time to:(HH:MM in 24h)");
				to = sc.next(); // set time from		
				if(IsTimeSlotVacant(day, from, to)) 
					dates.add(day+" - From "+from+" To "+to);
				else
					System.out.println("Time slot is already added");
			timeSlots.replace(id, dates); //updating the timeslots arraylist after modifying
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean RemoveTimeSlot(String id,int index) {
		ArrayList<String> dates = timeSlots.get(id);
		if(dates.remove(index) != null) {
			timeSlots.replace(id, dates); //updating the timeslots arraylist after removing one
			return true;
		}
		else
			return false;
	}



}
