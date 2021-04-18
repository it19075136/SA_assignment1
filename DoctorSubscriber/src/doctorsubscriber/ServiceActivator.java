package doctorsubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import doctorpublisher.Doctor;
import doctorpublisher.DoctorPublisher;

public class ServiceActivator implements BundleActivator {

	ServiceReference doctorReference;
	Scanner sc = new Scanner(System.in);

	public void start(BundleContext context) throws Exception {
		System.out.println("Doctor subscriber start");
		doctorReference = context.getServiceReference(DoctorPublisher.class.getName());
		DoctorPublisher docPublish = (DoctorPublisher) context.getService(doctorReference);
		docPublish.DoctorRegister();
		docPublish.displayDoctorList();
		System.out.println("Choose edit or delete: (e/d)"); // choose edit or delete options
		String ans = sc.next();
		String exit = "no";
		System.out.println("Enter Doctor ID: ");
		Doctor doc = docPublish.getDoctorById(sc.next()); // get doctor by the id
		System.out.println(doc.getName());
		if (ans.equalsIgnoreCase("e")) {// doctor edit
			docPublish.EditDoctor(doc);
			System.out.println("Do you want exit (y/n)?");
			exit = sc.next();

		} else if (ans.equalsIgnoreCase("d")) {// doctor delete
			docPublish.DeleteDoctor(doc.getID());// delete the doctor details according to the id
			docPublish.displayDoctorList();
		} else {
			System.out.println("Undifine Input!!!");
		}

	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Doctor subscriber stop");
		context.ungetService(doctorReference);
	}

}