package com.example.readyrecipe

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @ColumnInfo(name = "name") val name:String?,
    @ColumnInfo(name = "count") var count:Int = 0
)
{
    @PrimaryKey(autoGenerate = true) var uid:Int=0
}
