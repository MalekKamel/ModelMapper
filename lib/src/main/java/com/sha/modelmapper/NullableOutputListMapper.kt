package com.sha.modelmapper

interface NullableOutputListMapperInterface<I, O>: Mapper<List<I>, List<O>?>

class NullableOutputListMapper<I, O>(private val mapper: Mapper<I, O>)
    : NullableOutputListMapperInterface<I, O> {

    override fun map(input: List<I>): List<O>? {
        return if (input.isEmpty()) null else input.map { mapper.map(it) }
    }
}