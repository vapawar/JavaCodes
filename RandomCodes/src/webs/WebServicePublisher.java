package webs;

import javax.xml.ws.Endpoint;

public class WebServicePublisher {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Endpoint endpoint = Endpoint.publish("http://localhost:8086/webs/test2", new DataOperationsIMPL());
    }
}
