package org.jash.zrs13yk.Bean

data class FenleiBean(
    val code: Int,
    val `data`: List<FenleiData>,
    val msg: String
)

data class FenleiData(
    val channelid: String,
    val haschild: Int,
    val id: Int,
    val pid: Int,
    val pinyin: String,
    val typename: String
)