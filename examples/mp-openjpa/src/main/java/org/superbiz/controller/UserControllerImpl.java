/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.superbiz.controller;

import java.util.List;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import org.superbiz.model.User;
import org.superbiz.service.UserService;

public class UserControllerImpl implements UserController {

    @Inject
    UserService userService;

    @Override
    public Response getUsers() {
        List<User> users = userService.findAll();
        
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (User user : users) {
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            objectBuilder.add("firstName", user.getFirstName())
                    .add("lastName", user.getLastName())
                    .add("id", user.getId());
            arrayBuilder.add(objectBuilder.build());
        }

        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("Users", arrayBuilder);
        return Response.status(Status.OK).entity(objectBuilder.build()).type(MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response getUser(UriInfo info, int id) {
        User user = userService.find(id);
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder()
                .add("firstName", user.getFirstName())
                .add("lastName", user.getLastName())
                .add("id", user.getId());
        return Response.status(Status.OK).entity(objectBuilder.build()).type(MediaType.APPLICATION_JSON).build();
    }

}
