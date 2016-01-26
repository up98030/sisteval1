package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory()
    {
        try
        {
        	
        	Configuration cf = new Configuration().configure("hibernate.cfg.xml");

            ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
            srb.applySettings(cf.getProperties());
            ServiceRegistry sr = srb.buildServiceRegistry();
            SessionFactory sf = cf.buildSessionFactory(sr);
        	
            // Create the SessionFactory from hibernate.cfg.xml
            return sf;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
  
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}
