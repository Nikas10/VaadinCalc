package com.Typography.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "matter", schema = "typography")

public class matter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matid")
    private Integer matid;
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mtid", nullable = true)
    private mattertype mtid;

    @Column(name = "lenght")
    private Integer lenght;

    @Column(name = "width")
    private Integer width;

    @Column(name = "density")
    private Integer density;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "meid", nullable = true)
    private measure meid;

    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currid", nullable = true)
    private currency currmt;
    public matter(){}

    public Integer getMatid() {
        return matid;
    }

    public void setMatid(Integer matid) {
        this.matid = matid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public mattertype getMtid() {
        return mtid;
    }

    public void setMtid(mattertype mtid) {
        this.mtid = mtid;
    }

    public Integer getLenght() {
        return lenght;
    }

    public void setLenght(Integer lenght) {
        this.lenght = lenght;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getDensity() {
        return density;
    }

    public void setDensity(Integer density) {
        this.density = density;
    }

    public measure getMeid() {
        return meid;
    }

    public void setMeid(measure meid) {
        this.meid = meid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public currency getCurrmt() {
        return currmt;
    }

    public void setCurrmt(currency currmt) {
        this.currmt = currmt;
    }

}