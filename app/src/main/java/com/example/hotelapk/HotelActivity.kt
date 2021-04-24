package com.example.hotelapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hotelapk.detailshotel.HotelDetailsActivity
import com.example.hotelapk.detailshotel.HotelDetailsFragment
import com.example.hotelapk.listhotel.HotelListFragment
import com.example.hotelapk.register.Hotel

class HotelActivity : AppCompatActivity(), HotelListFragment.OnHotelClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onHotelClick(hotel: Hotel) {

        if (isTablet()) {

            showDetailsFragment(hotel.id)

        } else if (isSmartphone()) {

            showDetailsActivity(hotel.id)

        }
    }

    private fun isTablet() = resources.getBoolean(R.bool.tablet)

    private fun isSmartphone() = resources.getBoolean(R.bool.smartphone)

    private fun showDetailsFragment(hotelId: Long){
        val fragment = HotelDetailsFragment.newInstance(hotelId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.details, fragment, HotelDetailsFragment.TAG_DETAILS)
            .commit()
    }

    private fun showDetailsActivity(hotelId: Long){
        HotelDetailsActivity.open(this, hotelId)
    }


}