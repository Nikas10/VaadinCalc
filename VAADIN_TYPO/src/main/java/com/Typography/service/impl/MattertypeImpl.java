package com.Typography.service.impl;

import com.Typography.entity.matter;
import com.Typography.entity.mattertype;
import com.Typography.service.MattertypeService;
import com.Typography.utils.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Nikas on 17.01.2017.
 */
public class MattertypeImpl implements MattertypeService {
    Session session;
    @Override
    public void add(mattertype curr) {
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
        session.persist(new mattertype(name));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(mattertype curr) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(mattertype curr) {

    }

    @Override
    public List<mattertype> getAll() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("from mattertype m").list();
    }

    @Override
    public mattertype getByMtid(Integer id) {
        return null;
    }

    @Override
    public mattertype getByName(String name) {
        return null;
    }
}
