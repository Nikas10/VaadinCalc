package com.Typography.service;

import com.Typography.entity.printertype;

import java.util.List;

/**
 * Created by Nikas on 17.01.2017.
 */
public interface PrintertypeService {
    void add(printertype curr);
    void add(String name);
    void delete(printertype  curr);
    void delete(Integer id);
    void update(printertype  curr);
    List<printertype> getAll();
    printertype getByPtid(Integer id);
    printertype getByName(String name);
}
