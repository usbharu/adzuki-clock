import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "me.adzuki"
version = "1.0-SNAPSHOT"


kotlin {
    jvm {
        jvmToolchain(11)
        withJava()
    }
    sourceSets {
        @Suppress("UNUSED_VARIABLE")
        val jvmMain by getting {
            dependencies {
                implementation(project(":common"))
                implementation(compose.desktop.currentOs)
            }
        }
        @Suppress("UNUSED_VARIABLE")
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "clock"
            packageVersion = "1.0.0"
        }
    }
}
