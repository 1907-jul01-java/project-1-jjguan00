package projectone;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api/")
public class app extends ResourceConfig {
	public app() {
		packages("projectone");
	}
}
