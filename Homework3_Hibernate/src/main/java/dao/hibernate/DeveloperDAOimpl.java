package dao.hibernate;

import dao.DeveloperDAO;
import model.Developer;
import model.Skill;
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

    }

    public Developer getById(Long aLong) {
        return null;
    }

    public void remove(Long aLong) {

    }
}
