package patientspublisher;

import java.util.HashMap;
import java.util.Scanner;

public class PateintsPublisherImpl implements PatientsPublisher {
	HashMap<String, Patient> patientArr = new HashMap<String, Patient>();
	String[] attrArry = { "patientId", "patientName", "guardientName", "gender", "email", "DOB", "phoneNum" };
	String[] values = new String[7];// inputs values for patient

	@Override
	public void DisplayAllPatients() {
		// TODO Auto-generated method stub
		if (patientArr.isEmpty()) {
			System.out.println("No patients");
		} else {
			/**
			 * Show all patient details
			 */
			patientArr.forEach((k, v) -> System.out.format(
					"patientId: %s, patientName: %s , guardientName: %s ,gender: %s,email: %s,DOB: %s,phoneNum: %s \n",
					k, v.getPatientName(), v.getGuardientName(), v.getGender(), v.getEmail(), v.getDOB(),
					v.getPhoneNum()));
		}

	}

	@Override
	public void addPatients() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter " + attrArry[0] + " :");
		values[0] = sc.nextLine();
		/**
		 * checking the id is already in the list
		 */
		if (patientArr.containsKey(values[0])) {
			System.out.println("unsuccessful");

			values[0] = "";

		} else {
			/**
			 * geting the inputs for the patient
			 */
			for (int i = 1; i < attrArry.length; i++) {
				do {
					System.out.println("Enter " + attrArry[i] + ": ");
					values[i] = sc.nextLine();
				} while (values[i].equalsIgnoreCase(""));
			}
			Patient patient = new Patient(values[0], values[1], values[2], values[3], values[4], values[5], values[6]);

			patientArr.put(values[0], patient);

			/**
			 * clearing the values array
			 */
			for (int i = 0; i < values.length; i++) {
				values[i] = "";
			}
			System.out.println();

		}

	}

	@Override
	public void DeletePatient(String patientsId) {
		// TODO Auto-generated method stub
		/**
		 * checking the id is in the list
		 */
		if (patientArr.containsKey(patientsId)) {
			patientArr.remove(patientsId);
			System.out.println("Successful deleted");
		} else {
			System.out.println("They is not a such a patient");
		}

	}

	@Override
	public void EditPatient() {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		/**
		 * geting the patient iD want to edit
		 */
		System.out.println("Enter " + attrArry[0] + " :");
		values[0] = sc.nextLine();
		if (patientArr.containsKey(values[0])) {

			for (int i = 1; i < attrArry.length; i++) {
				System.out.println("Enter " + attrArry[i] + " :");
				values[i] = sc.nextLine();
				/**
				 * seting the remaining value to the values array
				 */
				if (values[i].equalsIgnoreCase("") && i == 1) {
					values[i] = patientArr.get(values[0]).getPatientName();
				} else if (values[i].equalsIgnoreCase("") && i == 2) {
					values[i] = patientArr.get(values[0]).getGuardientName();
				} else if (values[i].equalsIgnoreCase("") && i == 3) {
					values[i] = patientArr.get(values[0]).getGender();
				} else if (values[i].equalsIgnoreCase("") && i == 4) {
					values[i] = patientArr.get(values[0]).getEmail();
				} else if (values[i].equalsIgnoreCase("") && i == 5) {
					values[i] = patientArr.get(values[0]).getDOB();
				} else if (values[i].equalsIgnoreCase("") && i == 6) {
					values[i] = patientArr.get(values[0]).getPhoneNum();
				}
			}

			Patient patient = new Patient(values[0], values[1], values[2], values[3], values[4], values[5], values[6]);
			patientArr.replace(values[0], patient);

			/**
			 * displaying the edited patient
			 */
			for (int i = 0; i < values.length; i++) {
				System.out.print(values[i] + ",");
				values[i] = "";
			}

		} else {
			System.out.println("Patient edit unsuccessful");
			values[0] = "";
		}

	}
}
