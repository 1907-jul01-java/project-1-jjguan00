package com.projectone.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import com.projectone.models.User;
import com.projectone.models.LogInUser;
import com.projectone.entities.UserDao;
import com.projectone.util.*;

@Path("user")
public class UserController {
	@Context private HttpServletRequest request;
	
	@POST
	@Path("signup")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void	 createUser(User user) {
		ConnectionUtil cu = new ConnectionUtil();
		UserDao start = new UserDao(cu.getConnection());
		start.createUser(user);
	}
	
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User	login(LogInUser userx) {
		System.out.print(userx);
		ConnectionUtil cu = new ConnectionUtil();
		UserDao start = new UserDao(cu.getConnection());
		request.getSession(true);
		return start.login(userx);
	}		

	@GET 
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jerseywqewqeqweqwewqw";
	}
	
	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void getMovieById(int id) {
		System.out.print("here");
	}

}
