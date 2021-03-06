package com.example.hotelapk.detailshotel

import com.example.hotelapk.register.HotelRepository

class HotelDetailsPresenter(
    private val view: HotelDetailsView,
    private val repository: HotelRepository
) {

    fun loadHotelDetails(id: Long){
        repository.hotelById(id){ hotel ->
            if (hotel != null) {
                view.showHotelsDetails(hotel)
            } else {
                view.errorHotelNotFound()
            }
        }
    }
}