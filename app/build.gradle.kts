@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.kotlin.plugin)
    alias(libs.plugins.hilt.gradle)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.luna.marvel"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.luna.marvel"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    externalNativeBuild {
        ndkBuild {
            path("src/main/jni/Android.mk")
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":usecases"))
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    debugImplementation(libs.ui.tooling)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.compose.navigation)
    implementation(libs.constraint.layout)
    implementation(libs.coil.compose)

    implementation(libs.retrofit.gson)
    implementation(libs.retrofit)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.okhttp.client)
    implementation(libs.arrow.core)

//    Room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    //noinspection KaptUsageInsteadOfKsp
    kapt(libs.room.compiler)

    implementation(libs.hilt.android)
    implementation(libs.hilt.nav.compose)
    kapt(libs.hilt.compiler)

    //    TESTING
    testImplementation(project(":testShared"))
    testImplementation(libs.junit)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.mockito.inline)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.turbine)
    testImplementation(libs.truth)

    androidTestImplementation(libs.junit.ktx)
    androidTestImplementation(libs.espresso.contrib)
    androidTestImplementation(libs.runner)
    androidTestImplementation(libs.rules)
    androidTestImplementation(libs.hilt.test)
    androidTestImplementation(libs.coroutines.test)
    androidTestImplementation(libs.mock.web.server)

    kaptAndroidTest(libs.hilt.compiler)

}