package com.example.hotelapk.detailshotel

import com.example.hotelapk.register.Hotel

interface HotelDetailsView {
    fun showHotelsDetails(hotel: Hotel)
    fun errorHotelNotFound()
}