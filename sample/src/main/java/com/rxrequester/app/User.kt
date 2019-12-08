package com.rxrequester.app

import com.sha.modelmapper.Mapper

data class User(val name: String, val email: String)
data class UserDto(val name: String, val email: String)

class UserMapper: Mapper<UserDto, User> {
    override fun map(input: UserDto): User = User(name = input.name, email = input.email)
}