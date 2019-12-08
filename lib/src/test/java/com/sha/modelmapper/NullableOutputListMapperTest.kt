package com.sha.modelmapper

import org.junit.Before
import org.junit.Test

class NullableOutputListMapperTest {

    private lateinit var userDtoList: List<UserDto>

    @Before
    fun setup() {
        userDtoList = listOf(
                UserDto(name = "user1", email = "email1@domain.com"),
                UserDto(name = "user2", email = "email2@domain.com"),
                UserDto(name = "user3", email = "email3@domain.com"))
    }

    @Test
    fun testMap_returnCorrectOutput() {
        val users = NullableOutputListMapper(UserMapper()).map(userDtoList)
        users!!.forEachIndexed { index, user -> assert(user.name == userDtoList[index].name) }
        assert(users.size == 3)
    }

    @Test
    fun testMap_returnEmptyIfInputNull() {
        userDtoList = emptyList()
        val users = NullableInputListMapper(UserMapper()).map(userDtoList)
        assert(users.isEmpty())
    }
}