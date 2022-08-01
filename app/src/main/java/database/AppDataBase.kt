package com.example.readyrecipe

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase  : RoomDatabase() {
    abstract fun productDB(): IProduct
}
