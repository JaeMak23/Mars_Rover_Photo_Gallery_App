package com.jaisonmacklin.test.marsroverphotogalleryapp.models

import com.google.gson.annotations.SerializedName

data class PhotoResponse(@SerializedName("photos") val photos: List<Photo>)
