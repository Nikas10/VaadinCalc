package com.Typography.service;

import com.Typography.entity.mattertype;

import java.util.List;

/**
 * Created by Nikas on 17.01.2017.
 */
public interface MattertypeService {
    void add(mattertype curr);
    void add(String name);
    void delete(mattertype  curr);
    void delete(Integer id);
    void update(mattertype  curr);
    List<mattertype > getAll();
    mattertype getByMtid(Integer id);
    mattertype  getByName(String name);
}
