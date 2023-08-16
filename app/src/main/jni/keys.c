#include <jni.h>

JNIEXPORT jstring
JNICALL
Java_com_luna_marvel_app_di_AppModule_getPublicKey(JNIEnv *env, jobject thiz) {
    return (*env)->NewStringUTF(env, "ed9dd6272880a478484c6af82cf068a8");
}

JNIEXPORT jstring
JNICALL
Java_com_luna_marvel_app_di_AppModule_getPrivateKey(JNIEnv *env, jobject thiz) {
    return (*env)->NewStringUTF(env, "9bf677835698148cbec314e2e073e61653dc20ea");
}


JNIEXPORT jstring
JNICALL
Java_com_luna_marvel_app_di_AppModule_getBaseUrl(JNIEnv *env, jobject thiz) {
    return (*env)->NewStringUTF(env, "https://gateway.marvel.com/v1/public/");
}