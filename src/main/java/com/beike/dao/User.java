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
 * Created by huahui.yang on 3/22/15.
 */
@Entity
@Table(name = "user")
public class User implements Serializable{

    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private int emailVerify;
    private int phoneVerify;
    private Date createTime;
    private Date updateTime;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.updateTime = new Date(System.currentTimeMillis());
    }

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name="email_verify")
    public int getEmailVerify() {
        return emailVerify;
    }

    public void setEmailVerify(int emailVerify) {
        this.emailVerify = emailVerify;
    }

    @Column(name="phone_verify")
    public int getPhoneVerify() {
        return phoneVerify;
    }

    public void setPhoneVerify(int phoneVerify) {
        this.phoneVerify = phoneVerify;
    }

    @Column(name="create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name="update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
