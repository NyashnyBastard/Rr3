package Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.readyrecipe.Product
import com.example.readyrecipe.R

class ProductsAdapter(val products: List<Product>, _context: Context): RecyclerView.Adapter<ProductsAdapter.PlantHolder>() {
    var context = _context
    class PlantHolder(item: View): RecyclerView.ViewHolder(item) {
        val textTitle: TextView = item.findViewById(R.id.textName)
        val editCount: TextView = item.findViewById(R.id.editAddCount)
        val textUnit: TextView = item.findViewById(R.id.textUnit)
        fun bind(product: Product, context: Context) {
            textTitle.text = product.name
            editCount.text = product.count
            textUnit.text = product.unit

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_product, parent, false)

        return PlantHolder(view)

    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        val product = products.get(position)
        holder.bind(product, context)
        holder.editCount.setOnFocusChangeListener { view, isFocus ->
            if (!isFocus) {
                println("#lost")
                try {
                    val product = products.get(position)
                    product.count = holder.editCount.text.toString()
                    println(products)
                } catch (e: Exception) {
                    println(e.message)
                }
            }
        }
    }


    override fun getItemCount(): Int {
        return products.size
    }
}