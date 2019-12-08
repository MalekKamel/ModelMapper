package com.rxrequester.app

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.sha.modelmapper.ListMapper
import com.sha.modelmapper.NullableInputListMapper
import com.sha.modelmapper.NullableListMapper
import com.sha.modelmapper.NullableOutputListMapper

class MainActivity: Activity() {
    private var userDto = UserDto(name = "user", email = "email@domain.com")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mapModel()
        mapList()
        mapFromNullableList()
        mapToNullableList()
        mapNullableList()
    }

    private fun mapModel() {
        log(">>> map UserDto to User")

        val user: User = UserMapper().map(userDto)
        log(user.name)
        log(user.email)
    }

    private fun mapList() {
        log(">>> map [UserDto] to [User]")

        val input: List<UserDto> = listOf(userDto, userDto)
        val users: List<User> = ListMapper(UserMapper()).map(input)
        log("users.count: ${users.count()}")
    }

    /// produces empty if the input is null
    private fun mapFromNullableList() {
        log(">>> map [UserDto]? to [User]")

        var input: List<UserDto>? = null
        // map [UserDto]? to [User]
        // produces empty array as the array is null
        var users: List<User> = NullableInputListMapper(UserMapper()).map(input)
        // prints 0
        log("users.count: ${users.count()}")

        input = listOf(userDto, userDto)
        users = NullableInputListMapper(UserMapper()).map(input)
        // prints 2
        log("users.count: ${users.count()}")
    }

    /// produces null if the input is empty
    private fun mapToNullableList() {
        log(">>> map [UserDto] to [User]?")

        var input: List<UserDto> = emptyList()
        var users: List<User>? = NullableOutputListMapper(UserMapper()).map(input)
        // prints 0 cause it's null
        log("users.count: ${users?.count() ?: 0}), it's null")

        input = listOf(userDto, userDto)
        users = NullableInputListMapper(UserMapper()).map(input)
        // prints 2
        log("users.count: ${users.count()})")
    }

    /// produces null if the input is null or empty
    private fun mapNullableList() {
        log(">>> map [UserDto]? to [User]?")

        var input: List<UserDto>? = null
        // map [UserDto]? to [User]
        // produces empty array as the array is null
        var users: List<User>? = NullableListMapper(UserMapper()).map(input)
        // prints 0
        log("users.count: ${users?.count() ?: 0}, the input is null")

        input = emptyList()
        users = NullableListMapper(UserMapper()).map(input)
        // prints 0
        log("users.count: ${users?.count() ?: 0}, the input is empty")

        input = listOf(userDto, userDto)
        users = NullableListMapper (UserMapper()).map(input)
        // prints 2
        log("users.count: ${users?.count() ?: 0}")
    }
    
    private fun log(message: String) = Log.i("ModelMapper", message)
}