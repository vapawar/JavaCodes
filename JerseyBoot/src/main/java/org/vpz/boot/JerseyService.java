package org.vpz.boot;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

@Service
@Path("/test")
public class JerseyService {

	@GET
	@Path("/test2")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage() {
		return "Hello Jersey boot";
	}
}
