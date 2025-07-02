package ru.mathemator.demo.instrumentation;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class Agent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("[Agent] Starting...");
        inst.addTransformer(new Transformer());
    }

    static class Transformer implements ClassFileTransformer {
        @Override
        public byte[] transform(ClassLoader loader,
                                String className,
                                Class<?> classBeingRedefined,
                                ProtectionDomain protectionDomain,
                                byte[] classfileBuffer) {
            System.out.println("[Agent] Loading class: " + className.replace("/", "."));
            return null; // Не изменяем байт-код
        }
    }
}