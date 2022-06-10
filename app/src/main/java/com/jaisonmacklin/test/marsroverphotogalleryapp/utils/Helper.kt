package com.jaisonmacklin.test.marsroverphotogalleryapp.utils

class Helper {
    companion object {
        const val BASE_URL: String = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/"
        const val API_KEY: String = "WfX1LMqusR7ZOzna1I376V1MSzAKDdOKuIA4GTY8"

        fun httpToHttps(urlString: String): String {
            var url: String = urlString

            return if (url.startsWith("http://", 0))
                url.replace("http://", "https://")
            else
                url
        }
    }
}