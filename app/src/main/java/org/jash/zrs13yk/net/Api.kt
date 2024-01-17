package org.jash.zrs13yk.net

import io.reactivex.Observable
import org.jash.zrs13yk.Bean.FaxianBean
import org.jash.zrs13yk.Bean.FenleiBean
import org.jash.zrs13yk.Bean.HomeBean
import org.jash.zrs13yk.Bean.MainBean
import org.jash.zrs13yk.Bean.MainData
import org.jash.zrs13yk.Bean.UserBean
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {
    @POST("/user/login")
    fun login(
        @Query("password") password:String,
        @Query("username") username:String,
    ):Observable<UserBean>

    @GET("/videomulti/getRecommendMutilVideo")
    fun home(
        @Query("page")     page:Int,
        @Query("pagesize") size:Int,
    ):Observable<HomeBean>
    @GET("/videosimple/getRecommendSimpleVideo")
    fun faxian(
        @Query("page")     page:Int,
        @Query("pagesize") size:Int,
    ):Observable<FaxianBean>
    @GET("/videotype/getSimpleType")
    fun fenlei():Observable<FenleiBean>
    @GET("/videoauthor/getAuthorById")
    fun main(
        @Query("userid") id :String
    ):Observable<MainBean>
}