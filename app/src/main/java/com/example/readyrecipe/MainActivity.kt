package com.example.readyrecipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.example.readyrecipe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(Fragment_home())
        binding.bottomBar.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.mHome -> replaceFragment(Fragment_home())
                R.id.mNote -> replaceFragment(Fragment_recipe())
                R.id.mSetting -> replaceFragment(Fragment_setting())
                R.id.mFridge -> replaceFragment(Fragment_fridge())

                else -> {

                }
            }

            true
        }


        //меняю цвет нижнего бара
        window.navigationBarColor = resources.getColor(R.color.white)


    }

    //основной метод для смены фрагментов в контейнере fragment_main
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_main, fragment)
        fragmentTransaction.commit()

    }




    fun goToFridge(view: View) {
        val goToFridgeIntent = Intent(this, FridgeActivity::class.java)
        startActivity(goToFridgeIntent)
        finish()


    }
}