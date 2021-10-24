package com.luizalberto.recyclerviewfragment.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.luizalberto.recyclerviewfragment.model.Fruit

@Dao
interface FruitDao {

    @Insert(onConflict =  REPLACE)
    suspend fun insertFruit(fruit: Fruit)

    @Query("SELECT * FROM fruit WHERE id = :fruitId")
    fun getFruit(fruitId: Int): LiveData<Fruit>

    @Insert(onConflict = REPLACE)
    suspend fun insertAllFruits(fruits: List<Fruit>)

    @Query("SELECT * FROM fruit")
    fun getAllFruits(): LiveData<List<Fruit>>

}