package com.sha.modelmapper

import org.junit.Before
import org.junit.Test

class MapperTest {

    private lateinit var userDto: UserDto

    @Before
    fun setup() {
        userDto = UserDto(name = "user", email = "email@domain.com")
    }

    @Test
    fun testMap_returnCorrectOutput() {
        val user = UserMapper().map(userDto)
        assert(user.name == userDto.name)
        assert(user.email == userDto.email)
    }

}