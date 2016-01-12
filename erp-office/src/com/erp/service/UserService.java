/*
 * @(#)UserService.java 2013-4-10 обнГ12:51:33 Order
 */
package com.erp.service;

import java.util.List;

import com.erp.model.User;
import com.erp.model.UserType;

/**
 * UserService
 * @author wang
 * @version 1.0
 *
 */
public interface UserService extends BaseService<User> {
    User login(User user);

    void regUser(User user);

    List<User> list(UserType type);
}
