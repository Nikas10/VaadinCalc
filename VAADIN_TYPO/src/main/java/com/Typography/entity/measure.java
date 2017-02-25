package com.Typography.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "measure", schema = "typography")

public class measure implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meid")
    private Integer meid;
    @Column (name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "meid", cascade = CascadeType.REFRESH)
    private List<matter> matters;

    public measure()
    {name="";}

    public measure(String n)
    {
        name = n;
    }
    public Integer getMeid(){return meid;}
    public void setMeid(Integer val) {meid = val;}
    public String getName(){return name;}
    public void setName(String val){name=val;}
}