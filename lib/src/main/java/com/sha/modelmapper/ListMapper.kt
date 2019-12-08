package com.sha.modelmapper

interface ListMapperInterface<I, O>: Mapper<List<I>, List<O>>

class ListMapper<I, O>(private val mapper: Mapper<I, O>) : ListMapperInterface<I, O> {

    override fun map(input: List<I>): List<O> {
        return input.map { mapper.map(it) }
    }

}
