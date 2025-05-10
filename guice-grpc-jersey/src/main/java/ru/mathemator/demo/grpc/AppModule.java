package ru.mathemator.demo.grpc;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(HelloService.class).in(Singleton.class);
    }
}