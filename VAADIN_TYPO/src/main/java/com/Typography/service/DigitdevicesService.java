package com.Typography.service;

import com.Typography.entity.digitdevices;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Nikas on 17.01.2017.
 */
public interface DigitdevicesService {
    void add(digitdevices dd);
    void add(String name);
    void delete(digitdevices dd);
    void delete(Integer id);
    void update(digitdevices dd);
    digitdevices getByDdid(Integer id);
    List<digitdevices> getAll();
    List<digitdevices> getByName(String name);
    List<digitdevices> getByPtid(Integer id);
    List<digitdevices> getByFinalcount(Integer val);
    List<digitdevices> getByTotalcount(Integer val);
    List<digitdevices> getByTotalprice(Double val);
    List<digitdevices> getByCurrid(Integer id);
    List<digitdevices> getByAmort(Integer val);
    List<digitdevices> getByCreationtime(Timestamp val);
    List<digitdevices> getByPricingmethod(Short val);
}
