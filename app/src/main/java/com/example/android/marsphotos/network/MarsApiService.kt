package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

// extract JSON -> Kotlin data class
private val moshi = Moshi
    .Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
// retrofit returns json response: String
// to work with JSON, need MoshiConverterFactory -> which extracts JSON
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
// Defines how Retrofit talks with web server using HTTP requests
interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}
// Singleton - single object, available in public, new obj won't be created on accessing
// MarsApi.retrofitService the second time
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}
