package com.Typography.service.impl;

import com.Typography.entity.digitdevices;
import com.Typography.service.DigitdevicesService;
import com.Typography.utils.HibernateSessionFactory;
import org.hibernate.Session;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Nikas on 17.01.2017.
 */
public class DigitdevicesImpl implements DigitdevicesService {
    Session session;
    @Override
    public void add(digitdevices dd) {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.persist(dd);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(String name) {

    }

    @Override
    public void delete(digitdevices dd) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(digitdevices dd) {

    }

    @Override
    public digitdevices getByDdid(Integer id) {
        return null;
    }

    @Override
    public List<digitdevices> getAll() {
        session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery("from digitdevices d").list();
    }

    @Override
    public List<digitdevices> getByName(String name) {
        return null;
    }

    @Override
    public List<digitdevices> getByPtid(Integer id) {
        return null;
    }

    @Override
    public List<digitdevices> getByFinalcount(Integer val) {
        return null;
    }

    @Override
    public List<digitdevices> getByTotalcount(Integer val) {
        return null;
    }

    @Override
    public List<digitdevices> getByTotalprice(Double val) {
        return null;
    }

    @Override
    public List<digitdevices> getByCurrid(Integer id) {
        return null;
    }

    @Override
    public List<digitdevices> getByAmort(Integer val) {
        return null;
    }

    @Override
    public List<digitdevices> getByCreationtime(Timestamp val) {
        return null;
    }

    @Override
    public List<digitdevices> getByPricingmethod(Short val) {
        return null;
    }
}
