package com.luizalberto.recyclerviewfragment.data.repository






import com.luizalberto.recyclerviewfragment.api.ApiService
import com.luizalberto.recyclerviewfragment.data.local.FruitDao
import com.luizalberto.recyclerviewfragment.model.Fruit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService,
    private val fruitDao: FruitDao
) {

    fun getFruits(): Flow<List<Fruit>> {
        return  fruitDao.getAllFruits()
    }

    suspend fun refreshFruits() {
        apiService.getFruits().also { fruitDao.insertAllFruits(it) }
    }

}