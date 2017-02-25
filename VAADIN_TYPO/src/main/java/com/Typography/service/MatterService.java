package com.Typography.service;

import com.Typography.entity.matter;

import java.util.List;

/**
 * Created by Nikas on 17.01.2017.
 */
public interface MatterService {
    void add(matter mt);
    void add(String name);
    void delete(Integer id);
    void delete(matter mt);
    void update(matter mt);
    matter getByMatid(Integer id);
    List<matter> getAll();
    List<matter> getByName(String name);
    List<matter> getByMtid(Integer id);
    List<matter> getByLenght(Integer val);
    List<matter> getByWidth(Integer val);
    List<matter> getByDensity(Integer val);
    List<matter> getByMeid(Integer id);
    List<matter> getByPrice(Double val);
    List<matter> getByCurrid(Integer val);
;}
