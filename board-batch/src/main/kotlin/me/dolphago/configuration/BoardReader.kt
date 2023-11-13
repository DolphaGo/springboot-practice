package me.dolphago.configuration

import me.dolphago.entity.Board
import mu.KotlinLogging
import org.springframework.batch.item.ItemStreamReader

class BoardReader : ItemStreamReader<Board> {

    private val log = KotlinLogging.logger { }
    override fun read(): Board? {
        TODO("Not yet implemented")
    }

}
