plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.firebase.crashlytics)
}

android {
    namespace = "com.example.myapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.myapp"
        minSdk = 26
        targetSdk = 36
        versionCode = 100
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.material)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics)
    
    // Retrofit
    implementation(libs.retrofit)

    // Gson Converter
    implementation(libs.converter.gson)
}