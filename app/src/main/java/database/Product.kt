package com.example.readyrecipe

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @ColumnInfo(name = "name") var name:String?,
    @ColumnInfo(name = "count") var count:String,
    @ColumnInfo(name = "unit") var unit:String?
)
{
    @PrimaryKey(autoGenerate = true) var uid:Int=0
}
