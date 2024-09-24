pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://maven.aliyun.com/nexus/content/repositories/releases/") {
            content {
                includeGroup("com.aliyun.ams") //https://mvnrepository.com/artifact/com.aliyun.ams/alicloud-android-httpdns/1.1.9

            }
        }
        maven("https://maven.aliyun.com/repository/jcenter") {
            content {
                includeGroup("com.shizhefei") //https://mvnrepository.com/artifact/com.shizhefei/LargeImageView/1.1.0
                includeGroup("com.bigkoo") //https://mvnrepository.com/artifact/com.bigkoo/quicksidebar/1.0.3
            }
        }
    }
}

plugins {
    id("de.fayard.refreshVersions") version "0.60.5"
}

rootProject.name = "S1-Next"
include(":app")
include(":library")
include(":JKeyboardPanelSwitch")