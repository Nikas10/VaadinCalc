package com.Typography.service.impl;

import com.Typography.entity.matter;
import com.Typography.service.MatterService;
import com.Typography.utils.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Nikas on 17.01.2017.
 */
public class MatterImpl implements MatterService {
    Session session;
    @Override
    public void add(matter mt) {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(mt);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(String name) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void delete(matter mt) {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(mt);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(matter mt) {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(mt);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public matter getByMatid(Integer id) {
        return null;
    }

    @Override
    public List<matter> getAll() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("from matter m").list();
    }

    @Override
    public List<matter> getByName(String name) {
        return null;
    }

    @Override
    public List<matter> getByMtid(Integer id) {
        return null;
    }

    @Override
    public List<matter> getByLenght(Integer val) {
        return null;
    }

    @Override
    public List<matter> getByWidth(Integer val) {
        return null;
    }

    @Override
    public List<matter> getByDensity(Integer val) {
        return null;
    }

    @Override
    public List<matter> getByMeid(Integer id) {
        return null;
    }

    @Override
    public List<matter> getByPrice(Double val) {
        return null;
    }

    @Override
    public List<matter> getByCurrid(Integer val) {
        return null;
    }
}
