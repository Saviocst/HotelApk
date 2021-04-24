package com.example.hotelapk.listhotel

import com.example.hotelapk.register.Hotel

interface HotelListView {
    fun showHotels(hotel: List<Hotel>)
    fun showHotelDetails(hotel: Hotel)
}