
plugins {
    alias(libs.plugins.androidLibrary)
}

android {
    namespace = "cn.dreamtobe.kpswitch"
    compileSdk = 35

    defaultConfig {
        minSdk = 34
        consumerProguardFile("proguard-rules.pro")
    }
}