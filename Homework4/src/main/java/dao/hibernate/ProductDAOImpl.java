package dao.hibernate;

import dao.ProductDAO;
import model.Manufacturer;
import model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.io.Serializable;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public void save(Product product) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(product);
        transaction.commit();
        session.close();
    }

    @Override
    public Product getById(Long aLong) {
        return null;
    }

    @Override
    public void remove(Long id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);
        transaction.commit();
        session.close();


    }

    @Override
    public List<Product> getAll() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Product> list = session.createQuery("from Product ").list();
        session.getTransaction().commit();
        session.close();
        return list;    }
}
