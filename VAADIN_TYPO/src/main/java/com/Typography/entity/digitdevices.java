package com.Typography.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "digitdevices", schema = "typography")

public class digitdevices implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ddid")
    private Integer ddid;
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ptid", nullable = true)
    private printertype ptid;

    @Column(name = "finalcount")
    private Integer finalcount;
    @Column(name = "totalcount")
    private Integer totalcount;
    @Column(name = "totalprice")
    private Double totalprice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "colid", nullable = true)
    private currency currdd;

    @Column(name = "amortisationperiod")
    private Integer amort;
    @Column(name = "creationtime")
    private Timestamp creationtime;
    @Column(name = "pricingmethod")
    private Short pricingmethod;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "ddid", cascade = CascadeType.REFRESH)
    private List<densityprice> densityprices;


    public digitdevices(){}

    public Integer getDdid() {
        return ddid;
    }

    public void setDdid(Integer dpid) {
        this.ddid = dpid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public printertype getPtid() {
        return ptid;
    }

    public void setPtid(printertype ptid) {
        this.ptid = ptid;
    }

    public Integer getFinalcount() {
        return finalcount;
    }

    public void setFinalcount(Integer finalcount) {
        this.finalcount = finalcount;
    }

    public Integer getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(Integer totalcount) {
        this.totalcount = totalcount;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public currency getCurrdd() {
        return currdd;
    }

    public void setCurrdd(currency currdd) {
        this.currdd = currdd;
    }

    public Integer getAmort() {
        return amort;
    }

    public void setAmort(Integer amort) {
        this.amort = amort;
    }

    public Timestamp getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Timestamp creationtime) {
        this.creationtime = creationtime;
    }

    public Short getPricingmethod() {
        return pricingmethod;
    }

    public void setPricingmethod(Short pricingmethod) {
        this.pricingmethod = pricingmethod;
    }
}