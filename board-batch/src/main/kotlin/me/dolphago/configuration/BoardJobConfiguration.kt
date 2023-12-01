package me.dolphago.configuration

import jakarta.persistence.EntityManagerFactory
import me.dolphago.entity.Board
import me.dolphago.exception.MyExceptionHandler
import mu.KotlinLogging
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.batch.item.database.JpaCursorItemReader
import org.springframework.cloud.task.configuration.EnableTask
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class BoardJobConfiguration(
    val transactionManager: PlatformTransactionManager,
    val entityManagerFactory: EntityManagerFactory
) {

    private val log = KotlinLogging.logger { }

    @Bean
    fun boardJob(jobRepository: JobRepository): Job {
        return JobBuilder("boardJob", jobRepository)
            .incrementer(RunIdOnlyIncrementer())
            .start(boardStep(jobRepository))
            .build()
    }

    @Bean
    fun boardStep(jobRepository: JobRepository): Step {
        return StepBuilder("boardStep", jobRepository)
            .chunk<Board, String>(100, transactionManager)
            .reader(boardReader())
            .processor(boardProcessor())
            .writer(boardWriter())
            .exceptionHandler(MyExceptionHandler())
            .transactionManager(transactionManager)
            .build()
    }

    @StepScope
    @Bean
    fun boardReader(): JpaCursorItemReader<out Board> {
        val reader = JpaCursorItemReader<Board>()
        val provider = BoardProvider()
        reader.setQueryProvider(provider)
        reader.setEntityManagerFactory(entityManagerFactory)
        return reader

    }

    @StepScope
    @Bean
    fun boardProcessor(): ItemProcessor<in Board, out String> {
        return ItemProcessor {
            log.info { "board => $it" }
            "[${it.title}] ${it.body}"
        }
    }

    @StepScope
    @Bean
    fun boardWriter(): ItemWriter<in String> {
        return ItemWriter {
            it.items.forEach {
                log.info { "[Writer] items => $it" }
            }
        }
    }
}
