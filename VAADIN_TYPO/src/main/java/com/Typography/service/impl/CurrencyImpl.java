package com.Typography.service.impl;

import com.Typography.entity.currency;
import com.Typography.service.CurrencyService;
import com.Typography.utils.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Nikas on 17.01.2017.
 */
public class CurrencyImpl implements CurrencyService {
    Session session;
    @Override
    public void add(currency curr) {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(curr);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(String name) {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(new currency(name));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(currency curr) {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(curr);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(currency curr) {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(curr);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<currency> getAll() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        List<currency> ret = session.createQuery("from currency c").list();
        session.close();
        return ret;
    }

    @Override
    public currency getByCurrid(Integer id) {
        return null;
    }

    @Override
    public currency getByName(String name) {
        return null;
    }
}
