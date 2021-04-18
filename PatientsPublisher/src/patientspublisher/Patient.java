package patientspublisher;

public class Patient {
	private String patientId, patientName, guardientName, gender, email, DOB, phoneNum;

	public Patient(String patientId, String patientName, String guardientName, String gender, String email, String DOB,
			String phoneNum) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.guardientName = guardientName;
		this.gender = gender;
		this.email = email;
		this.DOB = DOB;
		this.phoneNum = phoneNum;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getGuardientName() {
		return guardientName;
	}

	public void setGuardientName(String guardientName) {
		this.guardientName = guardientName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDOB() {
		return this.DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}
