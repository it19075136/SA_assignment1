package apposubscriber;

import appopublisher.AppoPublish;
import doctorpublisher.DoctorPublisher;
import patientspublisher.PatientsPublisher;
import timeslotspublisher.TimeSlotsPublisher;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	ServiceReference appoReference;
	ServiceReference doctorReference;
	ServiceReference patientReference;
	ServiceReference timeslotReference;



	String dID, pID;
	Scanner sc = new Scanner(System.in);
	int editIndex;
	String isNext= null;
	String isEditNext = null;

	public void start(BundleContext context) throws Exception {
		System.out.println("start subscriber service");
		
		appoReference = context.getServiceReference(AppoPublish.class.getName());
		doctorReference = context.getServiceReference(DoctorPublisher.class.getName());
		patientReference = context.getServiceReference(PatientsPublisher.class.getName());
		timeslotReference = context.getServiceReference(TimeSlotsPublisher.class.getName());


		AppoPublish appoPublish = (AppoPublish) context.getService(appoReference);
		DoctorPublisher docPublish = (DoctorPublisher) context.getService(doctorReference);
		PatientsPublisher patPublish = (PatientsPublisher) context.getService(patientReference);
		TimeSlotsPublisher timePublish = (TimeSlotsPublisher) context.getService(timeslotReference);

		
		String[] cars = {"first","second","third","fourth","fifth"};
//		ArrayList<String> timeslots = timePublish.ListAllTimeSlots(dID);

		

		
		do {
			System.out.println("Patient List");
			patPublish.DisplayAllPatients();
			System.out.println("Enter Patient ID");
			System.out.println("Select a patient id :");
			pID = sc.next();
			
			System.out.println("Doctor List");
			docPublish.displayDoctorList();
			System.out.println("Select a doctor id :");
			dID = sc.next();
			
			System.out.println("TimeSlot List for the doctor id :"+dID);
			ArrayList<String> timeslots = timePublish.ListAllTimeSlots(dID);

		for(String item: timeslots) {
			System.out.println(item);
		}

		
		appoPublish.appoBooking(timeslots, dID, pID);
			
			System.out.println("Would you like to make another appointemnt (y/n)");
			isNext = sc.next();
		}while(isNext.equalsIgnoreCase("y"));	
		
 			appoPublish.appoList();
		
		do {
			System.out.println("Would you like to edit an appointemnt (y/n)");
			String isEditBefore = sc.next();
			
			if(isEditBefore.equalsIgnoreCase("y")) {
				System.out.println("Enter the id of the appointment to edit :");
				editIndex = sc.nextInt();
				ArrayList<String> timeslots = timePublish.ListAllTimeSlots(dID);
				appoPublish.editAppo(editIndex, timeslots, dID, pID);
				System.out.println("Would you like to edit another appointemnt (y/n)");
				isEditNext = sc.next();
			}else {
				isEditNext = "n";
			}

			

		}while(isEditNext.equalsIgnoreCase("y"));
				
	}
	
	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye !!");
		context.ungetService(appoReference);
		
	}

}
