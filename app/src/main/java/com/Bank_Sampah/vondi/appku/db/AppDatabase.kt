package com.Bank_Sampah.vondi.appku.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.Bank_Sampah.vondi.appku.model.ModelDatabase

@Database(entities = [ModelDatabase::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun daoDatabase(): DaoDatabase?
}