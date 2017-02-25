package com.Typography.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "mattertype", schema = "typography")

public class mattertype implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mtid")
    private Integer mtid;
    @Column (name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "mtid", cascade = CascadeType.REFRESH)
    private List<matter> matters;

    public mattertype()
    {name="";}

    public mattertype(String n)
    {
        name = n;
    }
    public Integer getMtid(){return mtid;}
    public void setMtid(Integer val) {mtid = val;}
    public String getName(){return name;}
    public void setName(String val){name=val;}
}