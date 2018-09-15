#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_me_myapplication_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */,
        jint countNum) {
    std::string newCount = std::to_string(countNum + 1);
    return env->NewStringUTF(newCount.c_str());
}
