plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("io.realm.kotlin")
    xcode
}

kotlin {
    android()
    ios()
    iosSimulatorArm64()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    ios {
        binaries.framework {
            baseName = "shared"
        }
        binaries {
            executable {
                entryPoint = "main"
                freeCompilerArgs += listOf(
                    "-linker-option", "-framework", "-linker-option", "Metal",
                    "-linker-option", "-framework", "-linker-option", "CoreText",
                    "-linker-option", "-framework", "-linker-option", "CoreFoundation",
                    "-linker-option", "-framework", "-linker-option", "CoreGraphics"
                )
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation("io.realm.kotlin:library-sync:1.11.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.realmtests.kmmrealmissue"
    compileSdk = 33
    defaultConfig {
        minSdk = 26
    }
}