package com.Typography.service;

import com.Typography.entity.color;

import java.util.List;

/**
 * Created by Nikas on 17.01.2017.
 */
public interface ColorService {
    void add(color newcolor);
    void add(String name);
    void delete(Integer id);
    void delete(color newcolor);
    void update(color newcolor);
    color getByColid(Integer id);
    color getByName(String name);
    List<color> getAll();

}
