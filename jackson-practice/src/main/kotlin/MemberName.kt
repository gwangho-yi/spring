package com.example

import com.fasterxml.jackson.annotation.JsonValue

data class MemberName(
    @JsonValue
    val memberName: String
)
