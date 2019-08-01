package com.projectone.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.FormParam;
import com.projectone.models.User;

@Path("user")
public class UserController {
	public static User user;


	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey";
	}

	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public int getMovieById(@PathParam("id") int id) {
		return id;
	}

	@POST
	@Path("signup")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String createUser(@FormParam("username") String username, 
            @FormParam("password") String password) {
		return "here";
	}		
}
