package com.example.readyrecipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import database.ProductsAdapter

class FridgeActivity : AppCompatActivity() {
    lateinit var listProduct:List<Product>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fridge)

        val products = ArrayList<Product>()
        products.add(Product("Молоко с нотками арбуза и ярким послевкусием", 5))
        products.add(Product("Вода", 3))
        products.add(Product("Сок", 2))
        products.add(Product("Мята", 125))
        setNewListProduct(products)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerFridge)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductsAdapter(listProduct, this)
    }


    fun setNewListProduct(_listProduct:List<Product>) {
        println("#sa")
        listProduct = _listProduct.filter {  it.count>0f }
    }

    fun addProduct(view: View) {
        val name = findViewById<EditText>(R.id.editName).text.toString()
        val unit = findViewById<EditText>(R.id.editUnit).text.toString()
        val count = findViewById<EditText>(R.id.editCount).text.toString()

        val t = Thread {

            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "product"
            ).build()
            val productDB = db.productDB()
            productDB.insertAll(Product(name,1))

            val products = productDB.getAll()
            println("###")
            println(products)
        }
        t.start()
        t.join()
    }
}