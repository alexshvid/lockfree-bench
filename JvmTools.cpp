#include <jni.h>
#include <iostream>
#include <unistd.h>
#include "JvmTools.h"
using namespace std;
 
JNIEXPORT void JNICALL 
Java_JvmTools_usleep(JNIEnv *, jclass, jlong nanoseconds){
    usleep(nanoseconds);
    return;
}
