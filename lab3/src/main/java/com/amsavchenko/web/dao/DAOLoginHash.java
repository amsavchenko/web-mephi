package com.amsavchenko.web.dao;

import com.amsavchenko.web.entities.LoginHash;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.amsavchenko.web.SessionFactoryUtil;

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
        finally {
            session.close();
        }
        return isOk;
    }

    public boolean isContainLoginHash(String login, String hash) {
        boolean isContain = false;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LoginHash lh = new LoginHash(login, hash);

        LoginHash lh2 = session.get(LoginHash.class, hash);
        if (lh2 != null) {
            if (lh2.getLogin().equals(login)) {
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
        LoginHash lh2 = session.get(LoginHash.class, hash);
        if (lh2 != null) {
            isContain = true;
        }
        return isContain;
    }

}
