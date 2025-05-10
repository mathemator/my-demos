package ru.mathemator.demo.grpc;

import com.google.inject.Injector;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class GuiceBinder extends AbstractBinder {
    private final Injector injector;

    public GuiceBinder(Injector injector) {
        this.injector = injector;
    }

    @Override
    protected void configure() {
        bindFactory(new Factory<HelloService>() {
            @Override
            public HelloService provide() {
                return injector.getInstance(HelloService.class);
            }

            @Override
            public void dispose(HelloService instance) {}
        }).to(HelloService.class);
    }
}
