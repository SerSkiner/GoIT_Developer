package dao.hibernate;

import com.sun.xml.bind.v2.model.core.ID;
import dao.DeveloperDAO;
import model.Developer;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class DeveloperDAOimpl implements DeveloperDAO {
    SessionFactory sessionFactory;

    public DeveloperDAOimpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }




    public List<Developer> getAll() {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery(" FROM Developer");
        List<Developer> result = query.list();
        session.close();
        return result;
    }



    public void save(Developer developer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(developer);
        transaction.commit();
        session.close();

    }







    public Developer getById(Long id) {
        Session session = this.sessionFactory.openSession();
        Developer developer = session.get(Developer.class, id);
        session.close();
        return developer;    }

    public void remove(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Developer developer = session.get(Developer.class, id);
        session.delete(developer);
        transaction.commit();
        session.close();

    }
}
