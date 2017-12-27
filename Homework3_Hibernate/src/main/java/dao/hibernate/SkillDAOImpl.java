package dao.hibernate;

import dao.SkillDAO;
import model.Developer;
import model.skill.Skill;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;


public class SkillDAOImpl implements SkillDAO {

    SessionFactory sessionFactory;

    public SkillDAOImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }


    public List<Skill> getAllSkill() {

        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List skills = session.createQuery("FROM Skills").list();

        transaction.commit();
        session.close();
        return skills;
    }




     public void save(Skill skill) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(skill);
        transaction.commit();
        session.close();

    }




    public Skill getById(Long id) {
        Session session = this.sessionFactory.openSession();
        Skill skill = session.get(Skill.class, id);
        session.close();
        return skill;    }

    public void remove(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Skill skill = session.get(Skill.class, id);
        session.delete(skill);
        transaction.commit();
        session.close();

    }



    public List<Skill> getAll() {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery(" FROM Skill");
        List<Skill> result = query.list();
        session.close();
        return result;
    }
}

