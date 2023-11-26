import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.kotlin.native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("com.squareup.sqldelight")
}

kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation(libs.squareup.sqldelight)
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlinx.test)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.squareup.sqldelight.android)
            }
        }

        val iosMain by getting {
            dependencies {
                implementation(libs.squareup.sqldelight.native)
            }
        }

    }
}

android {
    namespace = "com.example.moonflowerproto"
    compileSdk = 34
    defaultConfig {
        minSdk = 23
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

sqldelight {
    database("AppDatabase") {
        packageName = "com.example.moonflowerproto.database"
        sourceFolders = listOf("sqldelight")
    }
}