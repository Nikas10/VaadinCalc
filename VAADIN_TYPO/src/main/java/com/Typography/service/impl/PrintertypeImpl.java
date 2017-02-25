package com.Typography.service.impl;

import com.Typography.entity.printertype;
import com.Typography.service.PrintertypeService;
import com.Typography.utils.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Nikas on 17.01.2017.
 */
public class PrintertypeImpl implements PrintertypeService {
    Session session;
    @Override
    public void add(printertype curr) {
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
        session.persist(new printertype(name));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(printertype curr) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(printertype curr) {

    }

    @Override
    public List<printertype> getAll() {

        session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("from printertype p").list();
    }

    @Override
    public printertype getByPtid(Integer id) {
        return null;
    }

    @Override
    public printertype getByName(String name) {
        return null;
    }
}
