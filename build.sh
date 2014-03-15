INC=/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.8.sdk/System/Library/Frameworks/JavaVM.framework/Versions/A/Headers/

g++ "-I$INC" -c JvmTools.cpp
g++ -dynamiclib -o libjvmtools.jnilib JvmTools.o


