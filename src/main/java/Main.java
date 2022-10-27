import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public static void main(String[] args) {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet("bobik"));
        pets.add(new Pet("sharik"));
        User denis = new User("denis");
        denis.setPets(pets);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(denis);
        session.detach(denis);
        session.getTransaction().commit();
        session.close();

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        //session1.merge(denis);
        UserQ bob = new UserQ("bob", 15);
        bob.setPet(denis.getPets());
        session1.save(bob);
        session1.getTransaction().commit();
        session1.close();




    }
}
