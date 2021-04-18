package doctorpublisher;

public class Doctor {
	String ID, Name, Specialization, Hospital;

	public Doctor() {

	}

	public Doctor(String iD, String name, String specialization, String hospital) {
		super();
		ID = iD;
		Name = name;
		Specialization = specialization;
		Hospital = hospital;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSpecialization() {
		return Specialization;
	}

	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}

	public String getHospital() {
		return Hospital;
	}

	public void setHospital(String hospital) {
		Hospital = hospital;
	}

}
