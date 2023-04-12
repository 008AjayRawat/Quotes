plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    compileSdk = ConfigData.compileSDKVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.junitAndroid)
    androidTestImplementation(Dependencies.espressoAndroid)

    //Core UI
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)

    //Lifecycle aware component
    implementation(Dependencies.lifecycle)
    implementation(Dependencies.lifecycleKapt)
    implementation(Dependencies.liveData)
    implementation(Dependencies.viewModel)

    //Dependency Injection-  Dagger
    implementation(Dependencies.dagger)
    kapt(Dependencies.daggerKapt)

}