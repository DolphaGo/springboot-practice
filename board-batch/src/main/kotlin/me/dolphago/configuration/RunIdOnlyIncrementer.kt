package me.dolphago.configuration

import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.support.RunIdIncrementer

class RunIdOnlyIncrementer : RunIdIncrementer() {
    private var key = RUN_ID_KEY

    override fun setKey(key: String) {
        this.key = key
    }

    override fun getNext(parameters: JobParameters?): JobParameters {
        val id = (parameters?.getLong(key) ?: 0) + 1
        return JobParametersBuilder(JobParameters()).addLong(key, id).toJobParameters()
    }

    companion object {
        private const val RUN_ID_KEY: String = "run.id"
    }
}
