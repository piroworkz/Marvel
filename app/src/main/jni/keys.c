#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_luna_marvel_app_di_AppModule_getBaseUrl(JNIEnv *env, jobject instance) {
    return (*env)->NewStringUTF(env, "http://gateway.marvel.com/v1/public/");
}

JNIEXPORT jstring JNICALL
Java_com_luna_marvel_app_di_AppModule_getPublicKey(JNIEnv *env, jobject instance) {
    return (*env)->NewStringUTF(env, "YOUR_PUBLIC_KEY");
}

JNIEXPORT jstring JNICALL
Java_com_luna_marvel_app_di_AppModule_getPrivateKey(JNIEnv *env, jobject instance) {
    return (*env)->NewStringUTF(env, "YOUR_PUBLIC_KEY");
}

