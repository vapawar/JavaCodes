package org.vpz.webs.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/{test}")
public class JerseyServer {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String showData() {
        return "<html><body><h1>Hello Jersey.</h2></body></html>";
    }
}
