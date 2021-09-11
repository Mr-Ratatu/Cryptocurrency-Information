plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Configs.compileSdkVersion)

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(project(Projects.base))
    implementation(project(Projects.core_data_network))

    // Base
    implementation(Dependencies.kotlin)
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.swipeRefreshLayout)

    // DI
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerHiltCompiler)

    // Navigation
    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUI)
}