object Dependencies {

    val API = listOf(
        "org.springframework.boot:spring-boot-starter-web",
        "org.springframework.boot:spring-boot-starter-validation",
        "org.springframework.data:spring-data-commons",
        "org.springdoc:springdoc-openapi-ui:${Versions.springDocVersion}",
        "org.springdoc:springdoc-openapi-kotlin:${Versions.springDocVersion}"
    )

    val BATCH = listOf(
        "org.springframework.boot:spring-boot-starter-batch",
        "org.springframework.cloud:spring-cloud-starter-task:${Versions.springCloudTaskVersion}",
        "org.mariadb.jdbc:mariadb-java-client:2.6.0"
    )

    val JPA = listOf(
        "org.springframework.boot:spring-boot-starter-data-jpa",
        "com.querydsl:querydsl-jpa:${Versions.querydslVersion}:jakarta",
    )

    val JPA_KAPT = listOf(
        "com.querydsl:querydsl-apt:${Versions.querydslVersion}:jakarta",
        "jakarta.persistence:jakarta.persistence-api",
        "jakarta.annotation:jakarta.annotation-api"
    )

    val MYSQL = listOf(
        "mysql:mysql-connector-java:8.0.28"
    )

    val REDIS = listOf(
        "org.springframework.boot:spring-boot-starter-data-redis"
    )

    val REDIS_LOCK = listOf(
        "org.redisson:redisson-spring-boot-starter:${Versions.redissonVersion}"
    )

    val SECURITY = listOf(
        "org.springframework.boot:spring-boot-starter-security"
    )

    val FEIGN = listOf(
        "org.springframework.cloud:spring-cloud-starter-openfeign:${Versions.springCloudVersion}",
        "io.github.openfeign:feign-okhttp:10.10.1"
    )

    val IIMS = listOf(
        "com.navercorp.iims:samesite-secure-filter:0.0.1",
        "com.nhncorp.iims2:dejava:2.0.0-p1"
    )

    val VOS = listOf(
        "com.amazonaws:aws-java-sdk-s3:1.12.262"
    )

    val CSV = listOf(
        "org.apache.commons:commons-csv:1.9.0",
        "com.ibm.icu:icu4j:71.1" // 파일의 유효한 인코딩 여부를 확인하는 데 사용
    )

    val KAFKA = listOf(
        "org.springframework.kafka:spring-kafka",
        "org.apache.kafka:kafka_2.12:${Versions.confluentKafkaVersion}",
        "org.apache.kafka:kafka-clients:${Versions.confluentKafkaVersion}",
        "org.springframework.cloud:spring-cloud-stream-binder-kafka:${Versions.springCloudStreamVersion}"
    )

    val KAFKA_STREAM = listOf(
        "org.springframework.cloud:spring-cloud-stream:${Versions.springCloudStreamVersion}",
        "org.springframework.cloud:spring-cloud-stream-binder-kafka-streams:${Versions.springCloudStreamVersion}"
    )

    val AVRO = listOf(
        "org.apache.avro:avro:1.11.1",
        "io.confluent:kafka-avro-serializer:7.2.1",
        "io.confluent:kafka-streams-avro-serde:7.2.1"
    )

    val JACKSON = listOf(
        "com.fasterxml.jackson.module:jackson-module-kotlin",
        "org.jetbrains.kotlin:kotlin-reflect",
        "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.4"
    )

    val LOGGING = "io.github.microutils:kotlin-logging-jvm:2.1.23"

    val TEST = listOf(
        "org.jetbrains.kotlin:kotlin-test",
        "io.mockk:mockk:1.12.3",
        "org.springframework.boot:spring-boot-starter-test"
    )
}
