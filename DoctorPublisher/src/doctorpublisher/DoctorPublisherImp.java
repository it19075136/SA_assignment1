package doctorpublisher;

import java.util.ArrayList;
import java.util.Scanner;

public class DoctorPublisherImp implements DoctorPublisher {

	Scanner sc = new Scanner(System.in);
	String did, name, spec, hos;
	static ArrayList<Doctor> doc = new ArrayList<Doctor>();

	/**
	 * Doctor Register method
	 */

	@Override
	public void DoctorRegister() {

		System.out.println("Do you want to enter a doctor(y/n)?");
		String input = sc.next();

		while (input.equalsIgnoreCase("y")) {
			System.out.println("Type exit to end your proccess and leave the system");
			System.out.println("Enter doctor ID: ");
			did = sc.next();
			System.out.println("Enter doctor name: ");
			name = sc.next();
			System.out.println("Enter doctor specialization: ");
			spec = sc.next();
			System.out.println("Enter doctor hospital: ");
			hos = sc.next();
			doc.add(new Doctor(did, name, spec, hos));
			
			System.out.println("Do you want to enter another doctor(y/n)?");
			input = sc.next();
		}
	}

	/**
	 * Edit Doctor Details
	 */

	@Override
	public void EditDoctor(Doctor doctor) {
		System.out.println("Do you want to edit a doctor(y/n)?");
		String input = sc.next();
		while (input.equalsIgnoreCase("y")) {
			if (doc.contains(doctor)) {
				System.out.println("Enter what you want to edit?(name-n, specialization-s, hospital-h)");
				String editIn = sc.next();
				if (editIn.equals("n")) {
					System.out.println("Enter doctor name: ");
					name = sc.next();
					doctor.setName(name);
				} else if (editIn.equals("s")) {
					System.out.println("Enter doctor specialization: ");
					spec = sc.next();
					doctor.setSpecialization(spec);
				} else {
					System.out.println("Enter doctor hospital: ");
					hos = sc.next();
					doctor.setHospital(hos);
				}
				doc.set(doc.indexOf(doctor), doctor);

			} else if (doc.size() == 0) {
				System.out.println("No record added yet!");
			} else {
				System.out.println("No such a doctor in that id!");
			}
			System.out.println("Do you want to edit same doctor again(y/n)?");
			input = sc.next();
		}
	}

	/**
	 * Delete Doctor details
	 */

	@Override
	public void DeleteDoctor(String did) {
		System.out.println("Do you want to delete a doctor(y/n)?");
		String input = sc.next();

		while (input.equalsIgnoreCase("y")) {
			if (doc.size() != 0) {
				for (int i = 0; i < doc.size(); i++) {
					if (doc.get(i).getID() == did) {
						String deleteID = doc.get(i).getID();
						doc.remove(i);
						System.out.println("Doctor :" + deleteID + "deleted successfully");
						break;
					}
				}
			} else {
				System.out.println("No record added yet!");
			}

		}
	}

	/**
	 * Display doctor list
	 */

	@Override
	public void displayDoctorList() {
		for (Doctor doc : doc) {
			System.out.println("Doctor ID: " + doc.getID());
			System.out.println("Doctor Name: " + doc.getName());
			System.out.println("Doctor Specialization: " + doc.getSpecialization());
			System.out.println("Doctor Hospital: " + doc.getHospital());
			System.out.println("\n");
		}
	}

	/**
	 * get doctor by id
	 */
	@Override
	public Doctor getDoctorById(String did) {
		for (Doctor doctor : doc) {
			if (doctor.getID().equals(did)) {
				System.out.println(did);
				return doctor;
			}
		}
		return null;
	}
}