package com.jaisonmacklin.test.marsroverphotogalleryapp.api

import com.jaisonmacklin.test.marsroverphotogalleryapp.models.PhotoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceInterface {

    @GET("photos")
    fun getPhotos(
        @Query("sol") sol: Int,
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Call<PhotoResponse?>
}