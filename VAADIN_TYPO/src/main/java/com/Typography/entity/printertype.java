package com.Typography.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "printertype", schema = "typography")

public class printertype implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ptid")
    private Integer ptid;
    @Column (name = "name")
    private String name;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ptid", cascade = CascadeType.REFRESH)
    private List<digitdevices> digitdevices;

    public printertype()
    {name="";}

    public printertype(String n)
    {
        name = n;
    }
    public Integer getPtid(){return ptid;}
    public void setPtid(Integer val) {ptid = val;}
    public String getName(){return name;}
    public void setName(String val){name=val;}
}