package doctorpublisher;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {

	ServiceRegistration docRegistration;

	public void start(BundleContext context) throws Exception {

		System.out.println("Doctor Publisher Start");
		DoctorPublisher docPublisher = new DoctorPublisherImp();
		docRegistration = context.registerService(DoctorPublisher.class.getName(), docPublisher, null);
	}

	public void stop(BundleContext cnotext) throws Exception {
		System.out.println("Doctor Publisher Stop");
		docRegistration.unregister();
	}

}
