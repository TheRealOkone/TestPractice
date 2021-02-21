package ru;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private final SessionFactory sessionFactory;

    private Session session;

    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }
    public List<Item> getUsers() {
        return session.createSQLQuery("select * from public.items").getResultList();
    }
    public void insertUser(Item a) {
        session.beginTransaction();
        session.saveOrUpdate(a);
        session.getTransaction().commit();
    }
}
