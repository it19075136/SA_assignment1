package patientspublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class PatientsActivator implements BundleActivator {

	ServiceRegistration publisherPatientsRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("publisher start");
		PatientsPublisher publisherPatients = new PateintsPublisherImpl();
		publisherPatientsRegistration = bundleContext.registerService(PatientsPublisher.class.getName(),
				publisherPatients, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("publisher stop");
		publisherPatientsRegistration.unregister();
	}

}
