package com.example.readyrecipe

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
@Dao
interface IProduct {
    @Query("SELECT * FROM product")
    fun getAll(): LiveData<List<Product>>

    @Query("SELECT * FROM product WHERE name LIKE :first LIMIT 1")
    fun findByName(first: String): Product

    @Insert
    fun insertAll(vararg products: Product)

    @Delete
    fun delete(user: Product)
}