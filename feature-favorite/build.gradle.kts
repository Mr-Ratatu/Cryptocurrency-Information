plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
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

    implementation(Dependencies.kotlin)
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)

    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerHiltCompiler)

    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUI)
}