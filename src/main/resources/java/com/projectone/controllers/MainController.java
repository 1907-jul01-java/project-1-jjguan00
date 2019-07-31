package com.projectone.controllers;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api/")
public class MainController extends ResourceConfig {
	public MainController() {
		packages("com.projectone.controllers");
	}
}