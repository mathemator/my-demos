#include <jni.h>
#include <stdio.h>
#include "ru_mathemator_demo_NativeExample.h"

JNIEXPORT void JNICALL Java_ru_mathemator_demo_NativeExample_sayHelloFromC(JNIEnv *env, jobject thisObj) {
    printf("Привет из C! 🧠🧊\n");
}