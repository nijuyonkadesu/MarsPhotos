package com.example.android.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

// retrofit returns json respons: String
// to work with JSON, need ConverterFactory -> to work with Primitive datatype
// need ScalarsConverterFactory object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
// Defines how Retrofit talks with web server using HTTP requests
interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): String
}
// Singleton - single object, available in public, new obj won't be created on accessing
// MarsApi.retrofitService the second time
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}
