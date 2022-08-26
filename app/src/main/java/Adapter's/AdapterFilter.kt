package Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.readyrecipe.fragment_tablayout_categor
import com.example.readyrecipe.fragment_tablayout_ingr

class AdapterFilter(fm:FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when (position) {
            0-> {return fragment_tablayout_ingr()}
            1 -> {return fragment_tablayout_categor()}
            else ->{return fragment_tablayout_ingr()}

        }

    }

    override fun getCount(): Int {
        return 2
    }

}