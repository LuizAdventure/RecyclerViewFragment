package com.luizalberto.recyclerviewfragment.data.repository





import com.luizalberto.recyclerviewfragment.api.ApiService
import com.luizalberto.recyclerviewfragment.data.local.FruitDao
import com.luizalberto.recyclerviewfragment.model.Fruit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

class FruitRepository @Inject constructor(
    private val apiService: ApiService,
    private val fruitDao: FruitDao
) {
    fun getFruits(): Flow<List<Fruit>> {
        return flow{
            fruitDao.getAllFruits()
        }
    }

    suspend fun refreshFruits() {
        apiService.fetchFruits().also { fruitDao.insertAllFruits(it) }
    }

}