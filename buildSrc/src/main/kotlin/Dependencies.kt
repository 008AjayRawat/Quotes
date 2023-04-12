object Dependencies {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtxVersion}" }

    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompatVersion}" }
    val material by lazy { "com.google.android.material:material:${Versions.materialDesignVersion}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }

    val composeMaterial3 by lazy { "androidx.compose.material3:material3" }
    val composePreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val composePreviewDebug by lazy { "androidx.compose.ui:ui-tooling" }
    val composeNavigationComponent by lazy { "androidx.navigation:navigation-compose:${Versions.composeNavigationVersion}" }

    val lifecycle by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}" }
    val lifecycleKapt by lazy { "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycleVersion}" }
    val liveData by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}" }
    val viewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}" }

    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}" }
    val navigationUi by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}" }

    val room by lazy { "androidx.room:room-runtime:${Versions.roomVersion}" }
    val roomKapt by lazy { "androidx.room:room-compiler:${Versions.roomVersion}" }
    val roomKtx by lazy { "androidx.room:room-ktx:${Versions.roomVersion}" }

    val dagger by lazy { "com.google.dagger:dagger:${Versions.daggerVersion}" }
    val daggerKapt by lazy { "com.google.dagger:dagger-compiler:${Versions.daggerVersion}" }

    val coroutineAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineVersion}" }
    val coroutineCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineVersion}" }

    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}" }
    val retrofitConverterGson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}" }
    val gson by lazy { "com.google.code.gson:gson:${Versions.gson}" }

    //A lightweight sealed API library for modeling Retrofit response and handling exception.
    val sandwich by lazy { "com.github.skydoves:sandwich:1.3.0" }

    val workManager by lazy { "androidx.work:work-runtime-ktx:${Versions.workManagerVersion}" }

    val glide by lazy { "com.github.bumptech.glide:glide:${Versions.glideVersion}" }
    val glideKapt by lazy { "com.github.bumptech.glide:compiler:${Versions.glideVersion}" }

    val junit by lazy { "junit:junit:${Versions.junitVersion}" }
    val junitAndroid by lazy { "androidx.test.ext:junit:${Versions.junitAndroidVersion}" }

    val espressoAndroid by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoAndroidVersion}" }
}
