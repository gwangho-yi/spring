package com.example

import com.fasterxml.jackson.core.JsonEncoding
import com.fasterxml.jackson.core.JsonFactoryBuilder
import com.fasterxml.jackson.core.JsonToken
import java.io.ByteArrayOutputStream

fun main() {

    val factory = JsonFactoryBuilder().build()

    val output = ByteArrayOutputStream()

    // generator 생성
    val generator = factory.createGenerator(output, JsonEncoding.UTF8)

    generator.writeStartObject()  // {
    generator.writeStringField("name", "Gwangho")  // "name": "Gwangho"
    generator.writeNumberField("age", 30)       // "age": 30
    generator.writeEndObject()    // }

    generator.close()

    println(output.toString())  // 빈 문자열이거나 불완전!


    // parser 생성
    val parser = factory.createParser("""{"name":"Gwangho","age":30}""")

    while (parser.nextToken() != null) {
        when (parser.currentToken) {
            JsonToken.FIELD_NAME -> println("필드: ${parser.currentName}")
            JsonToken.VALUE_STRING -> println("문자열: ${parser.text}")
            JsonToken.VALUE_NUMBER_INT -> println("숫자: ${parser.intValue}")
            else -> {}
        }
    }


}

