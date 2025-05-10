package ru.mathemator.demo.grpc;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public class RestController {

    @Inject
    private HelloService helloService;

    @GET
    public Response sayHello(@QueryParam("name") String name) {
        return Response.ok(helloService.sayHello(name)).build();
    }
}