package com.Typography.service;

import com.Typography.entity.measure;

import java.util.List;

/**
 * Created by Nikas on 17.01.2017.
 */
public interface MeasureService {
    void add(measure curr);
    void add(String name);
    void delete(measure  curr);
    void delete(Integer id);
    void update(measure  curr);
    List<measure> getAll();
    measure getByMeid(Integer id);
    measure  getByName(String name);
}
