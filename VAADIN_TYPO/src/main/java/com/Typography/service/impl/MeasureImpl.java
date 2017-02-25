package com.Typography.service.impl;

import com.Typography.entity.measure;
import com.Typography.service.MeasureService;
import com.Typography.utils.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Nikas on 17.01.2017.
 */
public class MeasureImpl implements MeasureService {
    Session session;
    @Override
    public void add(measure curr) {
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
        session.persist(new measure(name));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(measure curr) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(measure curr) {

    }

    @Override
    public List<measure> getAll() {

        session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("from measure m").list();
    }

    @Override
    public measure getByMeid(Integer id) {
        return null;
    }

    @Override
    public measure getByName(String name) {
        return null;
    }
}
