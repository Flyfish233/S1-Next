plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    kotlin("kapt")
}

android {
    namespace = "com.github.ykrank.androidtools"
    compileSdk = 35

    defaultConfig {
        minSdk = 34

        vectorDrawables {
            useSupportLibrary = true
        }

        consumerProguardFile("proguard-rules.pro")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
    buildFeatures {
        dataBinding = true
        buildConfig = true
    }

    flavorDimensions += "market"
    productFlavors {
        create("play") {
            dimension = "market"
        }
        create("normal") {
            dimension = "market"
        }
    }
}

val normalApi by configurations
val playApi by configurations
dependencies {
    normalApi(fileTree("libs/normal") { include("*.jar", "*.aar") })
    playApi(fileTree("libs/play") { include("*.jar", "*.aar") })
    api(fileTree("libs/common") { include("*.jar", "*.aar") })

    kapt(libs.databinding.compiler)

    implementation(libs.jackson.kotlin)
    api(libs.material)
    api(libs.androidx.activity.ktx)
    api(libs.androidx.cardview)
    api(libs.androidx.percentlayout)
    api(libs.androidx.preference)
    api(libs.androidx.lifecycle.livedata.ktx)
    api(libs.androidx.constraintlayout)

    api(libs.androidx.multidex)

    debugApi(libs.leakcanary.android)
    releaseApi(libs.leakcanary.android.no.op)
    api(libs.guava)

    api(libs.rxjava)
    api(libs.rxandroid)
    api(libs.rxkotlin)

    api(libs.glide)
    api(libs.glide.okhttp3.integration)
    api(libs.okhttp)

    api(libs.androidautodispose)
    api(libs.adapterdelegates3)

    api(libs.bugly.crashreport)

    api(libs.logger)

    //PictureUpload
    api(libs.jsoup)
    api(libs.retrofit2)
    api(libs.retrofit2.adapter.rxjava2)
    api(libs.retrofit2.converter.jackson)
    api(libs.retrofit2.converter.scalars)

    api(libs.largeimageview)

    implementation(libs.paperparcel)
    implementation(libs.paperparcel.kotlin) // Optional
    implementation(libs.paperparcel.api)
    kapt(libs.paperparcel.compiler)

    implementation(libs.monet)
}
