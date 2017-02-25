package com.Typography.service;

import com.Typography.entity.currency;

import java.util.List;

/**
 * Created by Nikas on 17.01.2017.
 */
public interface CurrencyService {
    void add(currency curr);
    void add(String name);
    void delete(currency curr);
    void delete(Integer id);
    void update(currency curr);
    List<currency> getAll();
    currency getByCurrid(Integer id);
    currency getByName(String name);
}
