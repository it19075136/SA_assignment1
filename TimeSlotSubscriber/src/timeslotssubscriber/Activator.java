package timeslotssubscriber;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import doctorpublisher.DoctorPublisher;
import timeslotspublisher.TimeSlotsPublisher;

public class Activator implements BundleActivator {

	ServiceReference reference, reference2;
	String dId;
	static ArrayList<String> dateList;

	public void start(BundleContext bundleContext) throws Exception {

		System.out.println("Subscriber Service Started");

		Scanner sc = new Scanner(System.in);

		reference = bundleContext.getServiceReference(TimeSlotsPublisher.class.getName());
		reference2 = bundleContext.getServiceReference(DoctorPublisher.class.getName());

		TimeSlotsPublisher publish = (TimeSlotsPublisher) bundleContext.getService(reference);
		DoctorPublisher docPublish = (DoctorPublisher) bundleContext.getService(reference2);

		String cont = "y";

		do {
			System.out.println("Available Doctors");
			docPublish.displayDoctorList(); // Using doctor publisher service to get available doctors list

			System.out.print("Select Doctor Id:");
			dId = sc.next(); // selecting a doctor from the displayed list

			publish.RegisterTimeSlot(dId); // validate dids from doctorPublisher service

			dateList = publish.ListAllTimeSlots(dId); // getting all timeslots for the doctor
			String option = "";
			for (String slot : dateList) // displaying all available time slots for the doctor
				System.out.println(slot + " - " + String.valueOf(dateList.indexOf(slot) + 1));

			System.out.println("Do you want to delete or edit a timeslot? (y/n)");
			String con = sc.next();

			while (con.equalsIgnoreCase("y") && !option.equalsIgnoreCase("exit")) {

				System.out.println("Choose edit or delete option/ type exit and enter when you are done: (d/e)");
				option = sc.next();
				
				if(!option.equalsIgnoreCase("exit")){
				System.out.print("Select the time slot number:");
				int index = sc.nextInt();

				if (option.equals("d")) {
					if (publish.RemoveTimeSlot(dId, index - 1))
						System.out.println("Deleted successfully");
				} else if (option.equals("e")) {
					if (publish.ModifyTimeSlot(dId, index - 1))
						System.out.println("Modified sucessfully");
				} else if (option.equals("exit"))
					System.out.println("Exiting session");
				else
					System.out.println("Wrong Input!");

				dateList = publish.ListAllTimeSlots(dId); // getting all timeslots for the doctor
				for (String slot : dateList) // displaying all available time slots for the doctor
					System.out.println(slot + " - " + String.valueOf(dateList.indexOf(slot) + 1));
			}
				
			}

			System.out.println("Do you want to add timeslots for another doctor? (y/n)");
			cont = sc.next();

		} while (cont.equalsIgnoreCase("y"));

	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Subscriber Service stopped");
		bundleContext.ungetService(reference);
	}
}
