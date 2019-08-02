package com.projectone.controllers;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.projectone.models.Reimbursement;
import com.projectone.models.User;
import com.projectone.entities.UserDao;
import com.projectone.util.*;
import com.projectone.entities.ReimbursementDao;

@Path("reimbursement")
public class ReimbursementController {
	
	@POST
	@Path("request")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void createRequest(Reimbursement reimbursement) {
		ConnectionUtil cu = new ConnectionUtil();
		ReimbursementDao start = new ReimbursementDao(cu.getConnection());
		start.submitrequest(reimbursement);
		cu.close();
	}
	
	@GET
	@Path("getall")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Reimbursement> getAll() {
		ConnectionUtil cu = new ConnectionUtil();
		ReimbursementDao start = new ReimbursementDao(cu.getConnection());
		return start.getAll();
	}
	
	@GET
	@Path("deny/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deny(@PathParam("id") int id) {
		ConnectionUtil cu = new ConnectionUtil();
		ReimbursementDao start = new ReimbursementDao(cu.getConnection());
		start.deny(id);
		cu.close();
	}
	
	@GET
	@Path("approve/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void approve(@PathParam("id") int id) {
		ConnectionUtil cu = new ConnectionUtil();
		ReimbursementDao start = new ReimbursementDao(cu.getConnection());
		start.approve(id);
		cu.close();
	}
	
	@GET
	@Path("destroy/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void destroy(@PathParam("id") int id) {
		ConnectionUtil cu = new ConnectionUtil();
		ReimbursementDao start = new ReimbursementDao(cu.getConnection());
		start.destroy(id);
		cu.close();
	}
	
	@GET
	@Path("getbyuser/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Reimbursement> getbyuser(@PathParam("username") String username) {
		ConnectionUtil cu = new ConnectionUtil();
		ReimbursementDao start = new ReimbursementDao(cu.getConnection());
		return start.getbyuser(username);
	}

}
