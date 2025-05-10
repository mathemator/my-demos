package ru.mathemator.demo.grpc;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {
    public static void main(String[] args) throws Exception {
        Injector injector = Guice.createInjector(new AppModule());

        // Start REST (Jersey)
        ResourceConfig config = new ResourceConfig()
                .register(RestController.class)
                .register(new GuiceBinder(injector));
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
                URI.create("http://localhost:8080/api/"), config);
        System.out.println("REST started on http://localhost:8080/api/hello");

        // Start gRPC
        GrpcService grpcService = injector.getInstance(GrpcService.class);
        Server grpcServer = ServerBuilder.forPort(9090)
                .addService(grpcService)
                .build()
                .start();
        System.out.println("gRPC started on port 9090");

        server.start();
        grpcServer.awaitTermination();
    }
}