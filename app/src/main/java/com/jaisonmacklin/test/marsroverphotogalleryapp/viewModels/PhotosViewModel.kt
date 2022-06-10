package com.jaisonmacklin.test.marsroverphotogalleryapp.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.jaisonmacklin.test.marsroverphotogalleryapp.R
import com.jaisonmacklin.test.marsroverphotogalleryapp.api.ApiServiceInterface
import com.jaisonmacklin.test.marsroverphotogalleryapp.api.RetrofitInstance
import com.jaisonmacklin.test.marsroverphotogalleryapp.models.Photo
import com.jaisonmacklin.test.marsroverphotogalleryapp.models.PhotoResponse
import com.jaisonmacklin.test.marsroverphotogalleryapp.utils.Helper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class PhotosViewModel : ViewModel() {
    private val photos = MutableLiveData<PhotoResponse?>()
    private var currentPage = 1
    private val apiKey = Helper.API_KEY
    private val TAG = PhotosViewModel::class.java.name

    fun getPhotos() = photos

    fun getPhotosFromApi() {
        val retrofitInstance = RetrofitInstance.getRetrofitInstance()
            .create(ApiServiceInterface::class.java)

        val call = retrofitInstance.getPhotos(1000, apiKey, currentPage)
        call.enqueue(object : Callback<PhotoResponse?> {
            override fun onResponse(
                call: Call<PhotoResponse?>,
                response: Response<PhotoResponse?>
            ) {
                if (response.isSuccessful) {
                    Log.i(TAG, "(OnResponse) : response is successful")
                    photos.postValue(response.body())
                } else {
                    Log.i(TAG, "(OnResponse) : response is failed")
                    photos.postValue(null)
                }
            }

            override fun onFailure(call: Call<PhotoResponse?>, t: Throwable) {
                Log.i(TAG, "(OnFailure) : response is failed due to : ${t.message}")
                photos.postValue(null)
            }
        })
    }
}