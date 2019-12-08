package com.sha.modelmapper

interface NullableInputListMapperInterface<I, O>: Mapper<List<I>?, List<O>>

class NullableInputListMapper<I, O>(private val mapper: Mapper<I, O>)
    : NullableInputListMapperInterface<I, O> {

    override fun map(input: List<I>?): List<O> {
        return input?.map { mapper.map(it) }.orEmpty()
    }

}
