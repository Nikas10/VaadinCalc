package com.Typography.entity;

import org.hibernate.annotations.*;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "currency", schema = "typography")

public class currency implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currid")
    private Integer currid;
    @Column (name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "currmt", cascade = CascadeType.REFRESH)
    private List<matter> matters;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "currdp", cascade = CascadeType.REFRESH)
    private List<densityprice> densityprices;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "currdd", cascade = CascadeType.REFRESH)
    private List<digitdevices> digitdevices;

    public currency(){}

    public currency(String n)
    {
        name = n;
    }
    public Integer getCurrid(){return currid;}
    public void setCurrid(Integer val) {currid = val;}
    public String getName(){return name;}
    public void setName(String val){name=val;}
}