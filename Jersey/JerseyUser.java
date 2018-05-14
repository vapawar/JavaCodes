package org.vpz.webs.jersey;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

public class JerseyUser {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient(new ClientConfig().register(""));
        WebTarget target = client.target("http://localhost:8180/JerseyCookies/").path("getdata");
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        String data = response.readEntity(String.class);
        System.out.println(response.getCookies());
        System.out.println(data);
    }
}
