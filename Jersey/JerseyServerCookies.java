package org.vpz.webs.jersey;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/{getData}")
public class JerseyServerCookies {
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData() {
        ArrayList data = new ArrayList<>();
        data.add("w23687edyh");
        data.add("w23687e43fddyh");
        data.add("w2368437edyh");
        data.add("w23687edyt34t3h");
        return Response.ok().entity(data).cookie(new NewCookie("cookies", "1234")).build();
    }
}
