# ProGuard configuration for TensorFlow Lite and other libraries

# Keep the TensorFlow Lite classes
-keep class org.tensorflow.** { *; }

# Keep all model classes
-keep class com.example.** { *; }

# Keep Retrofit models
-keep class retrofit2.** { *; }
-keep class okhttp3.** { *; }

# Keep GSON classes
-keep class com.google.gson.** { *; }

# Keep the AndroidX classes
-keep class androidx.** { *; }

# Keep any other necessary classes or packages
-keep class * { @com.google.gson.annotations.SerializedName <fields>; }
