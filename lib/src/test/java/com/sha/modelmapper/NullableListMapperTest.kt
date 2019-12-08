package com.sha.modelmapper

import org.junit.Before
import org.junit.Test

class NullableListMapperTest {

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
        val users = NullableListMapper(UserMapper()).map(userDtoList)
        users!!.forEachIndexed { index, user -> assert(user.name == userDtoList!![index].name) }
        assert(users.size == 3)
    }

    @Test
    fun testMap_returnNullIfInputNull() {
        userDtoList = null
        val users = NullableListMapper(UserMapper()).map(userDtoList)
        assert(users == null)
    }

    @Test
    fun testMap_returnNullIfInputEmpty() {
        userDtoList = emptyList()
        val users = NullableListMapper(UserMapper()).map(userDtoList)
        assert(users == null)
    }
}