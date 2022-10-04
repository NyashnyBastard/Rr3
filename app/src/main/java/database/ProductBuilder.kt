package database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.readyrecipe.AppDatabase
import com.example.readyrecipe.Product


class ProductBuilder constructor(context: Context) {
    val context = context
    private val dbBuilder = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "product"
    ).fallbackToDestructiveMigration()
        .build()

    private val database = dbBuilder.productDB()

    fun showProducts() {
        val t = Thread {
            val products = database.getAll()
            println("###")
            println(Transformations.map(products) {
                println(it)
            })
        }
        t.start()
        t.join()
    }

    fun getProducts(): LiveData<List<Product>> {
        return database.getAll()
    }

    fun addProduct(product: Product) {
        println(product)
        val name = product.name
        product.name = name?.get(0)?.uppercase().plus(name?.substring(1))
        val t = Thread {
            database.insertAll(product)
        }
        t.start()
        t.join()
    }
}