package appopublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	ServiceRegistration publishAppoRegistration;

	
	public void start(BundleContext context) throws Exception {
		System.out.println("Publisher Start");
		AppoPublish publisherAppo  = new AppoPublishImpl();
		publishAppoRegistration = context.registerService(
				AppoPublish.class.getName(), publisherAppo, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Publisher Stop");
		publishAppoRegistration.unregister();
	}

}
