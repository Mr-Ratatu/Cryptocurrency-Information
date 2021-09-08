plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Configs.compileSdkVersion)

    buildToolsVersion = Configs.buildToolsVersion

    defaultConfig {
        minSdkVersion(Configs.minSdkVersion)
        targetSdkVersion(Configs.targetSdkVersion)
        versionCode = Configs.versionCode
        versionName = Configs.versionName

        testInstrumentationRunner = Configs.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        dataBinding = true
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
}

dependencies {

    //Base
    implementation(Dependencies.kotlin)
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)

    implementation(Dependencies.lifecycle)

    //Kotlin Coroutines
    implementation(Dependencies.coroutinesAndroid)
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.lifecycleRuntime)

    // Coil
    implementation(Dependencies.coil)
}