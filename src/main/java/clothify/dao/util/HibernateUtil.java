package clothify.dao.util;

import clothify.entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.HibernateException;

public class HibernateUtil {

    // Lazy initialization - Singleton SessionFactory
    private static SessionFactory sessionFactory;

    private static SessionFactory createSessionFactory() {
        try {
            // Load the Hibernate configuration file and initialize the ServiceRegistry
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();

            // Create Metadata from annotated classes
            Metadata metadata = new MetadataSources(standardRegistry)
                    .addAnnotatedClass(Account.class)
                  
                    .getMetadataBuilder()
                    .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                    .build();

            // Build the SessionFactory from the Metadata
            return metadata.getSessionFactoryBuilder().build();

        } catch (HibernateException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("SessionFactory creation failed: " + e);
        }
    }

    // Provide global access to the SessionFactory
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory(); // Lazy initialization
        }
        return sessionFactory;
    }

    // Get a new session from the session factory
    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    // Optional: Shut down the session factory when the application terminates
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
