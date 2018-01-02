package dao.hibernate;

import dao.ProjectDAO;
import model.project.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {

    SessionFactory sessionFactory;

    public ProjectDAOImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }


    public void save(Project project) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(project);
        transaction.commit();
        session.close();
    }

    public Project getById(Long id) {
        Session session = this.sessionFactory.openSession();
        Project project = session.get(Project.class, id);
        session.close();
        return project;
    }

    public void remove(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Project project = session.get(Project.class, id);
        session.delete(project);
        transaction.commit();
        session.close();

    }

    public List<Project> getAll() {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery(" FROM Project");
        List<Project> result = query.list();
        session.close();
        return result;    }
}
