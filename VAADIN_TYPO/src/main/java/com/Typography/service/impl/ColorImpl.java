package com.Typography.service.impl;

import com.Typography.entity.color;
import com.Typography.service.ColorService;
import com.Typography.utils.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Nikas on 17.01.2017.
 */
public class ColorImpl implements ColorService {
    Session session;
    @Override
    public void add(color newcolor) {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(newcolor);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(String name) {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        color col = new color();
        col.setName(name);
        session.persist(col);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void delete(color newcolor) {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(newcolor);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(color newcolor) {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(newcolor);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public color getByColid(Integer id) {
        return null;
    }

    @Override
    public color getByName(String name) {
        return null;
    }

    @Override
    public List<color> getAll() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        List<color> ret =  session.createQuery("from color c").list();
        session.close();
        return ret;
    }
}
