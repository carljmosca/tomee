/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.superbiz.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.eclipse.microprofile.metrics.annotation.Counted;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public interface UserController {

    @Counted(monotonic = true, name = "users", absolute = true,
            displayName = "Weather Day Status",
            description = "This metric shows the weather status of the day.")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers();

    @GET @Path("/{id}") 
    @Counted(monotonic = true, name = "user", absolute = true,
            displayName = "Weather Day Status",
            description = "This metric shows the weather status of the day.")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser (@Context UriInfo info, @PathParam("id") int id);

}
