package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by serdartugcu on 31.03.2018.
 */
public class HibernateUtil {
    public static Session getSession() {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        return sessionFactory.openSession();
    }
}
