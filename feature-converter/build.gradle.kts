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
    implementation(project(Projects.core_data_network))

    implementation(Dependencies.kotlin)
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.swipeRefreshLayout)

    implementation(Dependencies.daggerHilt)

    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUI)
}