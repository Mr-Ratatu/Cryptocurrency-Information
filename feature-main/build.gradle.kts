plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(Configs.compileSdkVersion)

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(project(Projects.base))
    implementation(project(Projects.feature_currency))
    implementation(project(Projects.feature_converter))
    implementation(project(Projects.feature_favorite))

    implementation(Dependencies.kotlin)
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)

    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUI)
}