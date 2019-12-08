ModelMapper
================
An abstraction for mapping models, write a mapper once, use everywhere.

It's a best practice, like in clean architecture, to create a model for reach domain, for example a DTO for network response, Entity for database, and so on. But mapping each model is something painful as you have to map objects, lists and deal with nullables. Here's where **ModelMapper** shines, just create a single mapper for the object and use it to map objects, Lists, and nullable Lists.

# Usage

``` kotlin
// Declare mapper
class UserMapper: Mapper<UserDto, User> {
    override fun map(input: UserDto): User = User(name = input.name, email = input.email)
}

// map UserDto to User
val user: User = UserMapper().map(userDto)

// map List<UserDto> to List<User>
val input: List<UserDto> = listOf(userDto, userDto)
val users: List<User> = ListMapper(UserMapper()).map(input)

// map List<UserDto>? to List<User>
val input: List<UserDto>? = null
val users: List<User> = NullableInputListMapper(UserMapper()).map(input)

// map List<UserDto> to List<User>?
val input: List<UserDto> = emptyList()
val users: List<User>? = NullableOutputListMapper(UserMapper()).map(input)

// map List<UserDto>? to List<User>?
var input: List<UserDto>? = null
val users = NullableListMapper(UserMapper()).map(input)

```

#### Gradle:
```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}

dependencies {
        implementation 'com.github.ShabanKamell:ModelMapper:x.y.z'
}

```
(Please replace x, y and z with the latest version numbers:  [![](https://jitpack.io/v/ShabanKamell/ModelMapper.svg)](https://jitpack.io/#ShabanKamell/ModelMapper))


### License

<details>
    <summary>
        click to reveal License
    </summary>
    
```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

</details>
