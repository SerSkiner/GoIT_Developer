package dao.hibernate;

import dao.ManufacturerDAO;
import model.Manufacturer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class ManufacturerDAOImpl implements ManufacturerDAO {
    @Override
    public void save(Manufacturer manufacturer) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(manufacturer);
        transaction.commit();
        session.close();

    }

    @Override
    public Manufacturer getById(Long aLong) {
        return null;
    }

    @Override
    public void remove(Long id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Manufacturer manufacturer = session.get(Manufacturer.class, id);
        session.delete(manufacturer);
        transaction.commit();
        session.close();

    }

    @Override
    public List<Manufacturer> getAll() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Manufacturer> manufacturerList = session.createQuery("from Manufacturer").list();
        session.getTransaction().commit();
        session.close();
        return manufacturerList;    }
}
