package com.Typography.service;

import com.Typography.entity.densityprice;

import java.util.List;

/**
 * Created by Nikas on 17.01.2017.
 */
public interface DensitypriceService {
    void add(densityprice dp);
    void delete(densityprice  dp);
    void delete(Integer id);
    void update(densityprice  dp);
    List<densityprice> getAll();
    densityprice getByDpid(Integer id);
    List<densityprice> getByDdid(String name);
    List<densityprice> getByDensity(Integer dens);
    List<densityprice> getByColid(Integer id);
    List<densityprice> getByPrice(Double price);
    List<densityprice> getByCurrid(Integer id);
}
