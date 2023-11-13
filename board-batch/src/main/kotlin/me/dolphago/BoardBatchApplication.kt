package me.dolphago

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.task.configuration.DefaultTaskConfigurer
import org.springframework.cloud.task.configuration.TaskConfigurer
import org.springframework.context.annotation.Bean
import javax.sql.DataSource
import kotlin.system.exitProcess

@SpringBootApplication
class BoardBatchApplication {
    @Bean
    fun taskConfigurer(dataSource: DataSource): TaskConfigurer {
        return DefaultTaskConfigurer(dataSource)
    }
}

fun main(args: Array<String>) {
    exitProcess(SpringApplication.exit(runApplication<BoardBatchApplication>(*args)))
}
