/*
 * @(#)User.java 2013-4-10 下午12:51:27 Order
 */
package com.erp.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * User
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class User {

    private Integer id;

    private String name;

    private String password;

    public UserType type;

    @Transient
    public String getTypeName() {
        if (type == UserType.ADMIN) {
            return "管理员";
        } else if (type == UserType.USER) {
            return "普通用户";
        }
        return null;
    }

    /**
     * 返回  id
     * @return id
     */
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    /**
     * 设置 id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 返回  name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回  password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 password
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 返回  type
     * @return type
     */
    @Enumerated(EnumType.STRING)
    public UserType getType() {
        return type;
    }

    /**
     * 设置 type
     * @param type type
     */
    public void setType(UserType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) {
            return false;
        }
        User u = (User) o;
        return this.getId().equals(u.getId());
    }

    @Override
    public int hashCode() {
        return this.getId() * 31;
    }

}
