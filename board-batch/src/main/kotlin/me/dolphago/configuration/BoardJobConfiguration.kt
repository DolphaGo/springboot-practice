package me.dolphago.configuration

import me.dolphago.entity.Board
import me.dolphago.exception.MyExceptionHandler
import mu.KotlinLogging
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.cloud.task.configuration.EnableTask
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@EnableTask
@Configuration
class BoardJobConfiguration(
    val transactionManager: PlatformTransactionManager
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
            .chunk<Board, String>(1, transactionManager)
            .reader(BoardReader())
            .processor(BoardProcessor())
            .writer(BoardWriter())
            .exceptionHandler(MyExceptionHandler())
            .transactionManager(transactionManager)
            .build()
    }
}
