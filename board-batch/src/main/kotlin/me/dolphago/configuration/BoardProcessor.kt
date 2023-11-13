package me.dolphago.configuration

import me.dolphago.entity.Board
import mu.KotlinLogging
import org.springframework.batch.item.ItemProcessor

class BoardProcessor : ItemProcessor<Board, String> {

    private val log = KotlinLogging.logger { }
    override fun process(item: Board): String? {
        TODO("Not yet implemented")
    }

}
