package com.example.readyrecipe

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import database.ProductBuilder
import database.ProductsAdapter

class FridgeActivity : AppCompatActivity() {
    lateinit var db: ProductBuilder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fridge)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerFridge)
        val editAddUnit = findViewById<EditText>(R.id.editAddUnit)

        recyclerView.layoutManager = LinearLayoutManager(this)

        db = ProductBuilder(applicationContext)
        db.getProducts().observe(this, Observer {
            it.reversed()
            recyclerView.adapter = ProductsAdapter(it, this)
        })


        editAddUnit.setOnEditorActionListener { textView, i, keyEvent ->
            addProduct()
            return@setOnEditorActionListener false
        }

    }

    fun clickAddProduct(view: View) {
        val panelAddProduct = findViewById<LinearLayout>(R.id.layoutAddProduct)
        panelAddProduct.visibility = View.VISIBLE
        addProduct()
    }

    fun addProduct() {
        val name = findViewById<EditText>(R.id.editAddName)
        val unit = findViewById<EditText>(R.id.editAddUnit)
        val count = findViewById<EditText>(R.id.editAddCount)

        db.addProduct(Product(name.text.toString(), count.text.toString(), unit.text.toString()))

        name.setText("")
        count.setText("")

        name.hint = ""
        count.hint = ""

        Toast.makeText(this,"Вы успешно добавили продукт!", Toast.LENGTH_SHORT).show()

    }


}



