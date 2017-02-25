package com.Typography.entity;


import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "color", schema = "typography")

public class color implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "colid")
    private Integer colid;
    @Column (name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "colid", cascade = CascadeType.REFRESH)
    private List<densityprice> densityprices;

    public color()
    {name="";}

    public color(String n)
    {
        name = n;
    }
    public Integer getColid(){return colid;}
    public void setColid(Integer val) {colid = val;}
    public String getName(){return name;}
    public void setName(String val){name=val;}
}