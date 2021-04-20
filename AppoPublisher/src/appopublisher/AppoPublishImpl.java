package appopublisher;

import java.util.ArrayList;
import java.util.Scanner;

public class AppoPublishImpl implements AppoPublish {
	Scanner sc = new Scanner (System.in);
	ArrayList<String> appo = new ArrayList<String>();
	String time;
	int id;

	@Override
	public void appoBooking(ArrayList<String> array, String dId, String pId) {
		
		
			
		for(int i =0; i < array.size(); i++) {
			System.out.println("id is "+ i +" and value is "+array.get(i));
		}
		System.out.println(" ");
		System.out.println("Enter the id of the timeslot you need to make an appointment");
		System.out.println(" ");

		 id = sc.nextInt();
		time = array.get(id);
		
		//if(id > -1) {
//			for(int i = id; i < array.size() -1; i++) {
//				array.add(i) = array[i+1];
//			}
			
			appo.add("Doc ID = "+dId+" Patient ID = "+pId+" and appointement time is = "+time);
			System.out.println(" ");
			System.out.println("Appointment Added");
		//}
		
	}

	@Override
	public void appoList() {
		// TODO Auto-generated method stub
		System.out.println(" ");

		for(int i = 0; i < appo.size(); i++) {
			System.out.println("Id = "+i+" "+appo.get(i));
		}
		
	}

	@Override
	public void editAppo(int id,ArrayList<String> array,String dId, String pId) {
		// TODO Auto-generated method stub
//		String isNext = null;
//		do {
			System.out.println(appo.get(id).toString());
			System.out.println("  ");
			System.out.println("Enter the new patient ID");
			String edittPid = sc.next();
			System.out.println("Enter the new doctor ID");
			//show doctor list here
			String editDid = sc.next();
			System.out.println(" ");
			System.out.println("List of available time slots");
			
			System.out.println(" ");
			for(int i = 0; i < array.size();i++) {
				System.out.println("id is "+ i +" and timeslot is "+array.get(i));
			}
			System.out.println(" ");

			System.out.println("Enter the new time slot");

			String editTime = sc.next();
			
			System.out.println(" ");

			appo.set(id, "Doc ID = "+editDid+" appointement time "+editTime);
			System.out.println("Edited appointment : "+appo.get(id));
			

//		}while(isNext.equalsIgnoreCase("y"));
		
		
	}
	

	
}
