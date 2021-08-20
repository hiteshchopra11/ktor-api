package com.example.entities

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object UserEntity : Table<Nothing>("users") {
    val id = int("id").primaryKey()
    val userName = varchar("username")
    var password = varchar("password")
}