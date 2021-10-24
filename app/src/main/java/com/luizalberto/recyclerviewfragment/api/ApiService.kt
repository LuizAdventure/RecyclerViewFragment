package com.luizalberto.recyclerviewfragment.api

import com.luizalberto.recyclerviewfragment.model.Fruit
import retrofit2.http.GET

interface ApiService {
    @GET("api/fruit/all")
    suspend fun getFruits() : List<Fruit>


    companion object {
        const val FRUITYVICE_API_URL = "https://www.fruityvice.com/"
    }
}