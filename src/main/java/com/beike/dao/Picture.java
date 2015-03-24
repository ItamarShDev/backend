package com.beike.dao;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by CJL on 2015/3/24.
 */
@Entity
@Table(name = "picture")
public class Picture {

    private Integer id;
    private String name;
    private Byte[] metadata;
    private String originalurl;
    private String cdnurl;
    private Integer originaluser;
    private Date time;
    private String type;

    public Picture() {
    }

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="metadata")
    public Byte[] getMetadata() {
        return metadata;
    }

    public void setMetadata(Byte[] metadata) {
        this.metadata = metadata;
    }

    @Column(name="originalurl")
    public String getOriginalurl() {
        return originalurl;
    }

    public void setOriginalurl(String originalurl) {
        this.originalurl = originalurl;
    }

    @Column(name="cdnurl")
    public String getCdnurl() {
        return cdnurl;
    }

    public void setCdnurl(String cdnurl) {
        this.cdnurl = cdnurl;
    }

    @Column(name="originaluser")
    public Integer getOriginaluser() {
        return originaluser;
    }

    public void setOriginaluser(Integer originaluser) {
        this.originaluser = originaluser;
    }

    @Column(name="time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Column(name="type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
