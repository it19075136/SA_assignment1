package timeslotspublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration registration;
	
	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("Service started");
		TimeSlotsPublisher publisher = new TimeSlotsPublisherImp();
		registration = bundleContext.registerService(TimeSlotsPublisher.class.getName(), publisher, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Service Stopped");
		registration.unregister();
	
	}

}
