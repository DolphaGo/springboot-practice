package me.dolphago.exception

import mu.KotlinLogging
import org.springframework.batch.item.file.FlatFileParseException
import org.springframework.batch.repeat.RepeatContext
import org.springframework.batch.repeat.exception.ExceptionHandler
import org.springframework.stereotype.Component

@Component
class MyExceptionHandler : ExceptionHandler {

    private val log = KotlinLogging.logger { }

    @Throws(Throwable::class)
    override fun handleException(context: RepeatContext, throwable: Throwable) {
        if (IllegalStateException::class.java.isInstance(throwable)) {
            log.warn { "[${getExceptionCauseClassSimpleName(throwable)}] ${throwable.message}" }
            return
        }

        throw throwable
    }

    private fun getExceptionCauseClassSimpleName(e: Throwable): String {
        if (e.stackTrace.isEmpty()) {
            return ""
        }
        val className = e.stackTrace[0].className
        return className.substring(className.lastIndexOf('.') + 1)
    }
}
