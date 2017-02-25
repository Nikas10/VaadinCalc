package com.Typography.service.impl;

import com.Typography.entity.densityprice;
import com.Typography.service.DensitypriceService;
import com.Typography.utils.HibernateSessionFactory;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Nikas on 17.01.2017.
 */
public class DensitypriceImpl implements DensitypriceService {
    Session session;
    @Override
    public void add(densityprice dp) {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(dp);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(densityprice dp) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(densityprice dp) {

    }

    @Override
    public List<densityprice> getAll() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("from densityprice d").list();
    }

    @Override
    public densityprice getByDpid(Integer id) {
        return null;
    }

    @Override
    public List<densityprice> getByDdid(String name) {
        return null;
    }

    @Override
    public List<densityprice> getByDensity(Integer dens) {
        return null;
    }

    @Override
    public List<densityprice> getByColid(Integer id) {
        return null;
    }

    @Override
    public List<densityprice> getByPrice(Double price) {
        return null;
    }

    @Override
    public List<densityprice> getByCurrid(Integer id) {
        return null;
    }
}
