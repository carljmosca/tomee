/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.superbiz.service;

import org.superbiz.service.UserService;
import org.superbiz.model.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserServiceImpl implements UserService {

    @PersistenceContext(unitName = "user")
    private EntityManager manager;

    @Override
    public void add(User user) {
        manager.persist(user);
    }

    @Override
    public User find(int id) {
        return manager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return manager.createQuery("select u from User u").getResultList();
    }

}
