package com.sha.modelmapper

import org.junit.Before
import org.junit.Test

class NullableInputListMapperTest {

    private var userDtoList: List<UserDto>? = null

    @Before
    fun setup() {
        userDtoList = listOf(
                UserDto(name = "user1", email = "email1@domain.com"),
                UserDto(name = "user2", email = "email2@domain.com"),
                UserDto(name = "user3", email = "email3@domain.com"))
    }

    @Test
    fun testMap_returnCorrectOutput() {
        val users = NullableInputListMapper(UserMapper()).map(userDtoList)
        users.forEachIndexed { index, user -> assert(user.name == userDtoList!![index].name) }
        assert(users.size == 3)
    }

    @Test
    fun testMap_returnEmptyIfInputNull() {
        userDtoList = null
        val users = NullableInputListMapper(UserMapper()).map(userDtoList)
        assert(users.isEmpty())
    }

    @Test
    fun testMap_returnEmptyIfInputEmpty() {
        userDtoList = emptyList()
        val users = NullableInputListMapper(UserMapper()).map(userDtoList)
        assert(users.isEmpty())
    }
}