package org.jash.zrs13yk.Bean

data class MainBean(
    val code: Int,
    val `data`: MainData,
    val msg: String
)

data class MainData(
    val author_desc: String,
    val avatar_url: String,
    val ctime: String,
    val description: String,
    val followerscount: String,
    val id: Int,
    val name: String,
    val user_id: String,
    val verifycode: String
)