package net.home.app.dao.hibernate;
import net.home.app.model.Manufacter;
import net.home.app.model.Product;
import net.home.app.dao.ProductDAO;
import net.home.app.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public  class ProductDAOImpl implements ProductDAO {
    @Override
    public List<Product> getProducts()  {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Product> list=session.createQuery("from Product").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Product saveProduct(Product product)  {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
        return product;
    }

    @Override
    public Product updateProduct(Product product)  {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(product);
        transaction.commit();
        session.close();
        return product;
    }



    @Override
    public Product deleteProduct(String id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Product product = session.get(Product.class, id);
        session.delete(product);
        transaction.commit();
        session.close();
        return product;
    }

    @Override
    public List<Product> listProduct()  {
        return null;
    }

    @Override
    public void addProduct(List<Product> list) {


    }

    @Override
    public List<Manufacter> getManufacters() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Manufacter> list=session.createQuery("from Manufacter").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Manufacter saveManufacter(Manufacter manufacter) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(manufacter);
        transaction.commit();
        session.close();
        return manufacter;
    }

    @Override
    public Manufacter updateManufacter(Manufacter manufacter) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(manufacter);
        transaction.commit();
        session.close();
        return manufacter;    }

    @Override
    public Manufacter deleteManufacter(String id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Manufacter manufacter = session.get(Manufacter.class, id);
        session.delete(manufacter);
        transaction.commit();
        session.close();
        return manufacter;    }

    @Override
    public List<Manufacter> listManufacter() {
        return null;
    }

    @Override
    public void addManufacter(List<Manufacter> manufacters) {

    }

    public Product getById(String id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }
    public Manufacter getId(String id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Manufacter manufacter = session.get(Manufacter.class, id);
        session.close();
        return manufacter;
    }

}
