package com.example

import com.fasterxml.jackson.annotation.JsonProperty

class User(
    @field:JsonProperty("name")
    val name: String,
    @field:JsonProperty("age")
    val age: Int
) {
}