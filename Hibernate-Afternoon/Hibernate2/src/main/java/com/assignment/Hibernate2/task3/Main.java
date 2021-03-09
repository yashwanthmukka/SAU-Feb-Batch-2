package com.assignment.Hibernate2.task3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

	public static void main(String[] args) {
        Audience a1 = new Audience();
        a1.setAge(21);
        a1.setName("Rajesh");

        Audience a2 = new Audience();
        a2.setAge(21);
        a2.setName("Yashwanth");


        Screen st = new Screen();
        st.setScreenno(1);
        st.setShowtime(4);
        st.setName("PVR");

        a1.setScreen1(st);
        a2.setScreen1(st);

        st.getAudience().add(a1);
        st.getAudience().add(a2);


        Configuration config = new Configuration().configure().addAnnotatedClass(Screen.class).addAnnotatedClass(Audience.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf = config.buildSessionFactory(registry);
        Session session = sf.openSession();

        session.beginTransaction();
        session.save(a1);
        session.save(a2);
        session.save(st);
        session.getTransaction().commit();
    }

}
