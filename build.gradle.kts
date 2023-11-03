plugins {
    alias(libs.plugins.com.android.application).apply(false)
    alias(libs.plugins.kotlin.plugin).apply(false)
    alias(libs.plugins.kotlin.kapt).apply(false)
    alias(libs.plugins.hilt.gradle).apply(false)
    alias(libs.plugins.kotlin.jvm.gradle) apply false
}