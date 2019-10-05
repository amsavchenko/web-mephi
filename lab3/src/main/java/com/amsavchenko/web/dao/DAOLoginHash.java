package com.amsavchenko.web.dao;

import com.amsavchenko.web.entities.LoginHash;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.amsavchenko.web.SessionFactoryUtil;
import java.util.List;

public class DAOLoginHash {

    private SessionFactory sessionFactory;

    public DAOLoginHash() {
        this.sessionFactory = SessionFactoryUtil.getSessionFactory();
    }

    public boolean addLoginHash(String login, String hash) {
        boolean isOk = true;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LoginHash lh = new LoginHash(login, hash);
        try {
            session.save(lh);
            //transaction.commit();
            session.getTransaction().commit();
        }
        catch (HibernateException e) {
            isOk = false;
        }
        //finally {
            //session.close();
        //}
        return isOk;
    }

    public boolean isContainLoginHash(String login, String hash) {
        boolean isContain = false;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LoginHash lh = new LoginHash(login, hash);

        LoginHash lh2 = session.get(LoginHash.class, login);
        if (lh2 != null) {
            if (lh2.getHash().equals(hash)) {
                isContain = true;
            }
        }
        session.close();
        return isContain;
    }

    public boolean isHashContainInTable(String hash) {
        boolean isContain = false;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<LoginHash> lhs = (List<LoginHash>) session.createQuery("From LoginHash").list();
        for (LoginHash lh : lhs) {
            if (lh.getHash().equals(hash))
                isContain = true;
        }
        return isContain;
    }

}
