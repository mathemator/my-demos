package ru.mathemator.demo.grpc;


import io.grpc.stub.StreamObserver;
import jakarta.inject.Inject;


public class GrpcService extends HelloGrpcGrpc.HelloGrpcImplBase {

    private final HelloService helloService;

    @Inject
    public GrpcService(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String message = helloService.sayHello(request.getName());
        HelloResponse response = HelloResponse.newBuilder()
                .setMessage(message)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}