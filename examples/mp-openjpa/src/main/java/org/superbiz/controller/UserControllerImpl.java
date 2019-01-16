/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.superbiz.controller;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.superbiz.model.User;
import org.superbiz.service.UserService;

public class UserControllerImpl implements UserController {

    @Inject
    UserService userService;

    @Override
    public Response getUsers() {
        List<User> users = userService.findAll();
        JSONObject obj = new JSONObject();
        try {
            obj.put("Users", users);
        } catch (Exception je) {
            return Response.status(Status.EXPECTATION_FAILED).entity(je.getMessage()).type(MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Status.OK).entity(obj).type(MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response getUser() {
        return "Hi, week will be mostly sunny!";
    }

}
