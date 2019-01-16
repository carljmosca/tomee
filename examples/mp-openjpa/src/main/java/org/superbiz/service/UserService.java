/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.superbiz.service;

import org.superbiz.model.User;
import java.util.List;

public interface UserService {

    public void add(User user);

    public User find(int id);

    public List<User> findAll();
}
