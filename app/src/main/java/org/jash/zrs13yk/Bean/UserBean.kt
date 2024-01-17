package org.jash.zrs13yk.Bean

data class UserBean(
    val code: Int,
    val `data`: UserData,
    val msg: String
)

data class UserData(
    val accountid: Int,
    val ctime: String,
    val headImg: String,
    val id: Int,
    val isAuthor: Int,
    val nick: String,
    val password: String,
    val phone: String,
    val token: String,
    val username: String
)