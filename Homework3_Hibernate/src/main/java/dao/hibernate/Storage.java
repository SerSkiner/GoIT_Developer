package dao.hibernate;

import dao.SkillDAO;
import model.Skill;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;


public class Storage implements SkillDAO {

    SessionFactory sessionFactory;

    public Storage() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }


    public List<Skill> getAllSkill() {

        return null;
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

    public void remove(Long aLong) {

    }

    public List<Skill> getAll() {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("SELECT s.skill_name FROM Skill s");
        List<Skill> result = query.list();
        session.close();
        return result;    }
}
