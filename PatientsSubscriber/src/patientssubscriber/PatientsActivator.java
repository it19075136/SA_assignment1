package patientssubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import patientspublisher.Patient;
import patientspublisher.PatientsPublisher;

public class PatientsActivator implements BundleActivator {

	ServiceReference PatientsReference;

	public void start(BundleContext bundleContext) throws Exception {

		System.out.println("subscriber start");
		String reply;
		Scanner sc = new Scanner(System.in);
		PatientsReference = bundleContext.getServiceReference(PatientsPublisher.class.getName());
		PatientsPublisher publisherPatients = (PatientsPublisher) bundleContext.getService(PatientsReference);

		/**
		 * Patient details adding
		 */
		System.out.println("Do you want to add a patient(y/n)?:");
		reply = sc.nextLine();
		while (reply.equalsIgnoreCase("y")) {
			publisherPatients.addPatients();
			System.out.println("Do you want to add another patient(y/n)?:");
			reply = sc.nextLine();
		}

		/**
		 * Show all patient details added by the admin
		 */
		System.out.println();
		publisherPatients.DisplayAllPatients();
		System.out.println();
		/**
		 * Patient details editing or deleting
		 */
		System.out.println("Do you want to edit or delete a patient(y/n)?:");
		reply = sc.nextLine();
		while (reply.equalsIgnoreCase("y")) {
			publisherPatients.DisplayAllPatients();// Show all patient details
			System.out.println();
			System.out.println("if you want to edit press 'e' or delete press 'd': ");
			reply = sc.nextLine();
			if (reply.equalsIgnoreCase("e")) {
				publisherPatients.EditPatient();
			} else if (reply.equalsIgnoreCase("d")) {
				System.out.println("Enter patient ID:");
				String patientId = sc.nextLine();
				publisherPatients.DeletePatient(patientId);
				publisherPatients.DisplayAllPatients();
			}
			System.out.println();
			System.out.println("Do you want to edit or delete another patient(y/n)?:");
			reply = sc.nextLine();
		}

	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Good bye !!!");
		bundleContext.ungetService(PatientsReference);
	}

}
