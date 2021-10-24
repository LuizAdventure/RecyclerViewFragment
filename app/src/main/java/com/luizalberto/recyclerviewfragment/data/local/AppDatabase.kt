package com.luizalberto.recyclerviewfragment.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.luizalberto.recyclerviewfragment.model.Fruit

@Database(entities = [Fruit::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun FruitDao(): FruitDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "fruits")
                .fallbackToDestructiveMigration()
                .build()
    }

}