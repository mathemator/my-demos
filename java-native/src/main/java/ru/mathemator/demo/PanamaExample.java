package ru.mathemator.demo;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;


public class PanamaExample {
    public static void main(String[] args) throws Throwable {.
        try (Arena arena = Arena.ofConfined()) {
            Linker linker = Linker.nativeLinker();

            SymbolLookup stdlib = Linker.nativeLinker().defaultLookup();

            MethodHandle strlen = linker.downcallHandle(
                    stdlib.find("strlen").orElseThrow(),
                    FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS)
            );

            MemorySegment cString = arena.allocateFrom("Привет, Бублик!");
            long length = (long) strlen.invokeExact(cString);
            System.out.println("Длина строки: " + length);
        }
    }
}
