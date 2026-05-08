# This is a configuration file for R8/ProGuard
# (keep this file even if you don't use ProGuard in your configuration)
# References:
# http://proguard.sourceforge.net/index.html#manual/introduction.html
# http://developer.android.com/guide/developing/tools/proguard.html

# For using GSON
-keepattributes Signature
-keepattributes *Annotation*
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }

# For Kotlin
-keep class kotlin.** { *; }
-keep class kotlin.Metadata { *; }
-dontwarn kotlin.**

# For Retrofit
-keepattributes Signature
-keepattributes Exceptions
-keep class retrofit2.** { *; }
-keepclasseswithmembers class * {
    @retrofit2.http.<Method> <methods>;
}

# For Room
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-keep @androidx.room.Dao class *

# For Hilt
-keep class dagger.hilt.android.internal.** { *; }
-keep class hilt_aggregated_deps.** { *; }
-keep class * extends dagger.hilt.android.HiltAndroidApp
-keep class * implements dagger.hilt.internal.IAggregatedRoot { *; }

# For Coroutines
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
-keepnames class kotlinx.coroutines.android.AndroidExceptionPreHandler {}
-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}
