package com.sha.modelmapper

interface Mapper<I, O> {
    fun map(input: I): O
}
