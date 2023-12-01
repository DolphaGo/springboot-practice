package me.dolphago.configuration

import com.querydsl.jpa.impl.JPAQuery
import me.dolphago.entity.Board
import me.dolphago.entity.QBoard
import me.dolphago.entity.QBoard.board
import mu.KotlinLogging
import org.springframework.batch.item.ItemStreamReader
import org.springframework.data.jpa.repository.support.Querydsl

class BoardProvider : AbstractJpaQueryDslQueryProvider<Board>() {

    override fun targetClass(): Class<Board> = Board::class.java

    override fun getQuery(querydsl: Querydsl): JPAQuery<Board> {
        return querydsl.createQuery<Board>()
            .from(board)
            .select(board)
    }

    override fun afterPropertiesSet() {}
}
