package com.Typography.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "densityprice", schema = "typography")

public class densityprice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dpid")
    private Integer dpid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ddid", nullable = true)
    private digitdevices ddid;

    @Column(name = "density")
    private Integer density;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "colid", nullable = true)
    private color colid;

    @Column(name = "price")
    private Double price;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currid", nullable = true)
    private currency currdp;

    public densityprice() {}

    public digitdevices getDdid() {
        return ddid;
    }

    public void setDdid(digitdevices ddid) {
        this.ddid = ddid;
    }

    public Integer getDensity() {
        return density;
    }

    public void setDensity(Integer density) {
        this.density = density;
    }

    public color getColid() {
        return colid;
    }

    public void setColid(color colid) {
        this.colid = colid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDpid() {
        return dpid;
    }

    public void setDpid(Integer dpid) {
        this.dpid = dpid;
    }

    public currency getCurrdp() {
        return currdp;
    }

    public void setCurrdp(currency currdp) {
        this.currdp = currdp;
    }

}