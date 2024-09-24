plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.gradleVersionsPlugin)
    alias(libs.plugins.androidKsp)
    kotlin("kapt")
    id("kotlin-parcelize")
}

val appVersionCode = 91
val appVersionName = "3.2"
val appVersionSuffix = ""

android {
    namespace = "me.ykrank.s1next"
    compileSdk = 35

    defaultConfig {
        applicationId = "me.ykrank.s1next"
        minSdk = 34
        targetSdk = 35
        versionCode = appVersionCode
        versionName = "${appVersionName}.${appVersionCode}${appVersionSuffix}"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    kotlin {
        jvmToolchain(21)
    }

    buildFeatures {
        dataBinding = true
        buildConfig = true
    }

    packaging {
        resources {
            excludes += "META-INF/LICENSE"
            excludes += "META-INF/LICENSE.txt"
            excludes += "META-INF/NOTICE"
            excludes += "META-INF/NOTICE.txt"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    buildTypes.forEach {
        it.buildConfigField("String", "DB_NAME", "\"s1.db\"")
    }

    flavorDimensions += "market"
    productFlavors {
        create("normal") {
            dimension = "market"
            manifestPlaceholders["APP_CHANNEL"] = "normal"
        }
    }
    androidResources {
        generateLocaleConfig = true
    }
}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}

dependencies {
    implementation(fileTree("libs") { include("*.jar", "*.aar") })

    implementation(project(":library"))
    implementation(project(":JKeyboardPanelSwitch"))

    kapt(libs.databinding.compiler)
    implementation(libs.paging)

    implementation(libs.bugly.nativecrashreport)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    implementation(libs.androidx.transition)

    implementation(libs.okhttp.urlconnection)
    implementation(libs.okhttp.coroutines)
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.adapter.rxjava2)
    implementation(libs.retrofit2.converter.jackson)
    implementation(libs.retrofit2.converter.scalars)

    implementation(libs.jackson.kotlin)
    implementation(libs.jackson.databind)

    implementation(libs.paperparcel)
    implementation(libs.paperparcel.kotlin) // Optional
    implementation(libs.paperparcel.api)
    kapt(libs.paperparcel.compiler)

    ksp(libs.glide.ksp)

    implementation(libs.photoview)
    implementation(libs.quicksidebar)

    //flipper
    implementation(libs.flipper)
    debugImplementation(libs.soloader)
    debugImplementation(libs.flipper.network.plugin)

    implementation(libs.alicloud.android.httpdns)

    //room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.paging)

    implementation(libs.monet)
}
