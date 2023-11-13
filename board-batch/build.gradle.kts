import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks
bootJar.enabled = true
bootJar.mainClass.set("me.dolphago.BoardBatchApplicationKt")
bootJar.manifest {
    attributes(
        mapOf(
            "Implementation-Title" to project.name,
            "Implementation-Version" to project.version
        )
    )
}

jar.enabled = true

ext.set("mainClassName", "me.dolphago.BoardBatchApplicationKt")

apply<JibConfigPlugin>()

dependencies {
    implementation(project(":board-entity"))
    implementation(project(":board-support"))

    implementation(Dependencies.BATCH)
    implementation(Dependencies.JPA)
    kapt(Dependencies.JPA_KAPT)
}
