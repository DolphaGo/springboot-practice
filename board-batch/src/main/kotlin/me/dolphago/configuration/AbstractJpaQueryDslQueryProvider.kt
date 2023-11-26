package me.dolphago.configuration

import com.querydsl.core.types.dsl.PathBuilder
import com.querydsl.core.types.dsl.PathBuilderFactory
import com.querydsl.jpa.impl.JPAQuery
import jakarta.persistence.Query
import org.springframework.batch.item.database.orm.AbstractJpaQueryProvider
import org.springframework.data.jpa.repository.support.Querydsl

abstract class AbstractJpaQueryDslQueryProvider<T> : AbstractJpaQueryProvider() {

    override fun createQuery(): Query {
        val builder: PathBuilder<T> = PathBuilderFactory().create(targetClass())
        val querydsl = Querydsl(entityManager, builder)

        return getQuery(querydsl).createQuery().unwrap(Query::class.java)
    }

    protected abstract fun targetClass(): Class<T>
    protected abstract fun getQuery(querydsl: Querydsl): JPAQuery<T>
}
