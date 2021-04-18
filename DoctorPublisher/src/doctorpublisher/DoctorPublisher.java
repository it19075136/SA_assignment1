package doctorpublisher;

import java.util.ArrayList;

public interface DoctorPublisher {
	
	public void DoctorRegister();

	public void EditDoctor(Doctor doc);

	public void DeleteDoctor(String did);

	public void displayDoctorList();
	
	public Doctor getDoctorById(String did);
	
}
